CREATE TABLE `list_entity` (
  `gift_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `gift_brand` varchar(255) NOT NULL,
  `gift_category` varchar(255) NOT NULL,
  `gift_content` varchar(255) DEFAULT NULL,
  `gift_name` varchar(255) NOT NULL,
  `gift_price` varchar(255) NOT NULL,
  `gift_sold` int(11) NOT NULL,
  PRIMARY KEY (`gift_id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8

CREATE TABLE `user` (
  `user_id` INT auto_increment,
  `nickname` varchar(45) NULL,
  `name` varchar(45) NULL,
  `profile_image` varchar(200) NULL,
  `thumnail_image` varchar(200) NULL,
  `role` varchar(45) NULL,
  `email` varchar(45) NOT NULL,
  `phone_number` varbinary(45) NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

drop table user;

create table wish_list (
wish_list_id INT auto_increment,
user_id INT,
  PRIMARY KEY (wish_list_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

gift_id INT,
drop table wish_list;