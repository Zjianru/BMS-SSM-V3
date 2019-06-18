package com.code.bms.pojo;

public class ReaderCard {
    private Integer readerId;

    private String name;

    private String passwd;

    private Byte cardState;

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Byte getCardState() {
        return cardState;
    }

    public void setCardState(Byte cardState) {
        this.cardState = cardState;
    }
}