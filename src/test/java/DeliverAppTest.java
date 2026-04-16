import static org.junit.jupiter.api.Assertions.*;

import org.example.*;
import org.junit.jupiter.api.Test;

public class DeliverAppTest {
    @Test
    void priceWhenItsStandart1() {
        StandartParcel standartParcel = new StandartParcel("Стандартная", 1,"Ижевск", 20);
int result = standartParcel.calculateDeliveryCost();
assertEquals(2,result, "Сумма должна равняться весу умноженному на 2");

    }
    @Test
    void priceWhenItsStandart0() {
        StandartParcel standartParcel = new StandartParcel("Стандартная", 0,"Ижевск", 20);
        int result = standartParcel.calculateDeliveryCost();
        assertEquals(-1,result, "Вес не может быть меньше или равен нулю");

    }

    @Test
    void priceWhenItsFragile1(){
        FragileParcel fragileParcel = new FragileParcel("Хрупкая", 1,"Москвва",13);
        int result = fragileParcel.calculateDeliveryCost();
        assertEquals(4,result, "Сумма должна равняться весу умноженному на 4");
    }
    @Test
    void priceWhenItsFragile0(){
        FragileParcel fragileParcel = new FragileParcel("Хрупкая", 0,"Москвва",13);
        int result = fragileParcel.calculateDeliveryCost();
        assertEquals(-1,result, "Вес не может быть меньше или равен нулю");
    }


    @Test
    void priceWhenItsPerishable1(){
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся", 1,"Киров", 11,2);
        int result = perishableParcel.calculateDeliveryCost();
        assertEquals(3,result, "Сумма должна равняться весу умноженному на 3");
    }

    @Test
    void priceWhenItsPerishable0(){
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся", 0,"Киров", 11,2);
        int result = perishableParcel.calculateDeliveryCost();
        assertEquals(-1,result, "Вес не может быть меньше или равен нулю");
    }




    @Test
    void ifItsExpired(){
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся", 12,"Пермь", 3,2);
        boolean expired = perishableParcel.isExpired(6);
        assertTrue(expired);

    }
    @Test
    void ifItsNotExpired(){
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся", 12,"Пермь", 3,2);
        boolean expired = perishableParcel.isExpired(5);
        assertFalse(expired);
    }




    @Test
    void addStandartInBox(){
         ParcelBox<StandartParcel> standartBox = new ParcelBox<>(1400);
         StandartParcel standartParcel1 = new StandartParcel("Стандартная",800,"Москва",2);
         int isDone =standartBox.addParcel(standartParcel1);
         assertEquals(1,isDone);
        StandartParcel standartParcel2 = new StandartParcel("Стандартная",700,"Москва",4);
        int isNotDone =  standartBox.addParcel(standartParcel2);
        assertEquals(-1,isNotDone);


    }
    @Test
    void addFragileInBox() {
        ParcelBox<FragileParcel> fragileParcelParcelBox = new ParcelBox<>(1400);
        FragileParcel fragileParcel1 = new FragileParcel("Стандартная",800,"Москва",2);
       int isDone =  fragileParcelParcelBox.addParcel(fragileParcel1);
        assertEquals(1,isDone);
        FragileParcel firagileParcel2 = new FragileParcel("Стандартная",700,"Москва",4);
       int isNotDone =  fragileParcelParcelBox.addParcel(firagileParcel2);
        assertEquals(-1,isNotDone);
    }
        @Test
        void addPerishableInBox(){
            ParcelBox<PerishableParcel> perishableParcelParcelBox = new ParcelBox<>(1400);
             PerishableParcel perishableParcel1 = new PerishableParcel("Стандартная",800,"Москва",2,12);
            int isDone=  perishableParcelParcelBox.addParcel(perishableParcel1);
            assertEquals(1,isDone);
            PerishableParcel perishableParcel2 = new PerishableParcel("Стандартная",700,"Москва",4,11);
            int isNotDone=  perishableParcelParcelBox.addParcel(perishableParcel2);
            assertEquals(-1,-isNotDone);
        }
    }

