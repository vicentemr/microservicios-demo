DROP TABLE IF EXISTS invoice_item;

CREATE TABLE invoice_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT NOT NULL,
    quantity DOUBLE,
    price DOUBLE
);

DROP TABLE IF EXISTS invoice;

CREATE TABLE invoice (
     id BIGINT AUTO_INCREMENT  PRIMARY KEY,
     number_invoice VARCHAR(250) NOT NULL,
     description VARCHAR(250) NOT NULL,
     customer_id VARCHAR(250) NOT NULL,
     create_at VARCHAR(250) NOT NULL,
     state VARCHAR(250) NOT NULL
);