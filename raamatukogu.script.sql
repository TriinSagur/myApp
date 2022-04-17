create table author
(
    id         serial
        constraint author_pk
            primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null
);

alter table author
    owner to postgres;

create table book
(
    id    serial
        constraint book_pk
            primary key,
    title varchar(255) not null,
    year  integer      not null
);

alter table book
    owner to postgres;

create table book_author
(
    id        serial
        constraint book_author_pk
            primary key,
    book_id   integer not null
        constraint book_author_book
            references book,
    author_id integer not null
        constraint book_author_author
            references author
);

alter table book_author
    owner to postgres;

create table book_out
(
    id          serial
        constraint book_out_pk
            primary key,
    book_id     integer               not null
        constraint book_out_book
            references book,
    is_returned boolean default false not null
);

alter table book_out
    owner to postgres;

create table keyword
(
    id   serial
        constraint keyword_pk
            primary key,
    name varchar(255) not null
);

alter table keyword
    owner to postgres;

create table book_keyword
(
    id         serial
        constraint book_keyword_pk
            primary key,
    book_id    integer not null
        constraint book_keyword_book
            references book,
    keyword_id integer not null
        constraint book_keyword_keyword
            references keyword
);

alter table book_keyword
    owner to postgres;


