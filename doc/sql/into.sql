CREATE TABLE `pomelo_user` (
`id`  integer NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`username`  varchar(64) NOT NULL COMMENT '用户名' ,
`pasword`  varchar(128) NULL COMMENT '密码' ,
`name`  varchar(64) NULL COMMENT '姓名' ,
`age`  integer NULL COMMENT '年龄' ,
PRIMARY KEY (`id`)
)
;