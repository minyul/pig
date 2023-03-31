CREATE DATABASE IF NOT EXISTS `pig`;
USE `pig`;

CREATE TABLE IF NOT EXISTS `ticket`(
    `id`            INT(11)     NOT NULL PRIMARY KEY COMMENT 'ticket_Id',
    `content`       VARCHAR(50) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
