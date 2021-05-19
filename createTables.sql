CREATE DATABASE tiny_reporting;

USE tiny_reporting;

CREATE TABLE tiny_biz_info(
  biz_info_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  biz_name VARCHAR(50) NOT NULL,
  bu VARCHAR(50) NOT NULL,
  owner VARCHAR(50) NOT NULL,
  description TEXT,
  gmt_create VARCHAR(20) NOT NULL,
  gmt_modified VARCHAR(20) NOT NULL
);

CREATE TABLE tiny_flow_config(
  config_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  biz_info_id INT NOT NULL,
  json_config LONGTEXT,
  gmt_create VARCHAR(20) NOT NULL,
  gmt_modified VARCHAR(20) NOT NULL,
  FOREIGN KEY (biz_info_id) REFERENCES tiny_biz_info(biz_info_id)
);

CREATE TABLE tiny_flow_instance(
  flow_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  config_id INT NOT NULL,
  status VARCHAR(20) NOT NULL,
  curr_node VARCHAR(20) NOT NULL,
  gmt_create VARCHAR(20) NOT NULL,
  gmt_modified VARCHAR(20) NOT NULL,
  FOREIGN KEY (config_id) REFERENCES tiny_flow_config(config_id)
);