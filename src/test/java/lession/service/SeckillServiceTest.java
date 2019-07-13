package lession.service;

import lession.dto.Exposer;
import lession.dto.SeckillExecution;
import lession.entity.Seckill;
import lession.exception.RepeatKillException;
import lession.exception.SeckillCloseException;
import lession.exception.SeckillException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {

        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() {
        Seckill seckill = seckillService.getById(1000);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void SeckillLogic() {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}", exposer);
        if (exposer.isExposed()) {
            SeckillExecution securityException = null;
            long phone = 12345678678L;
            try {
                securityException = seckillService.executeSeckill(id, phone, exposer.getMd5());
            } catch (RepeatKillException e) {
                e.printStackTrace();
                logger.error(e.getMessage(), e);
            } catch (SeckillCloseException e) {
                e.printStackTrace();
                logger.error(e.getMessage(), e);
            }
            logger.info("result={}", securityException);
        } else {
            //秒杀未开启
            logger.warn("exposer={}", exposer);
        }
    }

    @Test
    public void executeSeckillPro() {
        long seckillId = 1001;
        long phone = 13470035986L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillPro(seckillId, phone, md5);
            logger.info(execution.getStateInfo());

        }
    }
}