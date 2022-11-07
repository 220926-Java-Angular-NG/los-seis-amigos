package com.losAmigos.magiczon.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cards_owned")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class CardsOwned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryId;

    @Column(length = 51)
    private String imgLocation;

    @Column
    private Long userId;

    @Column
    private Integer quantity;





}
