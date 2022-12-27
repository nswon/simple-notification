package org.notification;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;
import org.notification.exception.SendFailedException;

import java.util.concurrent.ExecutionException;

public class SendPushNotification {
    public static void send(PushMessage message) {
        try {
            sendPushNotification(message);
        } catch (ExecutionException | InterruptedException e) {
            throw new SendFailedException();
        }
    }

    private static void sendPushNotification(PushMessage message) throws ExecutionException, InterruptedException {
        Message pushMessage = createPushMessage(message);
        FirebaseMessaging.getInstance().sendAsync(pushMessage).get();
    }

    private static Message createPushMessage(PushMessage message) {
        return Message.builder()
                .setWebpushConfig(WebpushConfig.builder()
                        .setNotification(WebpushNotification.builder()
                                .setTitle(message.getTitle())
                                .setBody(message.getBody())
                                .build())
                        .build())
                .setToken(message.getToken())
                .build();
    }
}
