package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void testAdd() {
        //Given
        PhoneBook myPhoneBook = new PhoneBook();
        String name = "Cristina McClintock";
        String phoneNum = "8142791404";

        //When
        myPhoneBook.add(name,phoneNum);

        //Then
        Assert.assertEquals(phoneNum, myPhoneBook.lookUp(name));

    }
    @Test
    public void testAddSecondPhoneNum() {
        //Given
        PhoneBook myPhoneBook = new PhoneBook();
        String name = "Cristina Pierson";
        String phoneNum = "999-333-1488";
        String phoneNum2 = "767-444-3333";
        String expected = "999-333-1488, 767-444-3333";

        //When
        myPhoneBook.add(name, phoneNum);
        myPhoneBook.add(name, phoneNum2);

        //Then
        Assert.assertEquals(expected,myPhoneBook.lookUp(name));
    }

    @Test
    public void testRemoveRecord() {
        //Given
        PhoneBook myPhoneBook = new PhoneBook();
        String name = "Cristina Smith";
        String phoneNum = "814-279-1405";

        //When
        myPhoneBook.add(name, phoneNum);
        myPhoneBook.removeRecord(name);

        //Then
        Assert.assertEquals(null,myPhoneBook.lookUp(name));

    }

    @Test
    public void testRemovePhoneNum() {
        //Given
        PhoneBook myPhoneBook = new PhoneBook();
        String name = "Cristina Millz";
        String phoneNum = "814-279-1488";
        String phoneNum2 = "789-222-3333";

        //When
        myPhoneBook.add(name, phoneNum);
        myPhoneBook.add(name, phoneNum2);
        myPhoneBook.removeNumber(phoneNum2);


        //Then
        Assert.assertEquals(phoneNum,myPhoneBook.lookUp(name));
    }

    @Test
    public void testLookUp() {
        //Given
        PhoneBook myPhoneBook = new PhoneBook();
        String name = "Cristina MacIntosh";
        String phoneNum = "814-279-1406";

        //When
        myPhoneBook.add(name, phoneNum);

        //Then
        Assert.assertEquals(phoneNum,myPhoneBook.lookUp(name));

    }

    @Test
    public void testReverseLookUp() {
        //Given
        PhoneBook myPhoneBook = new PhoneBook();
        String name = "Cristina Calvo";
        String phoneNum = "814-279-1407";

        //When
        myPhoneBook.add(name, phoneNum);

        //Then
        Assert.assertEquals(name, myPhoneBook.reverseLookUp(phoneNum));

    }

    @Test
    public void testDisplay() {
        //Given
        PhoneBook myPhoneBook = new PhoneBook();
        String nameA = "Ann Anderson";
        String nameB = "Bill Billson";
        String nameC = "Cristina Cruz";
        String aPhoneNum = "902-122-3232";
        String bPhoneNum = "222-343-1212";
        String cPhoneNum = "814-279-1408";
        String expectedDisplayResult = "Ann Anderson 902-122-3232\n" +
                                       "Bill Billson 222-343-1212\n" +
                                       "Cristina Cruz 814-279-1408\n";

        //When
        myPhoneBook.add(nameA, aPhoneNum);;
        myPhoneBook.add(nameB, bPhoneNum);
        myPhoneBook.add(nameC, cPhoneNum);

        //Then
        Assert.assertEquals(expectedDisplayResult, myPhoneBook.display());

    }



}
