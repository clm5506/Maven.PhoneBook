package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    SortedMap<String, ArrayList<String>> phoneBook = new TreeMap<String, ArrayList<String>>();

   // SortedMap<String, String> phoneBook = new TreeMap<String, String>();

    public void add(String name, String phoneNum) {

       if(phoneBook.get(name) == null) {
           ArrayList<String> phoneBookArrayList = new ArrayList<String>();
           phoneBookArrayList.add(phoneNum);

           phoneBook.put(name,phoneBookArrayList);

       } else if(phoneBook.get(name) != null){
          // for(Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()){
             //  if(entry.getKey().equals(name)) {
               //    entry.getValue().add(phoneNum);
           phoneBook.get(name).add(phoneNum);

               }
       }


    public String lookUp(String name) {
        if(phoneBook.get(name) != null ) {
            ArrayList<String> phoneNumber = phoneBook.get(name);
            String result = phoneNumber.toString().replace("[", "").replace("]", "");
            return result;
        } else {
            return null;
        }
    }

    public void removeRecord(String name) {

        phoneBook.remove(name);

    }

    public void removeNumber(String phonNum) {

        String name = reverseLookUp(phonNum);
        ArrayList<String> phoneNumbers = phoneBook.get(name);

       int index = phoneNumbers.indexOf(phonNum);

       if(index != -1) {
           phoneBook.get(name).remove(index);
       }
    }

    public String reverseLookUp(String phoneNum) {
        String name = "";
        //ArrayList<String> newPhoneNum = new ArrayList<String>();
        //newPhoneNum.add(phoneNum);
        for(Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            for(int i = 0; i < entry.getValue().size(); i++) {

                if (entry.getValue().indexOf(phoneNum) != -1) {
                    name = entry.getKey();

                }
            }
        }
        return name;
    }


    public String display() {
        String ans = "";

        for(Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            ans = ans + entry.getKey() + " " + entry.getValue().toString()
                    .replace("[","").replace("]","") + "\n";
        }
        System.out.print(ans);

        return ans;
    }
}
