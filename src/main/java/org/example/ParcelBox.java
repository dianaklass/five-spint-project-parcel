package org.example;

import java.util.ArrayList;


public class ParcelBox<T extends Parcel> {
    private ArrayList<T> list = new ArrayList<>();
    private int maxWeight;
    private int currentSum = 0;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }


    public int addParcel(T type) {
        if (!list.contains(type)) {
            if (maxWeight >= ((type.weight) + currentSum)) {
                currentSum += type.weight;
                list.add(type);
                return 1;
            } else {
                System.out.println("Максимальный вес превышен, посылка не будет добавлена");
                return -1;
            }
        } else {
            System.out.println("Эта посылка уже есть в коробке");
            return -1;
        }
    }

    public ArrayList<T> getALLParcels() {
        return list;
    }
}


