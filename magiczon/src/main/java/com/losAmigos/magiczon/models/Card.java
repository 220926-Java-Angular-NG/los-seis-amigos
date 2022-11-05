package com.losAmigos.magiczon.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "cards")
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Transient
    private String info;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    @Column
    private String setName;

    @Column
    private String imgLocation;

    @Column
    private String actualSet;

    @Column
    private String color;

    @Column
    private String colorID;

    @Column
    private String cost;

    @Column
    private String convertedCost;

    @Column
    private String type;

    @Column
    private String power;

    @Column
    private String toughness;

    @Column
    private String loyalty;

    @Column
    private String rarity;

    @Column
    private String draftQualities;

    @Column
    private String sound;

    @Column
    private String script;

    @Column
    private String text;

    public Card(String cardInformation) {
        this.info = cardInformation;
        loadInfo();
    }

    private void loadInfo() {
        String[] sl = info.split("	");// Separated line

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
                        this.name = sl[i];
                        break;
                    case 1:
                        this.setName = sl[i];
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

    }


}
