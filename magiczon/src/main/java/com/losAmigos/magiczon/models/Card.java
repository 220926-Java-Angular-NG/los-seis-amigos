package com.losAmigos.magiczon.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
public class Card {

//    @Transient
//    private String info;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Column(length = 141)
    @NotNull
    private String name;

    @Column(length = 13)
    @NotNull
    private String setName;

    @Column(length = 51)
    private String imgLocation;

    @Column(length = 4)
    private String actualSet;

    @Column(length = 5)
    private String color;

    @Column(length = 5)
    private String colorID;

    @Column(length = 46)
    private String cost;

    @Column(length = 10)
    private String convertedCost;

    @Column(length = 49)
    private String type;

    @Column(length = 10)
    private String power;

    @Column(length = 3)
    private String toughness;

    @Column(length = 1)
    private String loyalty;

    @Column(length = 1)
    private String rarity;

//    @Column(length = 5000)
    private String draftQualities;

//    @Column(length = 5000)
    private String sound;

    @Column(length = 1500)
    private String script;

    @Column(length = 907)
    private String text;

    public Card(String cardInformation) {
//        this.info = cardInformation;
        loadInfo(cardInformation);
    }

    private void loadInfo(String infoReceived) {
        String[] sl = infoReceived.split("	");// Separated line

        //System.out.println(sl.length != 17);


        if (sl[0].equals("Name")) {
            //dont load into database if its the header
            System.out.println("Second value form table: " + sl[1]);
        } else {
            for (int i = 0; i < sl.length; i++) {
                if (sl[i].equals(" "))
                    System.out.println("SPACE!");
                switch (i) {
                    case 0:
                        this.name = sl[i] != null ? sl[i] : " ";
                        break;
                    case 1:
                        this.setName = sl[i] != null ? sl[i] : " ";
                        break;
                    case 2:
                        this.imgLocation = sl[i];
                        break;
                    case 3:
                        this.actualSet = sl[i];
                        break;
                    case 4:
                        this.color = sl[i];
                        break;
                    case 5:
                        this.colorID = sl[i];
                        break;
                    case 6:
                        this.cost = sl[i];
                        break;
                    case 7:
                        this.convertedCost = sl[i];
                        break;
                    case 8:
                        this.type = sl[i];
                        break;
                    case 9:
                        this.power = sl[i];
                        break;
                    case 10:
                        this.toughness = sl[i];
                        break;
                    case 11:
                        this.loyalty = sl[i];
                        break;
                    case 12:
                        this.rarity = sl[i];
                        break;
                    case 13:
                        this.draftQualities = sl[i];
                        break;
                    case 14:
                        this.sound = sl[i];
                        break;
                    case 15:
                        this.script = sl[i];
                        break;
                    case 16:
                        this.text = sl[i];
                        break;
                }
                //displays contents of each line of inputfile
                //System.out.println(i + "	 " + sl[i]);
            }
            //System.out.println();
        }

        if (this.name == null) this.name = "";
        if (this.setName == null) this.setName = "";

    }


}
