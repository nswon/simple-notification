package org.notification.exception;

public class FcmConfigException extends RuntimeException {
    private static final String MESSAGE = "FCM 설정 오류가 발생하였습니다.";

    public FcmConfigException() {
        super(MESSAGE);
    }
}
