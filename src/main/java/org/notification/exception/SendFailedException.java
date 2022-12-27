package org.notification.exception;

public class SendFailedException extends RuntimeException {
    private static final String MESSAGE = "전송 실패";

    public SendFailedException() {
        super(MESSAGE);
    }
}
