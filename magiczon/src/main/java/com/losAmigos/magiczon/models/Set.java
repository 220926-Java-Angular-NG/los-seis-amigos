package com.losAmigos.magiczon.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Set {

    @Id
    private String setcode;

    private String name;

    private String pack_image;

    // gerate
    public Set(String setInformation) {
        loadInfo(setInformation);
    }

    private void loadInfo(String infoReceived) {
        String[] sl = infoReceived.split(",");// Separated line

        for (int i = 0; i < sl.length; i++) {
            switch (i) {
                case 0:
                    this.name = sl[i];
                    break;
                case 1:
                    this.pack_image = sl[i];
                    break;
                case 2:
                    this.setcode = sl[i].toLowerCase();
                    break;
            }
            //displays contents of each line of inputfile
            System.out.println(i + "	 " + sl[i]);
        }
        //System.out.println();
    }
}


