package testlibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/*
Rent contain 2 object
-> user
-> book
These 2 object can offer many detail

we might not have to manage the ID of the object
I think the object is new Object everytime from the table
we only need book name and user name from GUI
-> after got the detail
--> make the where condition that match the book's name and user's name
-> create the object that is from table
the ID could be loaded into the object anyway doesn't cause ERROR 
 */
public class Rent {

    private int rentId;
    private User user;
    private Ebook book;
    private String genPassword;
    private LocalDate rentalDate;
    private LocalDate dueDate;
    private double price;
    private boolean isActive;

    public Rent(int rentId, User user, Ebook book, LocalDate rentalDate, LocalDate dueDate,double price) {
        //THIS CONSTRUCTOR IS USED WHEN LOAD FROM DB
        this.rentId = rentId;
        this.user = user;
        this.book = book;
        this.genPassword = genPassword;
        this.rentalDate = rentalDate;
        this.dueDate = dueDate;
        this.price = price;
        isActive = true;
    }
    
    public Rent(User user, Ebook book, LocalDate rentalDate, LocalDate dueDate, double price) {
        
        /*
        THIS CONSTRUCTOR IS USED WHEN UPLOADING TO DB
        SOME VALUE IS SELF-GENERATED : genPassword, price is from duration * book type, isActive is true logically.
        */
        this.user = user;
        this.book = book;
        genPassword = book.getRandomPassword();
        this.rentalDate = rentalDate;
        this.dueDate = dueDate;
        this.price = price;
        isActive = true;
    }
    
    public Rent(User user, Ebook book, LocalDate rentalDate, LocalDate dueDate, double price,String genPassword) {
        
        /*
        THIS CONSTRUCTOR IS USED WHEN UPLOADING TO DB
        SOME VALUE IS SELF-GENERATED : genPassword, price is from duration * book type, isActive is true logically.
        
        */
        this.user = user;
        this.book = book;
        this.genPassword = genPassword; 
        this.rentalDate = rentalDate;
        this.dueDate = dueDate;
        this.price = price;
        isActive = true;
    }

    public String getRentReceiptDetails() {

        String receiptTitle = "\t\tOOP PROJECT: Library\n";
        String line = "------------------------------------"
                + "----------------------------------------"
                + "----------------------------------\n";
        String bookName = "Book title: "+book.getBookName()+"\n";
        String author = "Author: "+book.getBookAuthor()+"\n";
        String userName = "Rent username: "+user.getUsername()+"\n";
        String userEmail = "User Email: "+user.getEmailAddress()+"\n";
        String bookPassword = "Ebook password: "+getGenPassword()+"\n";
        String bookDuration = "Rental duration: "+(int)calculateRentalDurationInDays()+""+"\n";
        String rentDate = "Rental date: "+getRentalDate()+"\n";
        String dueDate = "Due date: "+getDueDate()+"\n";
        String price = "Total price: "+calculatePrice();
        String receipt = receiptTitle+
                line+userName+userEmail+
                line+bookName+bookPassword+
                line+bookDuration+rentDate+dueDate+
                line+price;
        return receipt;
        
    }

    public String getRentDetails() {
        String receiptTitle = "\t\tOOP PROJECT: Library\n";
        String line = "------------------------------------"
                + "----------------------------------------"
                + "----------------------------------\n";
        String bookName = "Book title: "+book.getBookName()+"\n";
        String author = "Author: "+book.getBookAuthor()+"\n";
        String userName = "Rent username: "+user.getUsername()+"\n";
        String userEmail = "User Email: "+user.getEmailAddress()+"\n";
        String bookDuration = "Rental duration: "+(int)calculateRentalDurationInDays()+""+"\n";
        String rentDate = "Rental date: "+getRentalDate()+"\n";
        String dueDate = "Due date: "+getDueDate()+"\n";
        String price = "Total price: "+calculatePrice();
        String receipt =userName+userEmail+
                line+bookName+
                line+bookDuration+rentDate+dueDate+
                line+price;
        return receipt;
        
    }

    public double calculatePrice(){
        return getRentPrice()*(int)calculateRentalDurationInDays();
    }
    
    public double getRentPrice() {
        String genre = book.getGenre();
        if(genre.equalsIgnoreCase("Journal")){
            return 5;
        } else {
            return 10;
        }
    }
    
    public long calculateRentalDurationInDays() {
        return ChronoUnit.DAYS.between(rentalDate, dueDate);
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ebook getBook() {
        return book;
    }

    public void setEbook(Ebook book) {
        this.book = book;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    
    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    
    public boolean getIsActive(){
        return isActive;
    }
    
    public void setGenPassword(String genPassword){
        this.genPassword = genPassword;
    }
    
    public String getGenPassword(){
        return genPassword;
    }
}
