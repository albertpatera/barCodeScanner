package com.example.scankitdemo.core;

public class ItemEntity {

    private final Integer kusy;
    private final Integer plu;


    public ItemEntity(Integer pcs, Integer plu, String age, Integer id) {
        this.pcs = pcs;
        this.plu = plu;

    }

    public Integer getPieces() {
        return pcs;
    }

    public Integer getPlu() {
        return plu;
    }




    //public String getId() {return  id;}

    @Override
    public String toString() {
        return "ItemEntity{" +
                "pieces='" + pcs + '\'' +
                ", plu='" + plu + '\'' +

                '}';
    }
}
