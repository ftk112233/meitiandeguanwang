DROP TABLE IF EXISTS ums_user ; /*SkipError*/
CREATE TABLE ums_user(
    `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    create_by BIGINT    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by BIGINT    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    username VARCHAR(32) NOT NULL   COMMENT '用户名' ,
    `password` VARCHAR(128) NOT NULL   COMMENT '密码' ,
    `status` INT(1)    COMMENT '账号状态 0:正常1:禁用' ,
    deleted INT(1)    COMMENT '是否删除 0:正常1:禁用' ,
    role BIGINT    COMMENT '用户角色id' ,
    PRIMARY KEY (id)
) COMMENT = '后台账号表 ';

ALTER TABLE ums_user COMMENT '后台账号表';
DROP TABLE IF EXISTS ums_menu;/*SkipError*/
CREATE TABLE ums_menu(
    `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    create_by BIGINT    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by BIGINT    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    menu_name VARCHAR(32)    COMMENT '菜单名称' ,
    parent_id BIGINT    COMMENT '上级菜单id' ,
    sort INT    COMMENT '排序' ,
    url VARCHAR(128)    COMMENT '请求地址' ,
    icon VARCHAR(128)    COMMENT '菜单图标' ,
    `status` INT(1)    COMMENT '是否可见 0:否1:是' ,
    remark VARCHAR(512)    COMMENT '备注' ,
    perms VARCHAR(32)    COMMENT '权限字符' ,
    deleted INT(1)    COMMENT '是否删除 0:否1:是' ,
    PRIMARY KEY (id)
) COMMENT = '菜单表 ';

ALTER TABLE ums_menu COMMENT '菜单表';
DROP TABLE IF EXISTS ums_user_role;/*SkipError*/
CREATE TABLE ums_user_role(
    user_id BIGINT NOT NULL   COMMENT '用户id' ,
    role_id BIGINT NOT NULL   COMMENT '角色id' ,
    PRIMARY KEY (user_id,role_id)
) COMMENT = '用户角色关联表 ';

ALTER TABLE ums_user_role COMMENT '用户角色关联表';
DROP TABLE IF EXISTS ums_role_menu;/*SkipError*/
CREATE TABLE ums_role_menu(
    role_id BIGINT NOT NULL   COMMENT '角色id' ,
    mene_id BIGINT NOT NULL   COMMENT '菜单id' ,
    PRIMARY KEY (role_id,mene_id)
) COMMENT = '角色菜单关联表 ';

ALTER TABLE ums_role_menu COMMENT '角色菜单关联表';
DROP TABLE IF EXISTS ums_role;/*SkipError*/
CREATE TABLE ums_role(
    `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    create_by BIGINT    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by BIGINT    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    role_name VARCHAR(32)    COMMENT '角色名称' ,
    role_key VARCHAR(32)    COMMENT '角色权限字符' ,
    sort VARCHAR(32)    COMMENT '显示顺序' ,
    status INT(1)    COMMENT '状态 0:正常1:停用' ,
    deleted INT(1)    COMMENT '是否删除 0:否1:是' ,
    PRIMARY KEY (id)
) COMMENT = '角色表 ';

ALTER TABLE ums_role COMMENT '角色表';
DROP TABLE IF EXISTS cms_column;/*SkipError*/
CREATE TABLE cms_column(
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    create_by BIGINT    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by BIGINT    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    column_name VARCHAR(64)    COMMENT '栏目名称' ,
    type_id BIGINT    COMMENT '类型id' ,
    icon VARCHAR(256)    COMMENT '栏目图标' ,
    parent_id BIGINT    COMMENT '上级栏目' ,
    sort INT    COMMENT '排序' ,
    status INT(1)    COMMENT '状态 0:正常1;隐藏' ,
    deleted INT(1)    COMMENT '删除 0:否1:是' ,
    remark VARCHAR(512)    COMMENT '备注说明' ,
    url VARCHAR(256)    COMMENT '栏目链接' ,
    PRIMARY KEY (id)
) COMMENT = '栏目表 ';

ALTER TABLE cms_column COMMENT '栏目表';
DROP TABLE IF EXISTS cms_topic;/*SkipError*/
CREATE TABLE cms_topic(
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    create_by BIGINT    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by BIGINT    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    topic_name VARCHAR(32) NOT NULL   COMMENT '专题名称' ,
    column_id BIGINT    COMMENT '所属栏目' ,
    icon VARCHAR(256)    COMMENT '专题图标' ,
    intro VARCHAR(512)    COMMENT '专题简介' ,
    status INT(1)    COMMENT '状态 0:正常1:隐藏' ,
    deleted INT(1)    COMMENT '删除 0:正常1:隐藏' ,
    url VARCHAR(256)    COMMENT '专题链接' ,
    PRIMARY KEY (id)
) COMMENT = '专题 栏目中的专题';

ALTER TABLE cms_topic COMMENT '专题';
DROP TABLE IF EXISTS cms_article;/*SkipError*/
CREATE TABLE cms_article(
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    create_by BIGINT    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by BIGINT    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    article_title VARCHAR(128)    COMMENT '文章标题' ,
    topic_id BIGINT    COMMENT '所属专题' ,
    author VARCHAR(32)    COMMENT '文章作者' ,
    pic VARCHAR(256)    COMMENT '文章缩略图' ,
    article_abstract VARCHAR(256)    COMMENT '文章摘要' ,
    sort INT    COMMENT '排序' ,
    status INT(1)    COMMENT '状态 0:正常1:隐藏' ,
    deleted INT(1)    COMMENT '逻辑删除 0:否1:是' ,
    PRIMARY KEY (id)
) COMMENT = '文章表 ';

ALTER TABLE cms_article COMMENT '文章表';
DROP TABLE IF EXISTS cms_article_content;/*SkipError*/
CREATE TABLE cms_article_content(
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    article_id BIGINT NOT NULL   COMMENT '文章id' ,
    content TEXT    COMMENT '文章内容' ,
    PRIMARY KEY (id)
) COMMENT = '文章内容 ';

ALTER TABLE cms_article_content COMMENT '文章内容';
DROP TABLE IF EXISTS cms_column_type;/*SkipError*/
CREATE TABLE cms_column_type(
    `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    create_by BIGINT    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by BIGINT    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    type_name VARCHAR(64)    COMMENT '类型名称' ,
    `status` INT(1)    COMMENT '状态 0:正常1:禁用' ,
    deleted INT(1)    COMMENT '删除 0:否1:是' ,
    remark VARCHAR(512)    COMMENT '备注说明' ,
    PRIMARY KEY (id)
) COMMENT = '栏目类型 ';

