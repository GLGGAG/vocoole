/*沃酷乐管理后台*/
/*=============================================================*/
/*        DbNAME:vocoole                                  */
/*=============================================================*/

DROP TABLE IF EXISTS  mall;
CREATE TABLE mall(

  id                        INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  mall_no                   INT UNSIGNED NOT NULL COMMENT '商城编号',
  mall_name                 VARCHAR(30) NOT NULL COMMENT '商城名',
  mall_address              VARCHAR(50) NOT NULL COMMENT '商城地址',
  corporate_name            CHAR(5) NOT NULL COMMENT '商城法人代表名字',
  manage_name               CHAR(5) NOT NULL COMMENT '商城管理人员名字',
  manage_phone              CHAR(11)  NOT NULL UNIQUE COMMENT '商城管理人员手机号码',
  business_license          VARCHAR(60) NOT NULL COMMENT '商城营业执照',
  city_id                   INT NOT NULL COMMENT '所在的城市id',
  longitude                 DOUBLE NOT NULL COMMENT '商超经度',
  latitude                  DOUBLE NOT NULL COMMENT '商超纬度',

  check_status               TINYINT NOT NULL DEFAULT 0 COMMENT '审核状态 0:审核中  -1:审核失败 1:审核成功',
  check_explain              VARCHAR(200) COMMENT '审核说明 当初始化时 审核为null 其他状态不为null',
  check_staff_no             INT UNSIGNED NOT NULL COMMENT    '审核的职员编号',

  create_time              DATETIME NOT NULL DEFAULT current_time COMMENT '创建时间',
  update_time              DATETIME NOT NULL DEFAULT current_time COMMENT  '更新时间',
  version                  INT UNSIGNED DEFAULT 0 COMMENT  '版本号',
  deleted                  TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除 0:否 1:是',
  KEY (mall_no),
  KEY (city_id),
  KEY (manage_phone)
)ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT '商超信息表';




DROP TABLE IF EXISTS staff;
CREATE TABLE staff(
  id                        INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  staff_name                CHAR(5) NOT NULL COMMENT   '职员名字',
  staff_no                  INT UNSIGNED NOT NULL COMMENT '职员编号',
  staff_phone               CHAR(11)  NOT NULL UNIQUE COMMENT '职员手机号码',
  pass_word                 VARCHAR(32) NOT NULL COMMENT '职员登录密码',

  login_ip                 VARCHAR(15) NOT NULL COMMENT '登录ip',
  login_times              INT NOT NULL DEFAULT 0 COMMENT '登录次数',
  create_time              DATETIME NOT NULL DEFAULT current_time COMMENT '创建时间',
  update_time              DATETIME NOT NULL DEFAULT current_time COMMENT  '更新时间',
  version                  INT UNSIGNED DEFAULT 0 COMMENT  '版本号',
  deleted                  TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除 0:否 1:是',
  KEY (staff_no),
  KEY (staff_phone)
)ENGINE = InnoDB DEFAULT CHARSET  = utf8 COMMENT '职员表';

DROP TABLE IF EXISTS workOrder;
CREATE TABLE workOrder(
  id                        INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  user_phone                CHAR(11) NOT NULL COMMENT '用户手机号',
  user_name                 CHAR(5) NOT NULL  COMMENT '用户姓名',
  mall_address              VARCHAR(50) NOT NULL COMMENT '商城地址',
  problem_desc              VARCHAR(200) NOT NULL  COMMENT '问题描述',

  solve_status              TINYINT NOT NULL DEFAULT 0 COMMENT '解决状态 0:解决中  -1:解决失败 1:解决成功',
  solve_expain              VARCHAR(200) COMMENT '问题解决说明 当初始化时 为null 其他状态不为null',

  create_time              DATETIME NOT NULL DEFAULT current_time COMMENT '创建时间',
  update_time              DATETIME NOT NULL DEFAULT current_time COMMENT  '更新时间',
  version                  INT UNSIGNED DEFAULT 0 COMMENT  '版本号',
  deleted                  TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除 0:否 1:是'

)ENGINE = InnoDB DEFAULT CHARSET  = utf8 COMMENT '工单表';





























