package lession.service;

import lession.dto.Exposer;
import lession.dto.SeckillExecution;
import lession.entity.Seckill;
import lession.exception.RepeatKillException;
import lession.exception.SeckillCloseException;
import lession.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在使用者角度s设计接口
 * 三个方面：方法定义的粒度、参数、返回类型（return 类型/异常）
 * Description
 * Create By yuanyuan
 * date on 2019/7/8
 */

public interface SeckillService {
    /**
     *  查询所有秒杀接口
     */
    List<Seckill> getSeckillList();

    /**
     *  查询单个秒杀记录
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开始时输出秒杀接口地址，
     * 否则输出系统时间和秒杀时间
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException , RepeatKillException, SeckillCloseException;

    /**
     * 执行秒杀操作 by 存储过程
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws RepeatKillException
     * @throws SeckillCloseException
     */
    SeckillExecution executeSeckillPro(long seckillId, long userPhone, String md5)
            throws SeckillException , RepeatKillException, SeckillCloseException;
}
