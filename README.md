# Pig Project

코드먹는 돼지

<h3>Spring Framework Test With Java</h3>

- [AssertJ : containsExactlyInAnyOrder](https://github.com/minyul/pig/commit/1368f538b9bb1cf04f4dfb13fe1b023d920dde5c)
  - List와 같은 반환 값들의 여러 값이 존재 하는지 
- [@MethodSource, @ParameterizedTest](https://github.com/minyul/pig/blob/main/api-test/src/test/java/me/minyul/service/NumberServiceTest.java)
  - 여러 경우의 케이스가 있을 때, 경계, 히든과 같은 여러 테스트 케이스
- [Redis 테스트 설정](https://github.com/minyul/pig/tree/main/api-test/src/test/java/me/minyul/config)
  - EmbeddedRedisTestConfig 설정
- [doThrow when -> assertThatThrownBy](https://github.com/minyul/pig/blob/main/api-test/src/test/java/me/minyul/service/InvoiceFilterTest.java)
  - Mock 에서 Exception 낼 때, 테스트
- [스텁 x 모의 o](https://github.com/minyul/pig/commit/64fd0d1f40272ccdf7c2b61877dbb94ba67a8a42)
  - 스텁으로 인한 하드 코딩이 아닌 좀 더 구체적인 기댓값 원할 때
- [Batch Step 테스트](https://github.com/minyul/pig/blob/main/batch-test/src/test/java/me/pig/batch/step/CoffeeStepTest.java)
  - 스프링 배치 step 추가
- [RestAssured 테스트](https://github.com/minyul/pig/blob/main/api-test/src/test/java/me/minyul/controller/HelloControllerRestAssuredTest.java)
  - RestAssured를 이용하여 통합 테스트 
  
<h3>Spring Framework Test With Kotlin</h3>




<h3>먹이</h3>

모의 객체에 대한 단점
- A -> B 상황에서 B에 대한 비지니스 로직을 수정해도 A 의 모의 객체를 통한 테스트는 여전히 통과한다.
- 실제 코드보다 테스트 코드에서 너무 많은 정보를 알고 있으므로 변경에 대한 한계를 느낄 수 있다.

모의 객체에 대한 생각
- B의 비지니스 로직을 수정하면 테스트 코드 또한 의존성을 찾아 고쳐줘야한다.
- 모든 코드에 모의 객체를 쓰는 것은 바람직하지 않다. 이럴 때, 쓰자
  - 의존성이 너무 느린 경우 (redis, db)
  - 외부 의존성 (email, s3)
  - 예외를 테스트 할 때
  - 실제 객체와 테스트할 때, 너무 많은 개발자의 비용이 들 경우
- 엔티티에 대한 비지니스 로직은 모의 객체를 쓰지 말자
- 네이티브, 유틸에 대한 비지니스 로직
- 단순한 의존성