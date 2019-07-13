-- 秒杀执行存储过程
DELIMITER $$
-- 定义存储过程
-- row_count():返回上一条修改类型sql（delete,insert,update）的影响sql
-- row_count: 0:未修改数据；  >0 表示修改的行数 ； <0 sql错误/未执行修改sql
create procedure `seckill`.`execute_seckill`
    (in v_seckill_id bigint,in v_phone bigint,in v_kill_time timestamp,out r_result int)
begin
    declare insert_count  int default 0;
    start transaction ;
    insert ignore into success_killed
        (seckill_id, user_phone, create_time,state)
        values (v_seckill_id,v_phone,v_kill_time,1);
    select row_count() into  insert_count;
    if (insert_count = 0) then rollback ;
    set r_result = -1;
    elseif (insert_count < 0) then rollback ;
    set r_result = -2;
    else
        update seckill
        set number = number - 1
        where seckill_id = v_seckill_id
          and end_time > v_kill_time
          and start_time < v_kill_time
          and number > 0;
        select row_count() into insert_count;
        if (insert_count = 0) then rollback ;
            set r_result = 0;
        elseif (insert_count < 0) then  rollback ;
            set r_result = -2;
        else
            commit;
            set r_result = 1;
        end if ;
    end if ;
end;
$$ -- 存储过程定义结束

DELIMITER ;
set @r_result = -3;
-- 执行存储过程
call seckill.execute_seckill(1003,12345676543,now(),@r_result);
select  @r_result;
select  * from seckill.seckill
-- 存储过程
-- 1：存储过程优化：事务行级锁持有的时间
-- 2：不要过度依赖存储过程
-- 3：简单的逻辑可以应用存储过程