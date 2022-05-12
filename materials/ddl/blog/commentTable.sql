DROP TABLE blog_comment;
CREATE TABLE blog_comment (
    blog_id bigint,
    title varchar(200),
    main_text varchar(4000),
    create_date timestamp,
    update_date timestamp,
    PRIMARY KEY(blog_id)
);