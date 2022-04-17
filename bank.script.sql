create table customer
(
    id         serial
        constraint customer_pk
            primary key,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    isikukood  varchar(11) not null
);

alter table customer
    owner to postgres;

create table account
(
    id             serial
        constraint account_pk
            primary key,
    customer_id    integer    not null
        constraint account_customer
            references customer,
    account_number varchar(5) not null,
    balance        integer    not null,
    locked         boolean    not null
);

alter table account
    owner to postgres;

create table transaction
(
    id                      serial
        constraint transaction_pk
            primary key,
    sender_account_number   varchar(11),
    receiver_account_number varchar(11),
    amount                  integer   not null,
    balance                 integer   not null,
    type                    char      not null,
    transaction_date_time   timestamp not null,
    account_id              integer   not null
        constraint transaction_account
            references account
);

alter table transaction
    owner to postgres;


