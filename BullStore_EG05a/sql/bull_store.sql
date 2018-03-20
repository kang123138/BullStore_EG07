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

CREATE TABLE bs_order(
	id VARCHAR(50) PRIMARY KEY, -- 订单号
	order_time DATETIME, -- 下单时间
	total_count INT, -- 订单中商品总数量
	total_money DOUBLE, -- 订单中商品的总金额
	state INT, -- 订单中商品的状态
	user_id INT,
	CONSTRAINT FOREIGN KEY(user_id) REFERENCES bs_user2(id)
);
