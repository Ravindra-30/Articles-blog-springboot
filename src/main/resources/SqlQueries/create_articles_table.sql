CREATE TABLE `articles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `article_name` varchar(45) NOT NULL,
  `description` longtext,
  `date_created` date NOT NULL,
  `date_last_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `article_name_UNIQUE` (`article_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci