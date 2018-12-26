package com.tracholar.web.protobuf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zuoyuan on 2018/12/24.
 */
public class Demo1 {
    public static void main(String[] args) {
        AddressBookProtos.Person john = AddressBookProtos.Person.newBuilder()
                .setId(123)
                .setName("john")
                .setEmail("john@tracholar.com")
                .build();

        AddressBookProtos.AddressBook book = AddressBookProtos.AddressBook.newBuilder()
                .addPeople(john)
                .build();
        try {
            book.writeTo(new FileOutputStream("book.pb"));

            AddressBookProtos.AddressBook book2 = AddressBookProtos.AddressBook.parseFrom(new FileInputStream("book.pb"));
            for(AddressBookProtos.Person p : book2.getPeopleList()){
                System.out.println("id=" + p.getId() + "; name=" +p.getName() + "; email=" + p.getEmail());
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
