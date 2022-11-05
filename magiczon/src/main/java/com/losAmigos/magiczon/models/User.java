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

@Entity
@Table(name = "users")
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

    @Column
    private String password;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column(unique = true)
    private String email;

    @Column
    private boolean hasBought;

}
