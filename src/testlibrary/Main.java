/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlibrary;

import java.time.LocalDate;

/**
 *
 * @author nakka
 */
public class Main {

    public static void main(String[] args) {

        Ebook eb = new Journal(0, "Sherlock Holmes", "Sir D. Arthur conan", "History");

//        System.out.println("Book Details\n"+eb.getBookDetails());
//        System.out.println("Your book password is " + eb.getPassword());
//        System.out.println("");
//        
//        Ebook eb2 = new Book(0, "Sherlock Holmes", "Sir D. Arthur conan", "Novel");
//        System.out.println("Book Details\n"+eb2.getBookDetails());
//        System.out.println("Your book password is " + eb2.getPassword());
//        System.out.println("");
//        
//        User user = new User(0, "nakasen", "1234", "nakasen@gmail.com");
//
//        Rent rent = new Rent(0, user, eb2, LocalDate.now(), LocalDate.now());
//
//        System.out.println("User details\n"+user.getUserDetails());
//        
//        System.out.println("");
//        System.out.println("Rent details\n" + rent.getRentDetails());
//
//        System.out.println("");
//        System.out.println("Rent reciept details\n" + rent.getRentReceiptDetails());
        
        LocalDate date = LocalDate.now();
        System.out.println("date: "+date);
        /*
        TOTAL DONE
        1. new Book
        2. new User
        3. new Rent
        
        TOTAL LEFT
        1. Condition for USER TOTAL BOOKS
        2. Give other user Access
        3. 
       
         */

    }
    
    
}
