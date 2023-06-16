create table log_account
(
    id        bigint       not null
        primary key,
    app       varchar(255) not null,
    username  varchar(255) not null,
    email     varchar(255) null comment '注册邮箱',
    password  varchar(255) not null,
    super_pwd varchar(255) null comment '类似steam的超级密码'
);

create table log_money
(
    id       bigint                      not null
        primary key,
    category varchar(255) default '其他' null,
    detail   varchar(255)                null,
    money    double       default 0      null,
    remark   varchar(255)                null,
    log_time datetime                    not null
)
    comment '记账本';

