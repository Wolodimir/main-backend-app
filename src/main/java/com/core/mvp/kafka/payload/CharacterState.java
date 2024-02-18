package com.core.mvp.kafka.payload;

public class CharacterState {

    private int health;
    private int stamina;
    private String name;
    private String id;

    public CharacterState() {
    }

    public CharacterState(int health, int stamina, String name, String id) {
        this.health = health;
        this.stamina = stamina;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "CharacterState{" +
                "health=" + health +
                ", stamina=" + stamina +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
