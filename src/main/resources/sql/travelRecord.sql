-- 创建表结构
create table travelrecord (id bigint not null primary key,user_id varchar(100),traveldate DATE, fee decimal,days int);
-- 插入数据
insert into travelrecord(id,user_id,traveldate,fee,days) values(1,@@hostname,20191010,100,10);
insert into travelrecord(id,user_id,traveldate,fee,days) values(5000001,@@hostname,20191011,100,10);