ALTER TABLE cms_column_type COMMENT '栏目类型';
DROP TABLE IF EXISTS cms_siteinfo;/*SkipError*/
CREATE TABLE cms_siteinfo(
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    create_by BIGINT    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by BIGINT    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    site_name VARCHAR(128)    COMMENT '网站名称' ,
    seo_key VARCHAR(128)    COMMENT 'seo关键字' ,
    copyright VARCHAR(128)    COMMENT '版权信息' ,
    `desc` VARCHAR(512)    COMMENT '网站描述' ,
    record VARCHAR(128)    COMMENT '备案号' ,
    telephone VARCHAR(32)    COMMENT '电话' ,
    address VARCHAR(128)    COMMENT '地址' ,
    email VARCHAR(32)    COMMENT '邮箱' ,
    worktime VARCHAR(32)    COMMENT '工作时间' ,
    PRIMARY KEY (id)
) COMMENT = '网站基本信息';

ALTER TABLE cms_siteinfo COMMENT '网站基本信息';
DROP TABLE IF EXISTS cms_advertisement_type;/*SkipError*/
CREATE TABLE cms_advertisement_type(
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    create_by BIGINT    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by BIGINT    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    type_name VARCHAR(32)    COMMENT '广告位名称' ,
    sort INT    COMMENT '排序' ,
    `desc` VARCHAR(256)    COMMENT '描述' ,
    status INT(1)    COMMENT '状态 0:正常1:禁用' ,
    deleted INT(1)    COMMENT '删除 0:否1:是' ,
    PRIMARY KEY (id)
) COMMENT = '广告位管理';

ALTER TABLE cms_advertisement_type COMMENT '广告位管理';
DROP TABLE IF EXISTS cms_advertisement;/*SkipError*/
CREATE TABLE cms_advertisement(
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '自增主键' ,
    create_by BIGINT    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by BIGINT    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    advertise_name VARCHAR(64)    COMMENT '广告名称' ,
    type_id BIGINT    COMMENT '所属广告位' ,
    url VARCHAR(256)    COMMENT '链接地址' ,
    pic VARCHAR(256)    COMMENT '广告图片' ,
    `desc` VARCHAR(256)    COMMENT '广告描述' ,
    sort INT    COMMENT '排序' ,
    status INT(1)    COMMENT '状态 0:正常1:隐藏' ,
    deleted INT(1)    COMMENT '删除 0:否1:是' ,
    PRIMARY KEY (id)
) COMMENT = '广告信息表';

ALTER TABLE cms_advertisement COMMENT '广告信息表';
