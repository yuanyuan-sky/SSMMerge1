package lession.exception;

/**
 * 重复秒杀异常（运行期异常），Spring的事务管理默认只在发生运行期异常才会回滚
 * Create By yuanyuan on 2019/7/8 9:09
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
