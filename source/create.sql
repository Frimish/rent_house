drop database if exists renting;
create database renting default charset=utf8;
use renting;

-- 用户信息表
create table t_user(
	id int primary key auto_increment comment '用户主键',
	loginname varchar(32) comment '用户登录名',
	nickname varchar(50) comment '昵称',
	password varchar(32) not null comment '密码',
	phone varchar(32) comment '手机号码',
	role varchar(32) comment '角色',
	email varchar(50) comment '邮箱',
	imageUrl varchar(256) comment '头像',
	loginDate datetime comment '登录日期',
	createDate datetime comment '创建日期',
	status int(1) default 1 comment '状态:1启用,-1禁用'
)engine=innodb default charset=utf8 comment '用户信息表';

-- 地区表
create table t_area(
	id int primary key auto_increment comment '地区主键',
	name varchar(150) comment '地区名称',
	parentId int comment '所属地区的id',
	foreign key(parentId) references t_area(id)
)engine=innodb default charset=utf8 comment '地区表';

-- 房源信息表
create table t_house_info(
	id int primary key auto_increment comment '房源信息主键',
	communityName varchar(256) comment '小区名称',
	areaId int comment '所在地区的id',
	roomNo text comment '门牌号,几幢几单元几室等等',
	rentType varchar(32) comment '租赁方式:整租,合租',
	houseType varchar(64) comment '户型:几室几厅',
	acreage double default 0 comment '面积m2',
	rent int default 0 comment '租金:元/月(不含小数)',
	payType varchar(32) comment '付款方式:月付,半年付,一年付...',
	floorInfo varchar(128) comment '楼层信息:几层-几层,共几层;例:2-3,2',
	houseState varchar(128) comment '房屋状态:毛坯,简装,精装,豪华装;方向:南,西南,东,东南,北,东北,西,西北,南北,东西',
	equips varchar(256) comment '房屋配套的设备等:床,冰箱,电视,空调,洗衣机,热水器,家具,宽带,可做饭,独立卫生间...全无',
	title varchar(256) comment '标题',
	detail longtext comment '详细介绍',
	linkman varchar(32) comment '联系人',
	phone varchar(32) comment '手机号码',
	userId int comment '用户表id',
	status int(1) default 1 comment '状态:1启用,-1禁用',
	createTime datetime comment '创建时间',
	updateTime datetime comment '更新时间',
	
	sign varchar(128) comment '品牌',
	metroDistance int comment '距离地铁的距离,单位米',
	lookAtAnyTime int(1) default 1 comment '可随时看房1,不可-1',
	balcony int(1) default 1 comment '1是独立阳台,-1不是',
	toilet int(1) default 1 comment '1是独卫,-1不是',
	count int default 0 comment '浏览房源信息人员数量',
	
	foreign key(userId) references t_user(id),
	foreign key(areaId) references t_area(id)
)engine=innodb default charset=utf8 comment '房源信息表';

-- 附件表
create table t_enclosure(
	id int primary key auto_increment comment '附件主键',
	path varchar(256) comment '附件的相对路径',
	houseInfoId int comment '附件所属的房源信息的id',
	status int(1) default 1 comment '状态:1启用,-1禁用',
	foreign key(houseInfoId) references t_house_info(id)
)engine=innodb default charset=utf8 comment '附件表';

create table t_view_house_info (
	id int primary key auto_increment comment '附件主键',
	houseInfoId int comment '附件所属的房源信息的id',
	userId int comment '用户表id',
	foreign key(userId) references t_user(id),
	foreign key(houseInfoId) references t_house_info(id)
)engine=innodb default charset=utf8 comment '浏览房源信息人员表';


insert into t_user (id,loginname,nickname,password,phone,role,email,imageUrl,loginDate,createDate,status) values (1, 'admin', '管理员', '3C3642386047237E0D3450666F757C65', '12345678901', 'admin', 'admin@itany.com', 'imageUrl', null, now(), 1);

-- 地区表初始数据
insert into t_area (id,name,parentId) values (1,'江苏',null);
insert into t_area (id,name,parentId) values (2,'南京',1);

insert into t_area (id,name,parentId) values (3,'玄武',2);
insert into t_area (id,name,parentId) values (4,'鼓楼',2);
insert into t_area (id,name,parentId) values (5,'建邺',2);
insert into t_area (id,name,parentId) values (6,'秦淮',2);
insert into t_area (id,name,parentId) values (7,'雨花台',2);
insert into t_area (id,name,parentId) values (8,'栖霞',2);
insert into t_area (id,name,parentId) values (9,'江宁',2);
insert into t_area (id,name,parentId) values (10,'浦口',2);
insert into t_area (id,name,parentId) values (11,'六合',2);
insert into t_area (id,name,parentId) values (12,'溧水',2);
insert into t_area (id,name,parentId) values (13,'高淳',2);

