package org.project2.model;

public class Pack {
    private int packId;
    private String setName;

    public Pack() {
    }

    @Override
    public String toString() {
        return "Pack{" +
                "packId=" + packId +
                ", setName='" + setName + '\'' +
                '}';
    }

    public Pack(int packId, String setName) {
        this.packId = packId;
        this.setName = setName;
    }

    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }
}
