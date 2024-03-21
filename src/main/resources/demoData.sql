-- Populate address table
INSERT INTO addresses (address_id, country, state, zip, city, street, test)
VALUES (1, 'Country1', 'State1', '12345', 'City1', 'Street1', 'Test1'),
       (2, 'Country2', 'State2', '54321', 'City2', 'Street2', 'Test2'),
       (3, 'Country3', 'State3', '98765', 'City3', 'Street3', 'Test3'),
       (4, 'Country3', 'State3', '98765', 'City3', 'Street3', 'Test3');

-- Populate clients table
INSERT INTO clients (client_id, first_name, last_name, email, phone_number, role, date_of_birth, address_id, created_at,
                     updated_at)
VALUES (1, 'John', 'Doe', 'john@example.com', '123456789', 'USER', '1990-01-01', 1, NOW(), NOW()),
       (2, 'Alice', 'Smith', 'alice@example.com', '987654321', 'ADMIN', '1985-05-15', 2, NOW(), NOW()),
       (3, 'Bob', 'Johnson', 'bob@example.com', '555555555', 'USER', '1988-09-20', 3, NOW(), NOW()),
       (4, 'Bob', 'Johnson213', 'bob123@example.com', '555555555123', 'USER', '2010-09-20', 4, NOW(), NOW());

