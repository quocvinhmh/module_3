use quan_ly_ban_hang;
-- thêm vào bảng customer ---
insert into Customer (cID, cName, cAge) values
                         (1, 'Minh Quan', 10),
                         (2, 'Ngoc Oanh', 20),
                         (3, 'Hong Ha', 50);
-- thêm vào bảng order--

insert into `Order` (oID, oDate, oTotaPrice)  values
                        (1, 1, '2006321'),
                        (2, 2, '2006323'),
                        (3, 1, '2006316');
-- thêm vào bảng product --
insert into Product values
                        (1, 'May Giat', 3),
                        (2, 'Tu Lanh', 5),
                        (3, 'Dieu Hoa', 7),
                        (4, 'Quat', 1),
                        (5, 'Bep dien', 2);
-- thêm vào bảng orderdetail--
insert into OrderDetail (oID, pID, odQTV) values
                                              (1, 1, 3),
                                              (1, 3, 7),
                                              (1, 4, 2),
                                              (2, 1, 1),
                                              (3, 1, 8),
                                              (2, 5, 4),
                                              (2, 3, 3);
DESC `Order`;
