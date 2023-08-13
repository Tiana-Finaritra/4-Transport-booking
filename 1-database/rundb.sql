\c postgres

DROP DATABASE IF EXISTS madatrans;
CREATE DATABASE madatrans;

\c madatrans


-- File: create_tables.sql

-- Create the table for clients
CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20)
);

-- Create the table for voyages
CREATE TABLE voyage (
    id SERIAL PRIMARY KEY,
    destination VARCHAR(200) NOT NULL,
    departure_date TIMESTAMP NOT NULL,
    available_seats INT NOT NULL,
    fare FLOAT  NOT NULL -- Fare for the voyage
);

-- Create the table for reservations
CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    reservation_date TIMESTAMP NOT NULL,
    client_id INT REFERENCES client(id),
    voyage_id INT REFERENCES voyage(id)
);

-- Create the table for payments
CREATE TABLE payment (
    id SERIAL PRIMARY KEY,
    reservation_id INT REFERENCES reservation(id),
    payment_date TIMESTAMP NOT NULL,
    amount FLOAT NOT NULL,
    payment_status VARCHAR(20) NOT NULL -- e.g., 'Pending', 'Completed', 'Failed'
);


-- Insert mock data for clients
INSERT INTO client (first_name, last_name, email, phone)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '123-456-7890'),
    ('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210'),
    ('Alice', 'Johnson', 'alice.johnson@example.com', '555-123-4567'),
    ('Bob', 'Williams', 'bob.williams@example.com', '777-555-8888'),
    ('Michael', 'Brown', 'michael.brown@example.com', '999-111-2222'),
    ('Emily', 'Davis', 'emily.davis@example.com', '444-333-2222'),
    ('David', 'Miller', 'david.miller@example.com', '111-999-8888'),
    ('Sarah', 'Taylor', 'sarah.taylor@example.com', '222-444-5555'),
    ('Daniel', 'Anderson', 'daniel.anderson@example.com', '666-777-8888'),
    ('Olivia', 'Martinez', 'olivia.martinez@example.com', '777-888-9999');

-- Insert mock data for voyages
INSERT INTO voyage (destination, departure_date, available_seats, fare)
VALUES
    ('New York', '2023-08-15 10:00:00', 50, 150.00),
    ('Los Angeles', '2023-08-20 09:30:00', 40, 200.00),
    ('Chicago', '2023-09-01 11:00:00', 30, 120.00),
    ('Miami', '2023-09-10 08:45:00', 60, 180.00),
    ('San Francisco', '2023-09-15 12:30:00', 45, 210.00),
    ('Seattle', '2023-09-20 14:15:00', 55, 160.00),
    ('Boston', '2023-09-25 16:30:00', 35, 190.00),
    ('Denver', '2023-10-01 09:00:00', 50, 170.00),
    ('Orlando', '2023-10-05 10:45:00', 70, 230.00),
    ('Las Vegas', '2023-10-10 13:00:00', 25, 250.00);

-- Insert mock data for reservations
INSERT INTO reservation (reservation_date, client_id, voyage_id)
VALUES
    ('2023-08-10 15:00:00', 1, 1),
    ('2023-08-12 14:30:00', 2, 2),
    ('2023-08-20 11:30:00', 3, 3),
    ('2023-08-22 10:15:00', 4, 4),
    ('2023-08-25 12:00:00', 5, 5),
    ('2023-08-28 13:45:00', 6, 6),
    ('2023-08-30 15:30:00', 7, 7),
    ('2023-09-02 14:00:00', 8, 8),
    ('2023-09-05 16:15:00', 9, 9),
    ('2023-09-08 09:30:00', 10, 10);


-- Insert mock data for payments
INSERT INTO payment (reservation_id, payment_date, amount, payment_status)
VALUES
    (1, '2023-08-10 15:15:00', 150.00, 'Completed'),
    (2, '2023-08-12 14:45:00', 200.00, 'Pending'),
    (3, '2023-08-20 11:45:00', 120.00, 'Pending'),
    (4, '2023-08-22 10:30:00', 180.00, 'Completed'),
    (5, '2023-08-25 12:15:00', 210.00, 'Pending'),
    (6, '2023-08-28 14:00:00', 160.00, 'Completed'),
    (7, '2023-08-30 15:45:00', 190.00, 'Pending'),
    (8, '2023-09-02 14:30:00', 170.00, 'Completed'),
    (9, '2023-09-05 16:45:00', 230.00, 'Pending'),
    (10, '2023-09-08 09:45:00', 250.00, 'Completed');