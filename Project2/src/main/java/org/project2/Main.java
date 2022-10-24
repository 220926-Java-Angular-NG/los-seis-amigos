package org.project2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
// command to make docker db for this info "docker run --name magic -e POSTGRES_PASSWORD=123456 -p 5434:5432 -d postgres"

/*
create table cards(
cardid serial primary key,
name varchar(141) not null,
setname	varchar(3000),
imagefile	varchar(3000),
actualset	varchar(3000),
color	varchar(3000),
colorid	varchar(3000),
concost	varchar(3000),
manavalue	varchar(3000),
type	varchar(3000),
power	varchar(3000),
toughness	varchar(3000),
loyalty	varchar(3000),
rarity	varchar(3000),
text varchar(3000)
);
 */