package com.core.mvp.kafka.payload;

public class CharacterState {

    private int health;
    private int stamina;
    private String userName;
    private String id;

    public CharacterState() {
    }

    public CharacterState(int health, int stamina, String userName, String id) {
        this.health = health;
        this.stamina = stamina;
        this.userName = userName;
        this.id = id;
    }

    @Override
    public String toString() {
        return "CharacterState{" +
                "health=" + health +
                ", stamina=" + stamina +
                ", name='" + userName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
