## ExpressionVoter 테스트 하기

아래와 같이 시험지 클래스가 있다고 가정해 보겠습니다.

```java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paper {

    private Long paperId;
    private String title;
    private String tutorId;
    private List<String> studentIds;
    private State state;

    public static enum State {
        PREPARE, // 출제 중
        READY,  // 시험 시작
        END  // 시험 종료
    }
}

```

### Service

시험지를 서비스하는 서비스는 아래와 같은 기능을 제공합니다.

```java

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaperService implements InitializingBean {

    private HashMap<Long, Paper> paperDB = new HashMap<>();


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public void setPaper(Paper paper){
        paperDB.put(paper.getPaperId(), paper);
    }

    public List<Paper> getMyPapers(String username) {
        return paperDB.values().stream().filter(
                paper -> paper.getStudentIds().contains(username)
        ).collect(Collectors.toList());
    }

    public Paper getPaper(Long paperId) {
        return paperDB.get(paperId);
    }
}
```

## 사용자

- user1과 user2가 각각 학생이라고 하고.
- tutor1이 강사라고 한다면
- tutor1이 user1과 user2 에게 줄 시험지를 작성하고 있습니다.

## 테스트 시나리오

1. user1이 시험지를 조회한다.
2. user1이 user2의 시험지를 조회할 수 없다.
