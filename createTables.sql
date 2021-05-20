CREATE DATABASE tiny_reporting;

USE tiny_reporting;

CREATE TABLE tiny_biz_info(
  biz_info_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  biz_name VARCHAR(50) NOT NULL,
  bu VARCHAR(50) NOT NULL,
  owner VARCHAR(50) NOT NULL,
  description VARCHAR(255),
  gmt_create TIMESTAMP NOT NULL,
  gmt_modified TIMESTAMP NOT NULL
);

CREATE TABLE tiny_flow_config(
  config_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  biz_info_id BIGINT NOT NULL,
  json_config TEXT,
  gmt_create TIMESTAMP NOT NULL,
  gmt_modified TIMESTAMP NOT NULL,
  FOREIGN KEY (biz_info_id) REFERENCES tiny_biz_info(biz_info_id)
);

CREATE TABLE tiny_flow_instance(
  flow_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  config_id BIGINT NOT NULL,
  status VARCHAR(20) NOT NULL,
  curr_node VARCHAR(20) NOT NULL,
  gmt_create TIMESTAMP NOT NULL,
  gmt_modified TIMESTAMP NOT NULL,
  FOREIGN KEY (config_id) REFERENCES tiny_flow_config(config_id)
);