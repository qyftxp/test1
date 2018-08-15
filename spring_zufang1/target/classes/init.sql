select * from users where id = 1
insert into DISTRICT (ID, NAME)
values (1001, '东城');
insert into DISTRICT (ID, NAME)
values (1002, '西城');
insert into DISTRICT (ID, NAME)
values (1003, '石景山');
insert into DISTRICT (ID, NAME)
values (1006, '朝阳');
insert into DISTRICT (ID, NAME)
values (1000, '丰台');
insert into DISTRICT (ID, NAME)
values (1004, '海淀');

insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '知春路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '中关村大街', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, '学院路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '朝阳路', 1006);


insert into housetype ( NAME)
values ('一室一厅');
insert into housetype ( NAME)
values ('一室两厅');
insert into housetype ( NAME)
values ( '两室一厅');
insert into housetype ( NAME)
values ( '两室两厅');
insert into housetype ( NAME)
values ('三室一厅');
insert into housetype ( NAME)
values ( '三室两厅');
insert into housetype (NAME)
values ( '四室一厅');
insert into housetype ( NAME)
values ( '四室两厅');
insert into housetype ( NAME)
values ( '四十三厅');

insert into USERS ( NAME,password,telephone,username,isadmin)
values ( 'yc','a','1234433','a','1');

select * from users;
ID          int primary key auto_increment,       --信息id          
  USER_ID     int,                					--发信息人id
  TYPE_ID     int,                 					--房屋类型id
  TITLE       NVARCHAR(50),          				--信息标题
  DESCRIPTION text,     							--描述
  PRICE       double,                				--价格
  PUBDATE     DATE,                  				--发布日期
  FLOORAGE    int,                 					--面积
  CONTACT     VARCHAR(100),        					--联系方式
  STREET_ID   int    
insert into house values(1,1,1,'hhhhhh','bbbbbbbbbbbb',20,now(),20,'123456',1000);
select * from house;
delete from house where id=4;