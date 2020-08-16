package cn.uglyservant.common.global.exception;

public class GuliException extends RuntimeException {

    public GuliException(String message) {
        super(message);
    }

    public GuliException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
