package com.example.scankitdemo.core;

public class ItemEntity {

    private final Integer kusy;
    private final Integer plu;


    public ItemEntity(Integer firstName, Integer plu, String age, Integer id) {
        this.kusy = firstName;
        this.plu = plu;

    }

    public Integer getFirstName() {
        return kusy;
    }

    public Integer getLastName() {
        return plu;
    }




    //public String getId() {return  id;}

    @Override
    public String toString() {
        return "BusinessEntity{" +
                "firstName='" + kusy + '\'' +
                ", lastName='" + plu + '\'' +

                '}';
    }
}