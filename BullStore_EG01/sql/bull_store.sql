-- 创建商城的数据库
CREATE DATABASE bullstore_0906;

-- 创建用户表bs_user
CREATE TABLE bs_user (
   
   id INT PRIMARY KEY AUTO_INCREMENT,
   username VARCHAR(40) UNIQUE NOT NULL,
   PASSWORD VARCHAR(40),
   email VARCHAR(40)

);