CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    quantity INT
);

INSERT INTO users (name, quantity) VALUES
('Table', 1),
('Car', 2),
('Phone', 6);
('Sandwich', 1);
('Jacket', 2);