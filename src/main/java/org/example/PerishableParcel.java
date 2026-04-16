package org.example;

public class PerishableParcel extends Parcel {
    int timeToLive;
    public static final int FIX_PRICE = 3;

    public PerishableParcel(String description, int weight, String deliveryAdress,
                            int sendDay, int timeToLive) {
        super(description, weight, deliveryAdress, sendDay);
        this.timeToLive = timeToLive;

    }

    @Override
    public int getFixPrice(){
        return FIX_PRICE;
    }

    public boolean isExpired(int currentDay) {
        return currentDay> sendDay+timeToLive;
    }

    @Override
    public String toString() {
        return super.toString() + "Срок хранения: " + timeToLive;
    }
    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;
        PerishableParcel parcel = (PerishableParcel) o;
        return timeToLive == parcel.timeToLive;
    }
}
