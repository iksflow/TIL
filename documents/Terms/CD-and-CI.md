# CI / CD (Continuous Integration / Continuous Deployment or Continuous Delivery)

## Content
* 애플리케이션을 보다 짧은주기로 고객에게 제공하는 방법.
* 새로운 코드 통합으로 인해 개발 및 운영팀에 발생하는 문제 통합지옥(integration hell)을 해결하기 위한 솔루션.
<br>
CI(Continuous Integration) : 개발자를 위한 자동화 프로세스. CI를 구현해 놓는다면 애플리케이션의 수정사항을 정기적으로 빌드, 테스트해서 레포지토리에 병합해준다. <br>
여러명의 개발자가 동시에 개발을하며 발생하는 머지 충돌문제에 대한 솔루션이 될 수 있다.
CD(Continuous Delivery) : 운영팀을 위한 자동화 프로세스. 개발자가 레포지토리에 올려놓은 애플리케이션을 실시간으로 원하는 때에 제공할 수 있다. <br>
운영팀이 원하는 때에 애플리케이션에 변경사항을 실시간 서비스에 적용하고자 할 때 빠르게 제공할 수 있다는 장점이 있다.
젠킨스
## Summary
결과적으로 CI/CD는 파이프라인으로 표현되는 실제 프로세스를 의미하고, 애플리케이션 개발에 지속적인 자동화 및 지속적인 모니터링을 추가하는 것을 의미함.
## Review
애자일 개발 방법론과 잘 어울리는 솔루션이라고 생각된다. <br>
애플리케이션 최신화를 빠르게 적용하게 도와주는 도구.
## Question
소스 통합과정이 자동화가 되었다 하더라도 머지 충돌은 피해갈 수 없을텐데, 기술적으로 어떻게 해결하는것인지 궁금하다.
## Reference
* redhat - https://www.redhat.com/ko/topics/devops/what-is-ci-cd
