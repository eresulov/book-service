insert into users
(username,password,enabled,phone,name)
values
('u1','{noop}p1',1,'055-525-6363','User-1'),
('u2','{noop}p2',1,'077-525-9876','User-2'),
('u3','{noop}p3',1,'051-525-4366','User-3');

insert into authorities
(username,authority)
values
('u1','seller'),
('u2','seller'),
('u3','seller');
 
insert into computer
(brand,model,price,description,is_new,image_path,memory,cpu,drive_memory,username)
values
('HP','G62',548,'HP g62 computer',1,'hp-g62.jpg',8,'Core i7',500,'u1'),
('Acer','Aspire',859,'Acer Aspire computer',0,'acer-aspire.jpg',12,'Core i9',750,'u1'),
('HP','G62',544,'HP g62 computer',1,'hp-g62.jpg',8,'Core i7',800,'u1'),
('HP','G62',1254,'HP g62 computer',0,'hp-g62.jpg',8,'Core i3',300,'u2'),
('HP','G62',654,'HP g62 computer',1,'hp-g62.jpg',8,'Core i11',200,'u2');
 


