package com.example.hw4_3month;

public class Countries {
  private  String name;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String flag;

    public Countries(String name, String flag) {
        this.name = name;
        this.flag = flag;
    }
}
