package org.project2.model;

public class Card {
    private String info;
    private String name;
    private String setName;
    private String imgLocation;
    private String actualSet;
    private String color;
    private String colorID;
    private String cost;
    private String convertedCost;
    private String type;
    private String power;
    private String toughness;
    private String loyalty;
    private String rarity;
    private String draftQualities;
    private String sound;
    private String script;
    private String text;

    public Card(String cardInformation) {
        this.info = cardInformation;
        loadInfo();
    }

    private void loadInfo() {
        String[] sl = info.split("	");// Separated line

        System.out.println(sl.length != 17);


        if (sl.length != 17||sl[1].equals("Name")) {
            //dont load into database
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

    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }

    public String getActualSet() {
        return actualSet;
    }

    public void setActualSet(String actualSet) {
        this.actualSet = actualSet;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorID() {
        return colorID;
    }

    public void setColorID(String colorID) {
        this.colorID = colorID;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getConvertedCost() {
        return convertedCost;
    }

    public void setConvertedCost(String convertedCost) {
        this.convertedCost = convertedCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getDraftQualities() {
        return draftQualities;
    }

    public void setDraftQualities(String draftQualities) {
        this.draftQualities = draftQualities;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Card{" +
                "info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", setName='" + setName + '\'' +
                ", imgLocation='" + imgLocation + '\'' +
                ", actualSet='" + actualSet + '\'' +
                ", color='" + color + '\'' +
                ", colorID='" + colorID + '\'' +
                ", cost='" + cost + '\'' +
                ", convertedCost='" + convertedCost + '\'' +
                ", type='" + type + '\'' +
                ", power='" + power + '\'' +
                ", toughness='" + toughness + '\'' +
                ", loyalty='" + loyalty + '\'' +
                ", rarity='" + rarity + '\'' +
                ", draftQualities='" + draftQualities + '\'' +
                ", sound='" + sound + '\'' +
                ", script='" + script + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}