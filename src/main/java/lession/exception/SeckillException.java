package lession.exception;

/**
 * Create By yuanyuan on 2019/7/8 9:14
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
