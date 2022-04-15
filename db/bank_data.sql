INSERT INTO customer (first_name, last_name, isikukood) VALUES ('Otto', 'Triin', '40000000001');
INSERT INTO customer (first_name, last_name, isikukood) VALUES ('Martin', 'Reimo', '30000000002');
INSERT INTO customer (first_name, last_name, isikukood) VALUES ('Nipi', 'Tiri', '30000000003');
INSERT INTO customer (first_name, last_name, isikukood) VALUES ('Edit', 'Nupp', '40000000004');

INSERT INTO account (account_number, customer_id, balance, locked) VALUES ('EE123', 1, 50, false);
INSERT INTO account (account_number, customer_id, balance, locked) VALUES ('EE456', 3, 20, false);
INSERT INTO account (account_number, customer_id, balance, locked) VALUES ('EE666', 2, 30, false);
INSERT INTO account (account_number, customer_id, balance, locked) VALUES ('EE999', 4, 200, false);
INSERT INTO account (account_number, customer_id, balance, locked) VALUES ('EE777', 1, 200, false);

INSERT INTO transaction (balance, type, amount, transaction_date_time, account_id, sender_account_number, receiver_account_number) VALUES (100, 'd', 100, '2022-01-27 22:51:18.000000', 1, 'ATM', 'EE123');
INSERT INTO transaction (balance, type, amount, transaction_date_time, account_id, sender_account_number, receiver_account_number) VALUES (200, 'd', 200, '2022-01-27 22:51:18.000000', 4, 'ATM', 'EE999');
INSERT INTO transaction (balance, type, amount, transaction_date_time, account_id, sender_account_number, receiver_account_number) VALUES (80, 's', 20, '2022-01-27 22:51:18.000000', 1, 'EE123', 'EE456');
INSERT INTO transaction (balance, type, amount, transaction_date_time, account_id, sender_account_number, receiver_account_number) VALUES (20, 'r', 20, '2022-01-27 22:51:18.000000', 3, 'EE456', 'EE123');
INSERT INTO transaction (balance, type, amount, transaction_date_time, account_id, sender_account_number, receiver_account_number) VALUES (60, 's', 20, '2022-01-27 22:51:18.000000', 1, 'EE123', 'EE666');
INSERT INTO transaction (balance, type, amount, transaction_date_time, account_id, sender_account_number, receiver_account_number) VALUES (20, 'r', 20, '2022-01-27 22:51:18.000000', 2, 'EE123', 'EE666');
INSERT INTO transaction (balance, type, amount, transaction_date_time, account_id, sender_account_number, receiver_account_number) VALUES (50, 's', 10, '2022-01-27 22:51:18.000000', 1, 'EE123', 'EE666');
INSERT INTO transaction (balance, type, amount, transaction_date_time, account_id, sender_account_number, receiver_account_number) VALUES (30, 'r', 10, '2022-01-27 22:51:18.000000', 2, 'EE123', 'EE666');
