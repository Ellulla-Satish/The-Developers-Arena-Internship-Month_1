package week_2;


abstract class LibraryItem {
    protected String title;
    protected String author;
    protected boolean isBorrowed;

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public abstract void displayDetails();

    public void borrowItem() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }
}

class Book extends LibraryItem 
{
    private String genre;

    public Book(String title, String author, String genre) {
        super(title, author);
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Book] Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Borrowed: " + isBorrowed);
    }
}

class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, String author, int issueNumber) {
        super(title, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayDetails() {
        System.out.println("[Magazine] Title: " + title + ", Author: " + author + ", Issue No: " + issueNumber + ", Borrowed: " + isBorrowed);
    }
}


public class LibraryManagementSystem
{
	public static void main(String[] args) 
	{
        Book book1 = new Book("1984", "George Orwell", "Dystopian");
        Magazine mag1 = new Magazine("Tech Today", "John Doe", 25);

        book1.displayDetails();
        mag1.displayDetails();

        System.out.println("Borrowing process:");
        book1.borrowItem();
        mag1.borrowItem();

        book1.displayDetails();
        mag1.displayDetails();

        System.out.println("Returning process:");
        book1.returnItem();
        mag1.returnItem();

        book1.displayDetails();
        mag1.displayDetails();
    }
}
