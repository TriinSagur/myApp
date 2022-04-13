-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-04-12 16:42:24.518

-- tables
-- Table: account
CREATE TABLE account (
    id serial  NOT NULL,
    customer_id int  NOT NULL,
    account_number varchar(5)  NOT NULL,
    balance int  NOT NULL,
    locked boolean  NOT NULL,
    CONSTRAINT account_pk PRIMARY KEY (id)
);

-- Table: customer
CREATE TABLE customer (
    id serial  NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    isikukood varchar(11)  NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table: transaction
CREATE TABLE transaction (
    id serial  NOT NULL,
    sender_account_number varchar(11)  NULL,
    receiver_account_number varchar(11)  NULL,
    amount int  NOT NULL,
    balance int  NOT NULL,
    type char(1)  NOT NULL,
    transaction_date_time timestamp  NOT NULL,
    account_id int  NOT NULL,
    CONSTRAINT transaction_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: account_customer (table: account)
ALTER TABLE account ADD CONSTRAINT account_customer
    FOREIGN KEY (customer_id)
    REFERENCES customer (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: transaction_account (table: transaction)
ALTER TABLE transaction ADD CONSTRAINT transaction_account
    FOREIGN KEY (account_id)
    REFERENCES account (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

