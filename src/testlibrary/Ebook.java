/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlibrary;

import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Ebook {

    private int bookID;
    private String bookName;
    private String bookAuthor;
    private String genre;
//    private Date uploadDate;
    private String userName;
//    private String password;
    private double price;

    public Ebook() {
    }

    public Ebook(int bookID, String bookName, String bookAuthor, String genre, double price) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.genre = genre;
//        this.uploadDate = uploadDate;
        userName = null;
//        password = null;
        this.price = price;
    }

//    public Ebook(int bookID, String bookName, String bookAuthor, String genre, double price) {
//        this.bookID = bookID;
//        this.bookName = bookName;
//        this.bookAuthor = bookAuthor;
//        this.genre = genre;
////        this.uploadDate = uploadDate;
//        this.price = price;
//    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

//    public void setUploadDate(Date uploadDate) {
//        this.uploadDate = uploadDate;
//    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getGenre() {
        return genre;
    }

//    public Date getUploadDate() {
//        return uploadDate;
//    }
    
    public String getUserName() {
        return userName;
    }

//    public String getPassword() {
//        return password;
//    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "bookID=" + bookID
                + ", bookName='" + bookName + '\''
                + ", bookAuthor='" + bookAuthor + '\''
                + ", genre='" + genre + '\''
                 //                ", uploadDate=" + uploadDate +
                
                + ", userName='" + userName + '\''
//                + ", password='" + password + '\''
                + ", price=" + price
                + '}';
    }

    public String getRandomPassword(){

        String lowercase_alphabeth = "abcdefghijklmnopqrstuvwxyz";
        String uppercase_alphabeth = lowercase_alphabeth.toUpperCase();
        String number = "1234567890";
        String random_password = lowercase_alphabeth+uppercase_alphabeth+number;
        String genPassword = "";
        Random r = new Random();
        for(int i = 0; i < 9; i++){
            int randomNumber = r.nextInt(random_password.length());
            genPassword += random_password.charAt(randomNumber);
        }
        return genPassword;

    }

    public String getBookDetails(){

        String bookName = "Book Name: "+getBookName()+"\n";
        String bookAuthor = "Author: "+getBookAuthor()+"\n";
        String bookGenre = "Genre: "+getGenre()+"\n";
        String price = "Price: "+getPrice()+"\n";
        return bookName+bookAuthor+bookGenre+price;

    }
}
