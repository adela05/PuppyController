package com.company.PuppyController;

public class Puppy {
    private int id;
    private String name;
    private  int kennelNum;
    private boolean isAdopted;

    //Constructor 2 leave empty
    public Puppy(){}

    //Constructor 1
    public Puppy(int id, String name, int kennelNum, boolean isAdopted){
        this.id=id;
        this.name=name;
        this.kennelNum=kennelNum;
        this.isAdopted=isAdopted;
    }
    //Setter and Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKennelNum() {
        return kennelNum;
    }

    public void setKennelNum(int kennelNum) {
        this.kennelNum = kennelNum;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }
}
