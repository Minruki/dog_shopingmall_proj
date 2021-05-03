desc dog;

INSERT INTO dog
(kind, price, image, country, height, weight, content, readcount) VALUES
('푸들'  , 1000000, 'pu.jpg' , '프랑스' , 1, 20, '똑똑하다'  , 0),
('불독'  , 600000, 'bul.jpg', '영국'   , 1, 20, '불쌍해보인다', 0),
('진돗개', 3000000, 'jin.jpg', '대한민국', 1, 20, '멋있다'  , 0),
('허스키', 900000, 'h.jpg'  , '북극'   , 1, 20, '잘생겼다'  , 0);

select * from dog;
delete from dog where id = 6;
