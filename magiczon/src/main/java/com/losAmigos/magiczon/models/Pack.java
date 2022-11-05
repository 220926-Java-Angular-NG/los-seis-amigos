package com.losAmigos.magiczon.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "packs")
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
