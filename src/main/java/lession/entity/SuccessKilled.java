package lession.entity;

import java.util.Date;

public class SuccessKilled {

    private Long seckillId;

    private Long userPhone;

    private short state;

    private Date cretaTime;

    //多对一
    private Seckill seckill;

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCretaTime() {
        return cretaTime;
    }

    public void setCretaTime(Date cretaTime) {
        this.cretaTime = cretaTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", cretaTime=" + cretaTime +
                ", seckill=" + seckill +
                '}';
    }
}
