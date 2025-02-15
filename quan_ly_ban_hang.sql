create database if not exists  quan_ly_ban_hang;
use quan_ly_ban_hang;
create table Customer(
    cID int auto_increment primary key,
    cName varchar(50) not null default('abc'),
    cAge int(3)
);
    create table `order`(
        oID int auto_increment primary key,
        oDate int,
        oTotaPrice int,
        foreign key (oID) references Customer(cID)
    );
create table Product(
    pID int auto_increment primary key,
    pName varchar(50),
    pPrice int
);
create table OrderDetail(
    oID int,
    pID int,
    odQTV int,
    primary key (oID,pID),
    foreign key (oID) references `Order`(oID),
    foreign key (pID) references Product(pID)

);