DROP TABLE IF EXISTS product;

CREATE TABLE product (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    stock DOUBLE,
    price DOUBLE,
    status VARCHAR(250) NOT NULL,
    create_at TIMESTAMP,
    category_id BIGINT
);

DROP TABLE IF EXISTS categories;

CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);