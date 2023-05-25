CREATE TABLE IF NOT EXISTS client(
        client_id SERIAL PRIMARY KEY,
        firtname CHARACTER VARYING(50) NOT NULL,
        secondname CHARACTER VARYING(50) NOT NULL
    )

CREATE TABLE IF NOT EXISTS client_query(
        client_id INTEGER NOT NULL REFERENCES client(client_id),
        sending_time TIMESTAMP NOT NULL
    )

CREATE TABLE IF NOT EXISTS clerk(
    clerk_id SERIAL PRIMARY KEY,
    firtname CHARACTER VARYING(50) NOT NULL,
    secondname CHARACTER VARYING(50) NOT NULL
    )

CREATE TABLE IF NOT EXISTS bank_transaction(
    transaction_id SERIAL PRIMARY KEY,
    transaction_srart_date TIMESTAMP NOT NULL,
    transaction_end_date TIMESTAMP NOT NULL,
    client_id INTEGER REFERENCES client_queue(client_id),
    clerk_id INTEGER REFERENCES clerk(clerk_id),
    )

CREATE TABLE IF NOT EXISTS result(
    client_id INTEGER REFERENCES bank_transaction(client_id),
    clerk_id INTEGER REFERENCES bank_transaction(clerk_id),
    sending_time TIMESTAMP NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    payment REAL NOT NULL
)