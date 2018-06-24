INSERT INTO product (id, name, price) VALUES (1, 'Coca Cola', 5.00);
INSERT INTO product (id, name, price) VALUES (2, 'Guaraná', 4.00);
INSERT INTO product (id, name, price) VALUES (3, 'Hambúrguer', 10.00);

INSERT INTO restaurant (id, name, logo) VALUES (1, 'Restaurant A', '1.png');
INSERT INTO restaurant (id, name, logo) VALUES (2, 'Restaurant B', '2.png');
INSERT INTO restaurant (id, name, logo) VALUES (3, 'Restaurant C', '3.png');

INSERT INTO client (id, name) VALUES (1, 'Fernanda Caroline');
INSERT INTO client (id, name) VALUES (2, 'Heitor Morgado');
INSERT INTO client (id, name) VALUES (3, 'Mateus Tavares');
INSERT INTO client (id, name) VALUES (4, 'John');

INSERT INTO orders (id, client_id, status, seat_number) VALUES (1, 1, 1, 'A1');
INSERT INTO orders (id, client_id, status, seat_number) VALUES (2, 1, 1, 'A1');
INSERT INTO orders (id, client_id, status, seat_number) VALUES (3, 2, 2, 'A2');
INSERT INTO orders (id, client_id, status, seat_number) VALUES (4, 3, 3, 'A3');
INSERT INTO orders (id, client_id, status, seat_number) VALUES (5, 4, 4, 'A4');

