create database school;

create table student(
	id int not null auto_increment primary key,
	nome text not null,
	email text not null,
	curso text not null
)