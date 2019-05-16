-- 建立用户表
drop table if exists tb_user;
create table tb_user(
id char(32) not null,
user_name varchar(32) default null,
password varchar(32) default null,
name varchar(32) default null,
age int(10) default null,
sex int(2) default null,
birthday date default null,
created datetime default null,
updated datetime default null,
primary key(id)
) engine=InnoDB DEFAULT CHARSET=utf8;
-- 插入数据
insert into ssmdemo.tb_user(id,user_name, password, name, age, sex, birthday, created, updated) 
 values('1','wn','123456','王宁','22','1','1995-11-24', sysdate(), sysdate());
insert into ssmdemo.tb_user(id,user_name, password, name, age, sex, birthday, created, updated) 
 values('2','zs','123456','张三','23','1','1990-01-15', sysdate(), sysdate());