insert into t_area (id,name,parentId) values (null,'北京东路',3);
insert into t_area (id,name,parentId) values (null,'丹凤街',3);
insert into t_area (id,name,parentId) values (null,'后宰门',3);
insert into t_area (id,name,parentId) values (null,'锁金村',3);
insert into t_area (id,name,parentId) values (null,'卫岗',3);
insert into t_area (id,name,parentId) values (null,'玄武门',3);
insert into t_area (id,name,parentId) values (null,'樱驼花园',3);
insert into t_area (id,name,parentId) values (null,'月苑',3);
insert into t_area (id,name,parentId) values (null,'珠江路',3);
insert into t_area (id,name,parentId) values (null,'孝陵卫',3);
insert into t_area (id,name,parentId) values (null,'红山',3);
insert into t_area (id,name,parentId) values (null,'长江路',3);

insert into t_area (id,name,parentId) values (null,'福建路',4);
insert into t_area (id,name,parentId) values (null,'江东',4);
insert into t_area (id,name,parentId) values (null,'水佐岗',4);
insert into t_area (id,name,parentId) values (null,'湖南路',4);
insert into t_area (id,name,parentId) values (null,'华侨路',4);
insert into t_area (id,name,parentId) values (null,'龙江',4);
insert into t_area (id,name,parentId) values (null,'凤凰西街',4);
insert into t_area (id,name,parentId) values (null,'三牌楼',4);
insert into t_area (id,name,parentId) values (null,'宁海路',4);
insert into t_area (id,name,parentId) values (null,'许府巷',4);
insert into t_area (id,name,parentId) values (null,'大桥南路',4);
insert into t_area (id,name,parentId) values (null,'建宁路',4);
insert into t_area (id,name,parentId) values (null,'金陵小区',4);
insert into t_area (id,name,parentId) values (null,'热河南路',4);
insert into t_area (id,name,parentId) values (null,'五塘广场',4);
insert into t_area (id,name,parentId) values (null,'小市',4);
insert into t_area (id,name,parentId) values (null,'定淮门',4);

insert into t_area (id,name,parentId) values (null,'万达广场',5);
insert into t_area (id,name,parentId) values (null,'水西门',5);
insert into t_area (id,name,parentId) values (null,'茶南',5);
insert into t_area (id,name,parentId) values (null,'奥体',5);
insert into t_area (id,name,parentId) values (null,'南湖',5);
insert into t_area (id,name,parentId) values (null,'南苑',5);
insert into t_area (id,name,parentId) values (null,'兴隆',5);
insert into t_area (id,name,parentId) values (null,'应天西路',5);
insert into t_area (id,name,parentId) values (null,'江心洲',5);
insert into t_area (id,name,parentId) values (null,'奥南',5);

insert into t_area (id,name,parentId) values (null,'常府街',6);
insert into t_area (id,name,parentId) values (null,'朝天宫',6);
insert into t_area (id,name,parentId) values (null,'大光路',6);
insert into t_area (id,name,parentId) values (null,'瑞金路',6);
insert into t_area (id,name,parentId) values (null,'五老村',6);
insert into t_area (id,name,parentId) values (null,'新街口',6);
insert into t_area (id,name,parentId) values (null,'苜蓿园',6);
insert into t_area (id,name,parentId) values (null,'长乐路',6);
insert into t_area (id,name,parentId) values (null,'夫子庙',6);
insert into t_area (id,name,parentId) values (null,'洪家园',6);
insert into t_area (id,name,parentId) values (null,'集庆路',6);
insert into t_area (id,name,parentId) values (null,'秦虹',6);
insert into t_area (id,name,parentId) values (null,'来凤',6);
insert into t_area (id,name,parentId) values (null,'大明路',6);
insert into t_area (id,name,parentId) values (null,'海福巷',6);
insert into t_area (id,name,parentId) values (null,'中华门',6);
insert into t_area (id,name,parentId) values (null,'升州路',6);
insert into t_area (id,name,parentId) values (null,'光华门',6);

insert into t_area (id,name,parentId) values (null,'安德门',7);
insert into t_area (id,name,parentId) values (null,'小行',7);
insert into t_area (id,name,parentId) values (null,'能仁里',7);
insert into t_area (id,name,parentId) values (null,'宁南',7);
insert into t_area (id,name,parentId) values (null,'西善桥',7);
insert into t_area (id,name,parentId) values (null,'雨花新村',7);
insert into t_area (id,name,parentId) values (null,'铁心桥',7);
insert into t_area (id,name,parentId) values (null,'板桥街道',7);
insert into t_area (id,name,parentId) values (null,'梅山',7);
insert into t_area (id,name,parentId) values (null,'南京南站',7);

