package org.example;

public class StandartParcel extends Parcel {
    public static final int FIX_PRICE = 2;

    public StandartParcel(String description, int weight, String deliveryAdress, int sendDay) {
        super(description, weight, deliveryAdress, sendDay);
    }

    @Override
    public int getFixPrice(){
        return FIX_PRICE;
    }
}
