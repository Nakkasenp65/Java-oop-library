/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlibrary;

import java.util.Date;

public class Journal extends Ebook {

    private String subject;

    public Journal(int bookID,
            String bookName,
            String bookAuthor,
            String subject) {
        super(bookID,
                bookName,
                bookAuthor,
                "Journal",
                //                uploadDate, 
                5);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Journal "+super.toString();
    }

    @Override
    public String getBookDetails() {
        String journalSubject = "Subject: "+getSubject()+"\n";
        return super.getBookDetails()+journalSubject;
    }
}
