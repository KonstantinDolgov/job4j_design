CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

INSERT INTO customers
VALUES (1, 'Данила', 'Багров', 30, 'РФ'),
       (2, 'Абай', 'Кунанбаев', 50, 'Казахстан'),
       (3, 'Иван', 'Поддубный', 40, 'РФ'),
       (4, 'Брюс', 'Уилис', 35, 'США');

select * from customers
where age = (select min(age) from customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

INSERT INTO orders
VALUES (1, 300, 1),
       (2, 5000, 4);

SELECT *
FROM customers
WHERE id NOT IN (SELECT customer_id FROM orders);