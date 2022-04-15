INSERT INTO keyword (id, name) VALUES (DEFAULT, 'zombi');
INSERT INTO keyword (id, name) VALUES (DEFAULT, 'erotica');
INSERT INTO keyword (id, name) VALUES (DEFAULT, 'fiction');
INSERT INTO keyword (id, name) VALUES (DEFAULT, 'travel');
INSERT INTO keyword (id, name) VALUES (DEFAULT, 'sci-fi');

INSERT INTO author (id, first_name, last_name)VALUES (DEFAULT, 'Antoni Horatio', 'Banderas');
INSERT INTO author (id, first_name, last_name)VALUES (DEFAULT, 'Maizi', 'Pulk');

INSERT INTO book (id, title, year)VALUES (DEFAULT, 'Code smell', 2008);
INSERT INTO book (id, title, year)VALUES (DEFAULT, 'Harry Potter', 2005);

INSERT INTO book_author (id, book_id, author_id) VALUES (DEFAULT, 1, 2);
INSERT INTO book_author (id, book_id, author_id) VALUES (DEFAULT, 1, 1);
INSERT INTO book_author (id, book_id, author_id) VALUES (DEFAULT, 2, 2);

INSERT INTO book_keyword (id, book_id, keyword_id) VALUES (DEFAULT, 2, 1);
INSERT INTO book_keyword (id, book_id, keyword_id) VALUES (DEFAULT, 2, 2);