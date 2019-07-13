package lession.dao;

import lession.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Description SuccessKilledDao
 * Create By yuanyuan
 * date on 2019/7/7
 */
public interface SuccessKilledDao {

    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);


}
