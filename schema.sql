create database securityEx;
use securityEx;

create table users(
	id int primary key auto_increment,
    email varchar(255) unique not null,
    username varchar(255) not null,
    password varchar(255) not null
);

select * from users