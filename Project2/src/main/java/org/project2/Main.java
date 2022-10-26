package org.project2;

import org.project2.repo.CardRepo;

public class Main {
    public static void main(String[] args) {
        CardRepo cardRepo = new CardRepo();
    }
}
// command to make docker db for this info "docker run --name magic -e POSTGRES_PASSWORD=123456 -p 5434:5432 -d postgres"

/*
create table cards(
cardid serial primary key,
name varchar(141) not null,
setname	varchar(3000),
imagefile	varchar(3000) not null unique,
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