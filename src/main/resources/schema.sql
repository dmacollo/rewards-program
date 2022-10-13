CREATE SCHEMA CUSTOMER_SCHEMA;
CREATE TABLE CUSTOMER_SCHEMA.CUSTOMER(
	id int,
	name varchar(255),
	date_created date
);

CREATE TABLE CUSTOMER_SCHEMA.PURCHASE_TRANSACTION(
	id int,
	customer_id int,
	amount double,
	transaction_date date,	
	process_indicator varchar(1)
);

CREATE TABLE CUSTOMER_SCHEMA.PURCHASE_REWARD(
	id int,
	customer_id int,
	purchase_transaction_id int,
	points_earned int,
	date_created date
)

