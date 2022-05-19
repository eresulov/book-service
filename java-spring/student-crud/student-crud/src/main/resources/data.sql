insert into users
(username,password,enabled)
values
('m1','{noop}m1',1),
('m2','{noop}m2',1),
('m3','{noop}m3',1);

insert into authorities
(username,authority)
values
('m1','teacher'),
('m2','teacher'),
('m3','teacher');

insert into student
(name,surname)
values('Emral','Resulov'),
('Anar','Murtuzayev'),
('Tahir','Xelilov');