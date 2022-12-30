
본 샘플소스는 
스프링부트에서  URLClassLoader 를 이용하여 원격지의 클래스를 동적으로 로딩하여 실행해 보는 데모 소스를 작성한다.

- myservice 
    원격 웹서버에 배포할 소스 작성 maven 프로젝트 

- class-loading-demo
    원격소스를 동적로딩하여 실행할 스프링부트 프로젝트 

- 원격소스 배포 위치 
	http://127.0.0.1:8080/apps/myservice-1.0-SNAPSHOT.jar
    http://127.0.0.1:8080/apps/commons-math3-3.6.1.jar
