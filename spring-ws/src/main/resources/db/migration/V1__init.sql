create table students (id bigserial primary key, name varchar(255), age integer);
insert into students (name, age)
values
('Bob', 30),
('Max', 32);