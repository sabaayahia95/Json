package com.smart.apps.json.models;

import java.util.List;

public class GroupRegex {

    private String name;
    private List<String> ItemNames;
    private List<String> Regex;

    public GroupRegex(String name, List<String> itemNames, List<String> regex) {
        this.name = name;
        ItemNames = itemNames;
        Regex = regex;
    }

    public String getName() {
        return name;
    }

    public GroupRegex setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getItemNames() {
        return ItemNames;
    }

    public GroupRegex setItemNames(List<String> itemNames) {
        ItemNames = itemNames;
        return this;
    }

    public List<String> getRegex() {
        return Regex;
    }

    public GroupRegex setRegex(List<String> regex) {
        Regex = regex;
        return this;
    }


    @Override
    public String toString() {
        return " name " + name + " - " +
                " ItemNames " + ItemNames + " - " +
                " Regex " + Regex + " - ";
    }
}
