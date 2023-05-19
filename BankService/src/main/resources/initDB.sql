CREATE TABLE IF NOT EXISTS client(
	client_id SERIAL PRIMARY KEY,
	firtname CHARACTER VARYING(50) NOT NULL,
	secondname CHARACTER VARYING(50) NOT NULL
)

CREATE TABLE IF NOT EXISTS client_request(
	request_id SERIAL PRIMARY KEY,
	request CHARACTER VARYING(255) NOT NULL,
	client_id INTEGER REFERENCES client(client_id) ON DELETE CASCADE
)

CREATE TABLE IF NOT EXISTS clerk(
	clerk_id SERIAL PRIMARY KEY,
	firtname CHARACTER VARYING(50) NOT NULL,
	secondname CHARACTER VARYING(50) NOT NULL
)

CREATE TABLE IF NOT EXISTS bank(
	total_profit INTEGER NOT NULL
)

CREATE TABLE IF NOT EXISTS client_queue(
	client_number SERIAL PRIMARY KEY,
	client_id INTEGER REFERENCES client(client_id) ON DELETE CASCADE,
)

CREATE TABLE IF NOT EXISTS bank_transaction(
	transaction_id SERIAL PRIMARY KEY,
	transaction_date TIMESTAMP NOT NULL,
	profit INTEGER NOT NULL,
	client_number INTEGER REFERENCES client_queue(client_number),
	clerk_id INTEGER REFERENCES clerk(clerk_id),
	request_id INTEGER REFERENCES client_request(request_id)
)