insert into t_area (id,name,parentId) values (null,'迈皋桥t',8);
insert into t_area (id,name,parentId) values (null,'马群',8);
insert into t_area (id,name,parentId) values (null,'炼油厂',8);
insert into t_area (id,name,parentId) values (null,'仙林',8);
insert into t_area (id,name,parentId) values (null,'晓庄',8);
insert into t_area (id,name,parentId) values (null,'仙林湖',8);
insert into t_area (id,name,parentId) values (null,'燕子矶',8);
insert into t_area (id,name,parentId) values (null,'龙潭街道',8);
insert into t_area (id,name,parentId) values (null,'尧化门',8);
insert into t_area (id,name,parentId) values (null,'万寿',8);
insert into t_area (id,name,parentId) values (null,'八卦洲',8);

insert into t_area (id,name,parentId) values (null,'将军大道',9);
insert into t_area (id,name,parentId) values (null,'岔路口',9);
insert into t_area (id,name,parentId) values (null,'百家湖',9);
insert into t_area (id,name,parentId) values (null,'东山街道',9);
insert into t_area (id,name,parentId) values (null,'江宁大学城',9);
insert into t_area (id,name,parentId) values (null,'上坊',9);
insert into t_area (id,name,parentId) values (null,'麒麟',9);
insert into t_area (id,name,parentId) values (null,'汤山',9);
insert into t_area (id,name,parentId) values (null,'禄口',9);
insert into t_area (id,name,parentId) values (null,'科学园',9);
insert into t_area (id,name,parentId) values (null,'横溪街道',9);
insert into t_area (id,name,parentId) values (null,'滨江开发区',9);
insert into t_area (id,name,parentId) values (null,'湖熟街道',9);
insert into t_area (id,name,parentId) values (null,'秣陵街道',9);
insert into t_area (id,name,parentId) values (null,'淳化街道',9);
insert into t_area (id,name,parentId) values (null,'谷里',9);
insert into t_area (id,name,parentId) values (null,'陶吴镇',9);
insert into t_area (id,name,parentId) values (null,'九龙湖',9);
insert into t_area (id,name,parentId) values (null,'南京南站',9);

insert into t_area (id,name,parentId) values (null,'桥北',10);
insert into t_area (id,name,parentId) values (null,'高新',10);
insert into t_area (id,name,parentId) values (null,'泰山',10);
insert into t_area (id,name,parentId) values (null,'沿江街道',10);
insert into t_area (id,name,parentId) values (null,'江浦街道',10);
insert into t_area (id,name,parentId) values (null,'顶山街道',10);
insert into t_area (id,name,parentId) values (null,'汤泉街道',10);
insert into t_area (id,name,parentId) values (null,'盘城街道',10);
insert into t_area (id,name,parentId) values (null,'桥林街道',10);
insert into t_area (id,name,parentId) values (null,'石桥镇',10);
insert into t_area (id,name,parentId) values (null,'乌江镇',10);
insert into t_area (id,name,parentId) values (null,'星甸街道',10);
insert into t_area (id,name,parentId) values (null,'永宁街道',10);

insert into t_area (id,name,parentId) values (null,'雄州街道',11);
insert into t_area (id,name,parentId) values (null,'山潘街道',11);
insert into t_area (id,name,parentId) values (null,'西厂门街道',11);
insert into t_area (id,name,parentId) values (null,'卸甲甸街道',11);
insert into t_area (id,name,parentId) values (null,'葛塘街道',11);
insert into t_area (id,name,parentId) values (null,'长芦街道',11);
insert into t_area (id,name,parentId) values (null,'龙池街道',11);
insert into t_area (id,name,parentId) values (null,'金牛湖街道',11);
insert into t_area (id,name,parentId) values (null,'四合街道',11);
insert into t_area (id,name,parentId) values (null,'横梁街道',11);

insert into t_area (id,name,parentId) values (null,'永阳街道',12);
insert into t_area (id,name,parentId) values (null,'白马镇',12);
insert into t_area (id,name,parentId) values (null,'溧水开发区',12);

insert into t_area (id,name,parentId) values (null,'高淳区',13);


insert into t_house_info (communityName,areaId,roomNo,rentType,houseType,acreage,rent,payType,floorInfo,houseState,equips,title,detail,linkman,phone,userId,status,createTime,updateTime,sign,metroDistance,lookAtAnyTime,balcony,toilet)
values ('小区aa','14','1幢,1单元,107室','合租','3,2','89','2000','月付','2,12','简装,东南','床,冰箱,电视,空调,洗衣机,热水器,家具,宽带','简装 拎包入住 设施齐全', '细节描述...','联系人a','12345678901','1','1',now(),now(),'链家','230','1','1','1');
insert into t_house_info (communityName,areaId,roomNo,rentType,houseType,acreage,rent,payType,floorInfo,houseState,equips,title,detail,linkman,phone,userId,status,createTime,updateTime,sign,metroDistance,lookAtAnyTime,balcony,toilet)
values ('小区xxx','15','4幢,2单元,107室','整租','2,1','72','1000','月付','6,11','简装,东南','床,冰箱,电视,空调,洗衣机,热水器,家具,宽带','简装 拎包入住 设施齐全', '细节描述...','联系人ccc','12345678902','1','1',now(),now(),'链家','235','1','1','1');


