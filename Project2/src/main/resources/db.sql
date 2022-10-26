create table cards(
cardid serial primary key,
name varchar(141) not null,
setname    varchar(13),
imagefile    varchar(51) not null unique,
actualset    varchar(4),
color    varchar(5),
colorid    varchar(5),
concost    varchar(46),
manavalue    varchar(7),
type    varchar(49),
power    varchar(10),
toughness    varchar(3),
loyalty    varchar(1),
rarity    varchar(1),
text varchar(907)
);

create table users(
userid serial primary key,
firstname varChar(50),
lastname varChar(50),
email varchar(89) not null unique,
password varchar(25) not null,
hasCart boolean default false
);

create table cardsowned(
userid int not null,
cardid int not null,
number_owned int default 1,
foreign key (userid) references users(userid),
foreign key (cardid) references cards(cardid)
);

create table packs(
packId serial primary key,
setname varchar(13)
);

create table packspurchased(
userid int not null,
packid int not null,
foreign key (userid) references users(userid),
foreign key (packid) references packs(packid)
);

create table cart (
userid int not null,
quantity int default 1,
packid int not null,
foreign key (userid) references users(userid),
foreign key (packid) references packs(packid)
);