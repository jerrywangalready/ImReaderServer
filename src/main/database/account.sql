drop table if exists account_info;

drop table if exists card_info;

drop table if exists consume_record;

drop table if exists demo;

drop table if exists p_menu;

drop table if exists p_resource;

drop table if exists p_resource_role;

drop table if exists p_role;

drop table if exists p_role_user;

drop table if exists recharge_record;

drop table if exists s_code_list;

drop table if exists s_object;

drop table if exists s_object_users;

drop table if exists s_properties;

drop table if exists s_users;

drop table if exists t_code_list;

/*==============================================================*/
/* Table: account_info                                          */
/*==============================================================*/
create table account_info
(
   uuid                 varchar(32) comment '主键',
   user_id              varchar(32) comment '账户人ID',
   card_id              varchar(32) comment '所在餐卡ID',
   balance              decimal comment '余额'
);

alter table account_info comment '账户信息';

/*==============================================================*/
/* Table: card_info                                             */
/*==============================================================*/
create table card_info
(
   uuid                 varchar(32) not null comment '主键',
   card_id              varchar(32) comment '卡号',
   card_name            varchar(64) comment '卡名',
   card_manager         varchar(32) comment '餐卡管理员',
   primary key (uuid)
);

alter table card_info comment '餐卡信息表';

/*==============================================================*/
/* Table: consume_record                                        */
/*==============================================================*/
create table consume_record
(
   uuid                 varchar(32) not null comment '主键',
   user_id              varchar(32) comment '用户账号',
   breakfast            DECIMAL comment '早餐',
   lunch                decimal comment '午餐',
   dinner               decimal comment '晚餐',
   other                varchar(32) comment '其他',
   recordtime           date comment '记录日期',
   updatetime           datetime comment '时间戳',
   remark               varchar(125) comment '备注',
   card_id              varchar(32) comment '餐卡id',
   primary key (uuid)
);

alter table consume_record comment '个人消费记录表';

/*==============================================================*/
/* Table: demo                                                  */
/*==============================================================*/
create table demo
(
   uuid                 varchar(32) not null comment '主键',
   code                 varchar(50) comment '编码',
   name                 varchar(50) comment '名称',
   type                 varchar(50) comment '类型',
   isenable             varchar(2) comment '启用状态',
   primary key (uuid)
);

alter table demo comment 'demo';

/*==============================================================*/
/* Table: p_menu                                                */
/*==============================================================*/
create table p_menu
(
   uuid                 varchar(32) not null comment '主键',
   menu_id              varchar(50),
   menu_name            varchar(300),
   primary key (uuid)
);

alter table p_menu comment '菜单表';

/*==============================================================*/
/* Table: p_resource                                            */
/*==============================================================*/
create table p_resource
(
   uuid                 varchar(32) not null comment '主键',
   primary key (uuid)
);

alter table p_resource comment '资源表';

/*==============================================================*/
/* Table: p_resource_role                                       */
/*==============================================================*/
create table p_resource_role
(
   uuid                 varchar(32) not null comment '主键',
   primary key (uuid)
);

alter table p_resource_role comment '资源角色表';

/*==============================================================*/
/* Table: p_role                                                */
/*==============================================================*/
create table p_role
(
   uuid                 varchar(32) not null comment '主键',
   role_id              varchar(50) comment '角色编号',
   role_name            varchar(300) comment '角色',
   primary key (uuid)
);

alter table p_role comment '角色表';

/*==============================================================*/
/* Table: p_role_user                                           */
/*==============================================================*/
create table p_role_user
(
   uuid                 varchar(32) not null,
   role_id              varchar(50),
   username             varchar(50),
   object_code          varchar(32),
   primary key (uuid)
);

alter table p_role_user comment '人员角色关系表';

/*==============================================================*/
/* Table: recharge_record                                       */
/*==============================================================*/
create table recharge_record
(
   uuid                 varchar(32) comment '主键',
   user_id              varchar(32) comment '用户ID',
   card_id              varchar(32) comment '餐卡ID',
   recharge_money       decimal comment '充值金额',
   recharge_time        datetime comment '充值时间'
);

alter table recharge_record comment '充值记录表';

/*==============================================================*/
/* Table: s_code_list                                           */
/*==============================================================*/
create table s_code_list
(
   uuid                 varchar(32) not null comment '主键',
   code_type            varchar(32) comment '编码类型',
   code_name            varchar(32) comment '编码名称',
   code_key             varchar(32) comment '编码',
   code_value           varchar(100) comment '值',
   order_code           varchar(4) comment '派讯编码',
   isenable             varchar(2) comment '是否启用',
   primary key (uuid)
);

alter table s_code_list comment '系统码表';

/*==============================================================*/
/* Table: s_object                                              */
/*==============================================================*/
create table s_object
(
   uuid                 varchar(32) not null comment '主键',
   object_code          varchar(32) comment '项目编号',
   object_name          varchar(100) comment '项目名称',
   isenable             varchar(2) comment '是否启用',
   create_time          datetime comment '创建时间',
   primary key (uuid)
);

alter table s_object comment '项目';

/*==============================================================*/
/* Table: s_object_users                                        */
/*==============================================================*/
create table s_object_users
(
   uuid                 varchar(32) not null comment '主键',
   object_code          varchar(32) comment '项目编号',
   username             varchar(50) comment '登录账号',
   role_code            varchar(2) comment '角色编号',
   create_time          datetime comment '创建时间',
   primary key (uuid)
);

alter table s_object_users comment '项目人员关系表';

/*==============================================================*/
/* Table: s_properties                                          */
/*==============================================================*/
create table s_properties
(
   p_key                varchar(100) not null comment 'key',
   p_value              varchar(400) comment 'value',
   primary key (p_key)
);

alter table s_properties comment '配置信息表';

/*==============================================================*/
/* Table: s_users                                               */
/*==============================================================*/
create table s_users
(
   uuid                 varchar(32) not null comment '主键',
   username             varchar(50) comment '登录账号',
   password             varchar(50) comment '密码',
   nickname             varchar(50) comment '昵称',
   isenable             varchar(2) comment '启用状态',
   create_time          datetime comment '创建时间',
   primary key (uuid)
);

alter table s_users comment '用户';

/*==============================================================*/
/* Table: t_code_list                                           */
/*==============================================================*/
create table t_code_list
(
   uuid                 varchar(32) not null comment '主键',
   code_type            varchar(32) comment '编码类型',
   code_name            varchar(32) comment '编码名称',
   code_key             varchar(32) comment '编码',
   code_value           varchar(100) comment '值',
   order_code           varchar(4) comment '排序编码',
   isenable             varchar(2) comment '是否启用',
   primary key (uuid)
);

alter table t_code_list comment '项目码表';
