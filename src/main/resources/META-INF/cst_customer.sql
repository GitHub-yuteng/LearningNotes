/*创建客户表*/
CREATE TABLE cst_customer (
cust_id BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
cust_name VARCHAR(32) NOT NULL COMMENT '客户名称(公司名称)',
cust_source VARCHAR(32) DEFAULT NULL COMMENT '客户信息来源',
cust_industry VARCHAR(32) DEFAULT NULL COMMENT '客户所属行业',
cust_level VARCHAR(32) DEFAULT NULL COMMENT '客户级别',
cust_address VARCHAR(128) DEFAULT NULL COMMENT '客户联系地址',
cust_phone VARCHAR(64) DEFAULT NULL COMMENT '客户联系电话',
PRIMARY KEY (`cust_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*创建联系人表*/
CREATE TABLE cst_linkman (
lkm_id BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '联系人编号(主键)',
lkm_name VARCHAR(16) DEFAULT NULL COMMENT '联系人姓名',
lkm_gender CHAR(1) DEFAULT NULL COMMENT '联系人性别',
lkm_phone VARCHAR(16) DEFAULT NULL COMMENT '联系人办公电话',
lkm_mobile VARCHAR(16) DEFAULT NULL COMMENT '联系人手机',
lkm_email VARCHAR(64) DEFAULT NULL COMMENT '联系人邮箱',
lkm_position VARCHAR(16) DEFAULT NULL COMMENT '联系人职位',
lkm_memo VARCHAR(512) DEFAULT NULL COMMENT '联系人备注',
lkm_cust_id BIGINT(32) NOT NULL COMMENT '客户id(外键)',
PRIMARY KEY (`lkm_id`),
KEY `FK_cst_linkman_lkm_cust_id` (`lkm_cust_id`),
CONSTRAINT `FK_cst_linkman_lkm_cust_id` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
