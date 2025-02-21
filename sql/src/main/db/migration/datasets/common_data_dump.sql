SET
search_path TO acme_app;

INSERT INTO customer
(id, first_name, last_name, patronym, "gender_type", dob, balance, created_date, created_by, deleted_at)
VALUES('9e4818a9-9d40-4bfe-a9f6-5a3676c98ff9'::uuid, 'John', 'Doe', '', NULL, '1980-10-10 00:00:00.000', 1111, '2025-02-21 12:03:27.755', NULL, NULL);


INSERT INTO transaction
(id, customer_id, amount, "transaction_status", created_date)
VALUES('aca16528-1970-45aa-a7f9-e16d57e9df82'::uuid, '9e4818a9-9d40-4bfe-a9f6-5a3676c98ff9'::uuid, 111, 'SUCCESS'::acme_app."transaction_status", '2025-02-21 12:03:40.225');