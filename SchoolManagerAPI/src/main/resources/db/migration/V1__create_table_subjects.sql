create table subjects
(
    id         bigint auto_increment
        primary key,
    created_at datetime(6)  not null,
    updated_at datetime(6)  not null,
    version    int          not null,
    name       varchar(255) null,
    constraint UK_aodt3utnw0lsov4k9ta88dbpr
        unique (name)
);
