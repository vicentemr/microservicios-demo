DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    number_id VARCHAR(250) NOT NULL,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    photo_url VARCHAR(250) NOT NULL,
    state VARCHAR(250) NOT NULL,
    region_id BIGINT
);

DROP TABLE IF EXISTS region;

CREATE TABLE region (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);