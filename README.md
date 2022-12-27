## simple-notification: 간단하게 알람메세지를 보낼 수 있는 라이브러리
simple-notification은 fcm을 처음 접하거나 알람을 좀 더 쉽게 보낼 수 있을 때 사용할 수 있는 라이브러리 입니다. <br>
fcm을 좀 더 간단하게 설정할 수 있는 기능과, 메세지 정보가 담긴 클래스를 보내면 자동으로 보낼 수 있는 기능이 있습니다. 

## 빌드에 추가하기

Maven을 사용하여 종속성 추가
```xml
<repositories>
	<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
	</repository>
</repositories>
```
```xml
<dependency>
	    <groupId>com.github.nswon</groupId>
	    <artifactId>bssm-taskdb-notification-library</artifactId>
	    <version>3.0.1</version>
</dependency>
```
<br>

Gradle을 사용하여 종속성 추가
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

```gradle
dependencies {
	implementation 'com.github.nswon:bssm-taskdb-notification-library:3.0.1'
}
```

## 적용 예시

FCM을 설정할 때 아래와 같이 간단하게 사용할 수 있습니다.
```java
@Component
public class FcmConfig {
    private static final String FIREBASE_CONFIG_PATH = "taskdb-b4857-firebase-adminsdk-bbv2u-ff04edbe81.json";
    private static final String PROJECT_ID = "154549871574";

    @PostConstruct
    public void initialize() throws IOException {
        FirebaseOptions options = CreateFirebaseOptions.create(new ClassPathResource(FIREBASE_CONFIG_PATH).getInputStream(), PROJECT_ID);
        FirebaseApp.initializeApp(options);
    }
}
```

푸시 메세지를 보내는 로직은 다음과 같습니다.
```java
SendPushNotification.send(message);
```

message는 PushMessage 클래스여야 합니다. Builder 패턴으로 생성할 수 있습니다.
```java
    private PushMessage of(String token, String nickname) {
        return PushMessage.builder()
                .token(token)
                .title("Taskdb")
                .body(nickname + "님이 답변을 등록하였습니다.")
                .build();
    }
```
