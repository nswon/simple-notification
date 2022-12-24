package org.example;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;

import java.util.concurrent.ExecutionException;

public class TaskdbPushMessage {
    private static final String TITLE = "TaskDB";
    private static final String BODY = "님이 답변을 등록하였습니다.";
    private static final String SEND_FAIL = "전송 실패";

    private static void send(String token, String nickname) {
        try {
            sendPushNotification(token, nickname);
        } catch (ExecutionException | InterruptedException e) {
            throw new IllegalArgumentException(SEND_FAIL);
        }
    }

    private static void sendPushNotification(String token, String nickname) throws ExecutionException, InterruptedException {
        Message message = createPushMessage(token, nickname);
        FirebaseMessaging.getInstance().sendAsync(message).get();
    }

    private static Message createPushMessage(String token, String nickname) {
        return Message.builder()
                .setWebpushConfig(WebpushConfig.builder()
                        .setNotification(WebpushNotification.builder()
                                .setTitle(TITLE)
                                .setBody(nickname + BODY)
                                .build())
                        .build())
                .setToken(token)
                .build();
    }
}
