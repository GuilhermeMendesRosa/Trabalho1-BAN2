create table subjects
(
    id         bigint auto_increment
        primary key,
    created_at datetime(6)  not null,
    updated_at datetime(6)  not null,
    version    int          not null,
    name       varchar(255) null,
    constraint subjects_name_unique
        unique (name)
);
