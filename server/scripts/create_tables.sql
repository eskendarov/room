CREATE TABLE "user" (
    id       SERIAL PRIMARY KEY,
    name     VARCHAR,
    email    VARCHAR UNIQUE,
    password VARCHAR
);

CREATE TABLE room (
    id         SERIAL PRIMARY KEY,
    name       VARCHAR,
    creator_id INT REFERENCES "user" (id)
);

CREATE TYPE content_type as ENUM ('TEXT', 'FILE');

CREATE TABLE message (
    id            SERIAL PRIMARY KEY,
    sender_id     INT REFERENCES "user" (id),
    room_id       INT REFERENCES room (id),
    send_time     TIMESTAMP,
    received_time TIMESTAMP,
    text          TEXT,
    type          CONTENT_TYPE
);

CREATE TABLE role (
    id   SERIAL PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE room_user_role (
    room_id  INT REFERENCES room (id),
    users_id INT REFERENCES "user" (id),
    role_id  INT REFERENCES role (id)
);
