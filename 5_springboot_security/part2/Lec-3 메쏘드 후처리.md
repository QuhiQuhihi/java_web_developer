# MethodSecurityInterceptor

필터를 통과한 request는 보안이 마킹된 메소드를 실행할 때마다 MethodSecurityInterceptor 의 검사를 받습니다. 이를 설정하는 곳이 GlobalMethodSecurityConfiguration 입니다.
여기에 securedEnabled=true 를 설정하면 @Secured 로 설정된 권한을 체크하고. prePostEnabled=true 로 설정하면 @PreAuthorize, @PreFilter, @PostAuthorize, @PostFilter 로 설정된 권한을 체크합니다.

MethodSecurityInterceptor 에서 중요한 멤버는 아래 세가지 입니다.

- AccessDecisionManager : @Secured 나 @PreAuthorize, @PreFilter 를 처리합니다.
- AfterInvocationManager : @PostAuthorize, @PostFilter 를 처리합니다.
- RunAsManager : 임시권한 부여

<img src="../images/fig-24-access-decision-manager.png" width="700" style="max-width:700px;width:100%;" />

## AfterInvocationManager

Authentication 통행증만 가지고는 권한 체크를 충분히 했다고 볼 수가 없습니다. 보통, 어떤 객체의 값을 변경해야 하는 경우에는 메소드에 들어오기 전에, 값을 조회하려고 하는 경우에는 값을 가져온 이후에 각각 접근 권한을 체크해줘야 합니다.

체크해야 할 대상이 한개라면 Pre/PostAuthorized 로 체크를 하면 되지만, 대상이 복수개라면 보통은 리스트로 묶이기 때문에 대상을 filtering을 해서 들어가거나 넘겨야 합니다.

물론, 메소드를 처리하는 중간에 권한을 검사해야 하는 경우도 있습니다. 이 경우는 Proxy 빈의 특징을 잘 파악해서 메서드 간에 권한 검사가 충분히 이루어지도록 annotation을 설계해서 처리할 수 있습니다.

### AfterInvocationProviderManager

```java
public Object decide(
  Authentication authentication,
  Object object,
  Collection<ConfigAttribute> config,
  Object returnedObject
) throws AccessDeniedException {

	Object result = returnedObject;
	for (AfterInvocationProvider provider : this.providers) {
		result = provider.decide(authentication, object, config, result);
	}
	return result;
}
```

### PostInvocationAdviceProvider

```java
public Object decide(
  Authentication authentication,
  Object object,
  Collection<ConfigAttribute> config,
  Object returnedObject
) throws AccessDeniedException {

	PostInvocationAttribute postInvocationAttribute = findPostInvocationAttribute(config);
	if (postInvocationAttribute == null) {
		return returnedObject;
	}
	return this.postAdvice.after(authentication, (MethodInvocation) object, postInvocationAttribute,
				returnedObject);
}
```

### ExpressionBasedPostInvocationAdvice

- GlobalMethodSecurityConfiguration 에서 expressHandler 를 ExpressionBasedPreInvocationAdvice 와 함께 공유합니다. 이 말은 @PreAuthorize @PreFilter 와 같은 SpEL 루트 객체를 가지고 작업한다는 말이 됩니다.

```java
public Object after(
  Authentication authentication,
  MethodInvocation mi,
  PostInvocationAttribute postAttr,
  Object returnedObject
) throws AccessDeniedException {

	PostInvocationExpressionAttribute pia = (PostInvocationExpressionAttribute) postAttr;
	EvaluationContext ctx = this.expressionHandler.createEvaluationContext(authentication, mi);
	Expression postFilter = pia.getFilterExpression();
	Expression postAuthorize = pia.getAuthorizeExpression();
	if (postFilter != null) {
		if (returnedObject != null) {
			returnedObject = this.expressionHandler.filter(returnedObject, postFilter, ctx);
		}
	}
	this.expressionHandler.setReturnObject(returnedObject, ctx);
	if (postAuthorize != null && !ExpressionUtils.evaluateAsBoolean(postAuthorize, ctx)) {
		throw new AccessDeniedException("Access is denied");
	}
	return returnedObject;
}

```
