package com.smart.apps.json.models;

import java.util.List;

public class JsonData {
    private String id;
    private String GroupName;
    private List<GroupRegex> GroupRegex;


    public JsonData(String id, String groupName, List<com.smart.apps.json.models.GroupRegex> groupRegex) {
        this.id = id;
        GroupName = groupName;
        GroupRegex = groupRegex;
    }

    public String getId() {
        return id;
    }

    public JsonData setId(String id) {
        this.id = id;
        return this;
    }

    public String getGroupName() {
        return GroupName;
    }

    public JsonData setGroupName(String groupName) {
        GroupName = groupName;
        return this;
    }

    public List<com.smart.apps.json.models.GroupRegex> getGroupRegex() {
        return GroupRegex;
    }

    public JsonData setGroupRegex(List<com.smart.apps.json.models.GroupRegex> groupRegex) {
        GroupRegex = groupRegex;
        return this;
    }

    @Override
    public String toString() {
        return " id " + id + " - " +
                "GroupName " + GroupName;
        //"GroupRegex " + GroupRegex + "\n";
    }
}
