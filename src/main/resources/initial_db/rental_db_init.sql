INSERT INTO rental.person (id, name, surname, patronymic, age) VALUES (1, 'Иван', 'Иванов', 'Иванович', 39);
INSERT INTO rental.person (id, name, surname, age) VALUES (2, 'Булацкая', 'Светлана', 29);

INSERT INTO rental.address (id, city, street, house_number) VALUES (1, 'Минск', 'Независимости', 134);
INSERT INTO rental.address (id, city, street, house_number) VALUES (2, 'Минск', 'Аранская', 59);
INSERT INTO rental.address (id, city, street, house_number) VALUES (3, 'Минск', 'Фрунзенская', 71);

INSERT INTO rental.apartment (id, apartment_number, floor, count_of_rooms, total_square, address_id) VALUES (1, 34, 3, 3, 34.2, 2);
INSERT INTO rental.apartment (id, apartment_number, floor, count_of_rooms, total_square, address_id) VALUES (2, 152, 11, 2, 21.3, 2);
INSERT INTO rental.apartment (id, apartment_number, floor, count_of_rooms, total_square, address_id) VALUES (3, 53, 4, 4, 40.7, 1);
INSERT INTO rental.apartment (id, apartment_number, floor, count_of_rooms, total_square, address_id) VALUES (4, 89, 7, 3, 29.7, 3);
