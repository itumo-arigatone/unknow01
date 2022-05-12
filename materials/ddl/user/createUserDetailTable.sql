CREATE TABLE IF NOT EXISTS `user_detail` (
  id BIGINT,
  post_code VARCHAR(16),
  `address`  VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  first_name_kana VARCHAR(255),
  last_name_kana VARCHAR(255),
  PRIMARY KEY (id),
)