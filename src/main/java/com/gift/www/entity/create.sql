CREATE TABLE `user` (
  `id` INT auto_increment,
  `nickname` varchar(45) NULL,
  `name` varchar(45) NULL,
  `profile_image` varchar(200) NULL,
  `thumnail_image` varchar(200) NULL,
  `picture` varchar(200) NULL,
  `role` varchar(45) NULL,
  `email` varchar(45) NOT NULL,
  `phone_number` varbinary(45) NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

drop table user;