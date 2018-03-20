CREATE DATABASE bullstore_0906;

CREATE TABLE bs_user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(40) UNIQUE NOT NULL,
    PASSWORD VARCHAR(40),
    email VARCHAR(40)
);

CREATE TABLE bs_product(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(40),
	address VARCHAR(40),
	price DOUBLE,
	sales INT,
	stock INT,
	img_path VARCHAR(100)
);

RENAME TABLE bs_product TO user_product;
