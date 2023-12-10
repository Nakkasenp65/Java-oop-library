package testlibrary;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Date;

public class Book extends Ebook {

    public Book(int bookID,
            String bookName,
            String bookAuthor,
            String genre) {
        super(bookID,
                bookName,
                bookAuthor,
                genre,
                10);
    }

    @Override
    public String toString() {
        return "Book "+super.toString();
    }
}
