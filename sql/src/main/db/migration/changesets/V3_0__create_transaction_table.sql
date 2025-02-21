SET
search_path TO acme_app;

CREATE TYPE transaction_status AS ENUM ('SUCCESS', 'FAIL', 'UNKNOWN');

CREATE CAST (varchar AS transaction_status) WITH INOUT AS IMPLICIT;

CREATE TABLE transaction
(
    id                 uuid not null DEFAULT uuid_generate_v4(),
    customer_id        uuid not null,
    amount             bigint,
    transaction_status transaction_status,
    created_date       timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE
    INDEX transaction_customer_idx
    ON transaction
    USING btree (customer_id);
