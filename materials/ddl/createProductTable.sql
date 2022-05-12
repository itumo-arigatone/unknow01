DROP TABLE products;
CREATE TABLE products (
    id bigint,
    product_name varchar(200),
    description varchar(4000),
    price integer,
    PRIMARY KEY(id)
);