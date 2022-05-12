DROP TABLE review;
CREATE TABLE review (
    id bigint,
    review integer,
    title varchar(200),
    contents varchar(4000),
    create_date timestamp,
    update_date timestamp,
    PRIMARY KEY(id)
);