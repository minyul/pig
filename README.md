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

<h3>Spring Framework Test With Kotlin</h3>