drop table IF EXISTS endpoint_hit CASCADE;

CREATE TABLE endpoint_hit (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    app VARCHAR(255) not null,
    uri VARCHAR(255) not null,
    ip VARCHAR(255) not null,
    timestamp TIMESTAMP WITHOUT TIME ZONE
);