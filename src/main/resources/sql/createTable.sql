-- 建立用户表
drop table if exists tb_user;
create table tb_user(
id int(11) not null,
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
alter table tb_user change column id id int not null comment '用户id';
alter table tb_user modify column user_name varchar(32) comment '用户名';
alter table tb_user modify column password varchar(32) comment '密码';
alter table tb_user modify column name varchar(32) comment '中文名';
alter table tb_user modify column age int comment '年龄';
alter table tb_user modify column sex int comment '性别1-男；0-女';
alter table tb_user modify column birthday date comment '出生日期';
alter table tb_user modify column created datetime comment '创建时间';
alter table tb_user modify column updated datetime comment '修改时间';
-- 插入数据
insert into ssmdemo.tb_user(id,user_name, password, name, age, sex, birthday, created, updated) 
 values(1,'wn','123456','王宁','22','1','1995-11-24', sysdate(), sysdate());
insert into ssmdemo.tb_user(id,user_name, password, name, age, sex, birthday, created, updated) 
 values(2,'zs','123456','张三','23','1','1990-01-15', sysdate(), sysdate());

 -- 创建订单表
drop table if exists tb_order;
 CREATE table tb_order(
 id int(11) comment '订单id' not null AUTO_INCREMENT ,
 user_id int(11) default null comment '用户id',
 order_number varchar(255) default null comment '订单编号',
 created datetime default null comment '创建时间',
 updated datetime default null comment '修改时间',
 primary key(id)
 )engine=InnoDB auto_increment=2 default charset=utf8;
 INSERT INTO tb_order VALUES (1,2,'201807010001',sysdate(),sysdate());

 -- 创建订单详情表
 drop table if exists tb_orderdetail;
create table tb_orderdetail(
id int(11) not null auto_increment,
order_id int(11) default null,
total_price decimal(10,0) default null,
item_id int(11) default null,
status int(10) unsigned zerofill default null comment '0-成功；非0-失败',
primary key(id)
);
alter table tb_orderdetail modify column id int not null comment '订单详情id';
alter table tb_orderdetail modify column order_id comment '订单id';
alter table tb_orderdetail modify column total_price decimal(10,0) comment '总金额';
alter table tb_orderdetail modify column item_id int comment '商品id';
alter table tb_orderdetail modify column status int comment '订单状态';
insert into values (1,1,199.0,2,0);
insert into values (2,1,19.0,1,1);

 -- 创建商品表
 drop table if exists tb_item;
create table tb_item(
id int(11) not null,
item_name varchar(255) not null,
item_price decimal (10,2) not null,
item_detail varchar(255) not null,
primary key(id)
)engine=InnoDB default charset=utf8;
alter table tb_item modify column id int not null comment '商品id';
alter table tb_item modify column item_name varchar(255) '商品名称';
alter table tb_item modify column item_price decimal(10,2) '商品单价';
alter table tb_item modify column item_price varchar(255) '商品描述';
insert into tb_item values(1,'手机',1111.11, '智能手机');
insert into tb_item values (2,'电脑',9999.90, '游戏本');