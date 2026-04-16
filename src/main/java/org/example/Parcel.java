package org.example;

import java.util.Objects;

public abstract class Parcel {
    String description;
    int weight;
    String deliveryAdress;
    int sendDay;

    public Parcel(String description, int weight, String deliveryAdress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAdress = deliveryAdress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAdress);
    }

    @Override
    public String toString() {
        return "Посылка: " + description + ", вес(гр): " + weight +
                ", адресс: " + deliveryAdress + ", день отправки: " + sendDay;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true ;
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return weight == parcel.weight && sendDay == parcel.sendDay && Objects.equals(description, parcel.description) && Objects.equals(deliveryAdress, parcel.deliveryAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, deliveryAdress, sendDay);
    }
    public abstract int getFixPrice();

   public  int calculateDeliveryCost(){
        if(weight>0){
            return weight* getFixPrice();
        }else{
            return -1;
        }
   }
}

