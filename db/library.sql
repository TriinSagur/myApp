-- tables
-- Table: author
CREATE TABLE author (
                        id serial  NOT NULL,
                        first_name varchar(255)  NOT NULL,
                        last_name varchar(255)  NOT NULL,
                        CONSTRAINT author_pk PRIMARY KEY (id)
);
-- Table: book
CREATE TABLE book (
                      id serial  NOT NULL,
                      title varchar(255)  NOT NULL,
                      year int  NOT NULL,
                      CONSTRAINT book_pk PRIMARY KEY (id)
);
-- Table: book_author
CREATE TABLE book_author (
                             id serial  NOT NULL,
                             book_id int  NOT NULL,
                             author_id int  NOT NULL,
                             CONSTRAINT book_author_pk PRIMARY KEY (id)
);
-- Table: book_keyword
CREATE TABLE book_keyword (
                              id serial  NOT NULL,
                              book_id int  NOT NULL,
                              keyword_id int  NOT NULL,
                              CONSTRAINT book_keyword_pk PRIMARY KEY (id)
);
-- Table: book_out
CREATE TABLE book_out (
                          id serial  NOT NULL,
                          book_id int  NOT NULL,
                          is_returned boolean  NOT NULL DEFAULT false,
                          CONSTRAINT book_out_pk PRIMARY KEY (id)
);
-- Table: keyword
CREATE TABLE keyword (
                         id serial  NOT NULL,
                         name varchar(255)  NOT NULL,
                         CONSTRAINT keyword_pk PRIMARY KEY (id)
);
-- foreign keys
-- Reference: book_author_author (table: book_author)
ALTER TABLE book_author ADD CONSTRAINT book_author_author
    FOREIGN KEY (author_id)
        REFERENCES author (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: book_author_book (table: book_author)
ALTER TABLE book_author ADD CONSTRAINT book_author_book
    FOREIGN KEY (book_id)
        REFERENCES book (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: book_keyword_book (table: book_keyword)
ALTER TABLE book_keyword ADD CONSTRAINT book_keyword_book
    FOREIGN KEY (book_id)
        REFERENCES book (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: book_keyword_keyword (table: book_keyword)
ALTER TABLE book_keyword ADD CONSTRAINT book_keyword_keyword
    FOREIGN KEY (keyword_id)
        REFERENCES keyword (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: book_out_book (table: book_out)
ALTER TABLE book_out ADD CONSTRAINT book_out_book
    FOREIGN KEY (book_id)
        REFERENCES book (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;