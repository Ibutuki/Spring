create database test

CREATE TABLE tb_shopInfo (
    ID int PRIMARY KEY identity(0001,1),
    shopId varchar(20) unique NOT NULL,
    shopName varchar(20) NOT NULL,
    price float(4) NOT NULL,
    oldPrice float(4) NOT NULL,
    descr varchar(50) NOT NULL,
    insertDtm datetime
);

CREATE TABLE tb_order (
    ID int PRIMARY KEY identity(0001,1),
    orderId varchar(20) unique NOT NULL,
    createDtm datetime NOT NULL,
    state int NOT NULL CHECK (state IN (0, 1, 2, 3)) -- 0:待审核 1:已审核 2:已付款 3:已发货
);

CREATE TABLE tb_orderDetail (
    ID int PRIMARY KEY identity(0001,1),
    orderId varchar(20) NOT NULL foreign key(orderId) references tb_order(orderId),
    shopId varchar(20) NOT NULL foreign key(shopId) references tb_shopInfo(shopId),
    quantity int NOT NULL
);

CREATE TABLE tb_userInfo (
    ID int PRIMARY KEY identity(0001,1),
    userName varchar(10) NOT NULL unique,
    usePassword varchar(10) NOT NULL
);

CREATE TABLE tb_log (
    ID int PRIMARY KEY,
    userName varchar(10) NOT NULL foreign key(userName) references tb_userInfo(userName),
    loginDtm datetime NOT NULL,
    exitDtm datetime NOT NULL
);

INSERT INTO tb_shopInfo (shopId, shopName, price, oldPrice, descr, insertDtm)
VALUES 
('S001', '星巴克', 30.00, 35.00, '咖啡店', GETDATE()),
('S002', 'KFC', 25.00, 30.00, '快餐店', GETDATE()),
('S003', '华莱士', 20.00, 25.00, '快餐', GETDATE()),
('S004', '肯德基', 45.00, 50.00, '美食', GETDATE()),
('S005', '必胜客', 40.00, 45.00, '披萨店', GETDATE());
INSERT INTO tb_order (orderId, createDtm, state)
VALUES 
('O001', '2023-07-01 10:00:00', 1),
('O002', '2023-07-01 11:00:00', 2),
('O003', '2023-07-02 10:00:00', 0),
('O004', '2023-07-02 12:00:00', 3),
('O005', '2023-07-03 10:00:00', 1);
INSERT INTO tb_orderDetail (orderId, shopId, quantity)
VALUES 
('O001', 'S001', 1),
('O002', 'S002', 2),
('O003', 'S003', 3),
('O004', 'S004', 4),
('O005', 'S005', 5);
INSERT INTO tb_userInfo (userName, usePassword)
VALUES 
('user01', 'pass01'),
('user02', 'pass02'),
('user03', 'pass03'),
('user04', 'pass04'),
('user05', 'pass05');
INSERT INTO tb_log (ID, userName, loginDtm, exitDtm)
VALUES 
(1, 'user01', '2023-07-01 09:00:00', '2023-07-01 17:00:00'),
(2, 'user02', '2023-07-01 10:00:00', '2023-07-01 18:00:00'),
(3, 'user03', '2023-07-02 08:00:00', '2023-07-02 16:00:00'),
(4, 'user04', '2023-07-02 09:00:00', '2023-07-02 17:00:00'),
(5, 'user05', '2023-07-03 09:00:00', '2023-07-03 17:00:00');

