package org.example;


public class FragileParcel extends Parcel implements Trackable {
    public static final int FIX_PRICE = 4;

    public FragileParcel(String description, int weight, String deliveryAdress, int sendDay) {
        super(description, weight, deliveryAdress, sendDay);

    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обернута в защитную пленку");
        super.packageItem();
    }

    @Override
    public int getFixPrice(){
        return FIX_PRICE;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }


}
