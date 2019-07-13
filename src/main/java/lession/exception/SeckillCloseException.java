package lession.exception;

import lession.dto.SeckillExecution;

/**
 * 秒杀关闭异常
 * Create By yuanyuan on 2019/7/8 9:13
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
