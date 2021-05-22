package javainternship.uzduotis.BootStrap;

import javainternship.uzduotis.Objects.Book;
import javainternship.uzduotis.Repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BootStrapData(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Book Data");

        Book b1 = new Book();
        b1.setCategory("Fantasy");
        b1.setIsbn(123);
        b1.setLanguage("English");
        b1.setName("ASIOF");
        b1.setPublicationDate("1999-02-23");
        b1.setStatus("Present");
        b1.setAuthor("GRRM");

        bookRepository.save(b1);

        Book b2 = new Book();
        b2.setCategory("Drama");
        b2.setIsbn(124);
        b2.setLanguage("Lithuanian");
        b2.setName("Metai");
        b2.setPublicationDate("2020-02-23");
        b2.setStatus("Present");
        b2.setAuthor("Donelaitis");

        bookRepository.save(b2);

        Book b3 = new Book();
        b3.setCategory("True Story");
        b3.setIsbn(125);
        b3.setLanguage("English");
        b3.setName("PARAM");
        b3.setPublicationDate("2015-01-19");
        b3.setStatus("Taken");
        b3.setAuthor("Donelaitis");

        bookRepository.save(b3);

        System.out.println("Customers Saved: " + bookRepository.count());

    }
}
