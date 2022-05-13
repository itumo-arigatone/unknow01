CREATE TABLE user_information(
  id SERIAL,
  name varchar(128) NOT NULL,
  password varchar(256) NOT NULL,
  email varchar(256) NOT NULL,
  admin_flag boolean NOT NULL DEFAULT FALSE,
  create_date timestamp,
  update_date timestamp,
  PRIMARY KEY(id),
  UNIQUE (name, email)
);