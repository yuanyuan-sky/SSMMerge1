package lession.dao;

import lession.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        long id = 1L;
        long phone = 12332211234L;
        int n = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("n = " + n);
    }

    @Test
    public void queryByIdWithSeckill() {

        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1, 12332211234L);
        System.out.println("successKilled = " + successKilled);
        System.out.println(successKilled.getSeckill());

    }
}