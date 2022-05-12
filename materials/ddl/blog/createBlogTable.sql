DROP TABLE blog;
CREATE TABLE blog (
    blog_id bigint,
    title varchar(200),
    main_text varchar(4000),
    create_date timestamp,
    update_date timestamp,
    PRIMARY KEY(blog_id)
);