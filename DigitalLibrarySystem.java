import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book
{
     private String title;
     private String author;
     private int year;

     public Book(String title, String author, int year)
     {
        this.title = title;
        this.author = author;
        this.year = year;
     }

     public String getTitle()
     {
        return title;
     }

     public String getAuthor()
     {
        return author;
     }

     public int getYear()
     {
        return year;
     }
}

class Library
{
    private List<Book> books;

    public Library()
    {
       this.books = new ArrayList<>();
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public void removeBook(Book book)
    {
        books.remove(book);
    }
    public void displayBooks()
    {
        if(books.isEmpty())
        {
            System.out.println("NO BOOKS IN THE LIBRARY");
            return;
        }

        System.out.println("Books in the library");
        for(Book book : books)
        {
         System.out.println("Title:" + book.getTitle());
         System.out.println("Author:" + book.getAuthor());
         System.out.println("Year:" + book.getYear());
         System.out.println("-------------------------------");

        }
    }
    public List<Book> getBooks()
    {
        return books;
    }
}

public class DigitalLibrarySystem
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        while(true)
        {
            System.out.println("DIGITAL LIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                System.out.println("Enter the Book Title: ");
                String title = sc.nextLine();     
                System.out.println("Enter the Book Author: ");
                String author = sc.nextLine();
                System.out.println("Enter the Book Publication Year: ");
                int year = sc.nextInt();
                Book  book = new Book(title, author, year);
                library.addBook(book);
                System.out.println("Book Added Succesfully..!!");
                break;
            
                case 2: 
                System.out.println("Enter the title of the book: ");
                String bookTitle = sc.nextLine();
                boolean bookRemoved = false;
                for(Book b : library.getBooks())
                {
                    if(b.getTitle().equalsIgnoreCase(bookTitle))
                    {
                        library.removeBook(b);
                        bookRemoved = true;
                        System.out.println("Book removed Succesfully");
                        break;
                    }
                }
                if(!bookRemoved)
                {
                    System.out.println("Book not found in the library..");
                    break;
                }
                case 3: 
                    library.displayBooks();
                    break;
                case 4: 
                    System.out.println("Exiting the Program..!!");
                    //System.exit(status0);
                default:
                System.out.println("Invalid Choice..!! Please try again..");

            
            }
            System.out.println();

        }
    }
}