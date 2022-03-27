# 임시 권한 부여 : RunAsManager

기존에 @Secured 기반으로 작업된 사이트에서 필요에 따라 임시권한을 줄 수 있도록 설계된 것이 바로 RunAs 기능입니다.

특정 상황에서 특정 권한을 가진 사람은 특별히 임시권한을 주는 것입니다.

권한 체크가 복잡한 시스템일수록 특정 메소드에 진입하는데 여러가지 조건식이 붙을 수 있습니다. RunAsManager를 사용한다면 이런 조건식을 단순하게 만들어 줄 수 있는 바닐라 사탕이 될 수 있습니다.

### FilterSecurityInterceptor, MethodSecurityInterceptor

Security의 대표적인 두 Interceptor가 수행하는 로직은 아래와 같은 코드로 되어 있습니다.

```java
public Object invoke(MethodInvocation mi) throws Throwable {
  InterceptorStatusToken token = super.beforeInvocation(mi);
	Object result;
	try {
		result = mi.proceed();
	}
	finally {
			super.finallyInvocation(token);
  }
	return super.afterInvocation(token, result);
}
```

### AbstractSecurityInterceptor

임시 권한의 부여는 beforeInvocation 에서 RUN*AS* 권한을 체크해서

```java

protected InterceptorStatusToken beforeInvocation(Object object) {
	...

	// Attempt to run as a different user
	Authentication runAs = this.runAsManager.buildRunAs(authenticated, object, attributes);
	if (runAs != null) {
		SecurityContext origCtx = SecurityContextHolder.getContext();
		SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
		SecurityContextHolder.getContext().setAuthentication(runAs);
		// need to revert to token.Authenticated post-invocation
		return new InterceptorStatusToken(origCtx, true, attributes, object);
	}
	// no further work post-invocation
	return new InterceptorStatusToken(SecurityContextHolder.getContext(), false, attributes, object);

}

protected void finallyInvocation(InterceptorStatusToken token) {
	if (token != null && token.isContextHolderRefreshRequired()) {
		SecurityContextHolder.setContext(token.getSecurityContext());
	}
}

```

### RunAsManagerImpl

```java
public class RunAsManagerImpl implements RunAsManager, InitializingBean {

  public Authentication buildRunAs(
		Authentication authentication,
		Object object,
		Collection<ConfigAttribute> attributes
  ) {
		List<GrantedAuthority> newAuthorities = new ArrayList<>();
		for (ConfigAttribute attribute : attributes) {
			if (this.supports(attribute)) {
				GrantedAuthority extraAuthority = new SimpleGrantedAuthority(
						getRolePrefix() + attribute.getAttribute());
				newAuthorities.add(extraAuthority);
			}
		}
		if (newAuthorities.size() == 0) {
			return null;
		}
		// Add existing authorities
		newAuthorities.addAll(authentication.getAuthorities());
		return new RunAsUserToken(this.key, authentication.getPrincipal(), authentication.getCredentials(),
				newAuthorities, authentication.getClass());
	}
}

```
