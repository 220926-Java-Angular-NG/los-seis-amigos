package com.losAmigos.magiczon.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*
create table users(
id serial primary key,
user_name varchar(20) not null unique,
first_name varchar(20) not null,
last_name varchar(20) not null,
pass_word varchar(50)not null,
email	varchar(50)not null unique
);
*/

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String email;

    private boolean hasBought;

}
