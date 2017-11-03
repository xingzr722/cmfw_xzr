package com.xzr.entity;

/**
 * Created by F on 2017/10/31.
 */
public class Province {
    private String name;
    private String value;

    public Province() {
    }

    public Province(String name, String value) {

        this.name = name;
        this.value = value;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
