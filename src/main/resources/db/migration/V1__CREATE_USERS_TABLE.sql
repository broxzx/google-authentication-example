-- CREATE SCHEMA users;

CREATE TABLE users.users (
    id BIGSERIAL PRIMARY KEY ,
    username varchar(128) NOT NULL UNIQUE,
    secretKey varchar,
    validationCode int,
    scratchCodes integer[]
);

CREATE TABLE users.scratch_codes(
    user_id BIGINT NOT NULL,
    scratch_code INTEGER,
    foreign key (user_id) references users.users (id)
);