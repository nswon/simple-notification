package org.notification;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PushMessage {
    private String token;
    private String title;
    private String body;

    public PushMessage() {
    }

    @Builder
    public PushMessage(String token, String title, String body) {
        this.token = token;
        this.title = title;
        this.body = body;
    }
}
