drop database if exists module_6_sprint_2; 
create database module_6_sprint_2; 
use module_6_sprint_2;

CREATE TABLE IF NOT EXISTS book_types (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    is_delete BIT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    image TEXT,
    detail TEXT,
    supplier VARCHAR(100),
    author VARCHAR(100),
    translator VARCHAR(100),
    publisher VARCHAR(100),
    publish_year INT,
    weight INT,
    demension VARCHAR(100),
    pages INT,
    cover VARCHAR(50),
    price DOUBLE,
    stock MEDIUMINT,
    details TEXT,
    book_type INT,
    FOREIGN KEY (book_type)
        REFERENCES book_types (id),
    is_delete BIT DEFAULT 0
);
CREATE TABLE IF NOT EXISTS user (
    username VARCHAR(30) PRIMARY KEY,
    password VARCHAR(200),
    is_delete BIT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS role (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    is_delete BIT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS user_role (
    username VARCHAR(50),
    role_id INT,
    is_delete BIT DEFAULT 0,
    FOREIGN KEY (username)
        REFERENCES user (username),
    FOREIGN KEY (role_id)
        REFERENCES role (id),
    PRIMARY KEY (username , role_id)
);
CREATE TABLE IF NOT EXISTS bills (
    id INT PRIMARY KEY AUTO_INCREMENT,
    role_id INT,
    is_delete BIT DEFAULT 0,
    FOREIGN KEY (username)
        REFERENCES user (username),
    FOREIGN KEY (role_id)
        REFERENCES role (id),
    PRIMARY KEY (username , role_id)
);
create table if not exists customers(
	id int primary key auto_increment,
	name varchar(30),
    phone_number varchar(15),
	day_of_birth varchar(30),
    email varchar(100), 
	gender int,
	email varchar(100),
	address varchar(200),
	username varchar(30) unique,
    is_delete bit default 0,
	foreign key (username) references user(username)
);
create table if not exists shipping (
id int primary key auto_increment, 
method varchar(100), 
price double
); 
create table if not exists orders(
	id int primary key auto_increment,
    book_id int, 
    customer_id int, 
    quantity smallint,
	shipping_id int,
    payment_method varchar(100), 
	`status` varchar(100),
	total double,
	date_process varchar(50),
	date_finish varchar(50),
    is_delete bit default 0,
	foreign key (book_id) references books(id), 
	foreign key (customer_id) references customers(id),
	foreign key (shipping_id) references shipping(id)
);
create table if not exists order_detail(
id int primary key auto_increment, 
customer_id int, 
order_id int, 
foreign key (customer_id) references customers(id), 
foreign key (order_id) references orders(id)
);




 
