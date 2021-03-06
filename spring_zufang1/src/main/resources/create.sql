create database zufang;
select * from users;

--管理员表     kxjjjj
create table admin(
	id int primary key auto_increment,  
	name varchar(50),
	password varchar(100)
);

--用户表
create table USERS
(
  ID        int primary key auto_increment,        --用户id 
  NAME      VARCHAR(50),          				   --登录名
  PASSWORD  VARCHAR(50),          				   --用户密码
  TELEPHONE VARCHAR(15), 						   --电话       
  USERNAME  VARCHAR(50),          				   --真实名字
  ISADMIN   VARCHAR(5)             				   --是否管理员
);
--地区表
create table DISTRICT
(
  ID   int primary key,          				--地区id
  NAME VARCHAR(50) 								--地区名
);
--街道表
create table STREET
(					
  ID        int primary key,					--街道id      
  NAME        VARCHAR(50),        				--街道名
  DISTRICT_ID int               				--地区id
);


--房屋类型表
create table housetype
(
  ID    int primary key auto_increment,            --类型id
  NAME VARCHAR(20) 								   --类型名
)
--房屋信息表
create table HOUSE
(
  ID          int primary key auto_increment,       --信息id          
  USER_ID     int,                					--发信息人id
  TYPE_ID     int,                 					--房屋类型id
  TITLE       NVARCHAR(50),          				--信息标题
  DESCRIPTION text,     							--描述
  PRICE       double,                				--价格
  PUBDATE     DATE,                  				--发布日期
  FLOORAGE    int,                 					--面积
  CONTACT     VARCHAR(100),        					--联系方式
  STREET_ID   int                 					--街道id
);

select * from house;

delete from house;
--阿斯顿发生的点点滴滴滴答滴答合适的