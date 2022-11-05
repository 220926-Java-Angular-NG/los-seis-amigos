package com.losAmigos.magiczon.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pack {

    @Id
    private Integer packId;

    private String setName;

}
