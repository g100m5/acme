SET
search_path TO acme_app;

CREATE TYPE gender_type AS ENUM ('MALE', 'FEMALE', 'OTHER','UNKNOWN');

CREATE CAST (varchar AS gender_type) WITH INOUT AS IMPLICIT;

CREATE TABLE customer
(
    id           uuid not null primary key,
    first_name   varchar(50),
    last_name    varchar(50),
    patronym     varchar(50),
    gender_type  gender_type DEFAULT 'UNKNOWN',
    dob          timestamp without time zone,
    balance      bigint,
    created_date timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by   varchar(75),
    deleted_at   timestamp without time zone,

    UNIQUE (first_name, last_name, dob, deleted_at)
);

