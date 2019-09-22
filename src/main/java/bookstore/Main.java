package bookstore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        BookDAO bookDao = context.getBean("BookDataAccessObjectImp", bookstore.BookDAOimp.class);

        // Insert book "STAT" to Bookstore
        Book newBook = new Book(4, "math", 150);
        bookDao.save(newBook);

        // Find book ID 3
        System.out.println("Find book ID : 3 ");
        Book spring = bookDao.findById(3);
        System.out.println(spring);
        System.out.println("--------------------------------\n");

        // Show all book in Bookstore
        System.out.println("Book in store.");
        List<Book> bookList = bookDao.findAll();
        for (Book book : bookList) {
            System.out.println(book);
        }

        System.out.println("--------------------------------\n");
        // Undate price book ID 4 (STAT 300 -> 250)
        newBook.setPrice(250);
        bookDao.update(4, newBook);

        System.out.println("Searching book ID : 4 (STAT)");
        spring = bookDao.findById(4);
        System.out.println(spring);
        System.out.println("--------------------------------\n");


        // Delete Book ID 4
        System.out.println("Delete book by ID: 4");
        bookDao.deleteById(4);
        bookList = bookDao.findAll();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

}

