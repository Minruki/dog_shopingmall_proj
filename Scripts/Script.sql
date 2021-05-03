select * from dog;

SELECT id, kind, price, image, country, height, weight, content, readcount
FROM   dog;

SELECT id, kind, price, image, country, height, weight, content, readcount
FROM   dog
 where id = 1;

INSERT INTO dog (kind, price, image, country, height, weight, content) VALUES
('포메라니안'  , 1000000, 'for2.jpg' , '일본' , 1, 20, '엄청 귀엽다');


INSERT INTO dog (kind, price, image, country, height, weight, content) VALUES
('사모예드'  , 6000000, 'sa.jpg' , '시베리아' , 1, 20, '엄청 사랑스럽다');

UPDATE shoppingmall.dog
SET kind='푸들', price=1000000, image='pu.png', country='프랑스', height=1, weight=20, content='똑똑하다', readcount=7
WHERE id=1;


delete from dog where id=9; 