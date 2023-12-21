package springframework.spring6webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.spring6webapp.domain.Author;
import springframework.spring6webapp.domain.Book;
import springframework.spring6webapp.repositories.AuthorRepository;
import springframework.spring6webapp.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Author author1 = new Author();
        author1.setFirstName("first_name1");
        author1.setLastName("last_name1");

        Book book1 = new Book();
        book1.setTitle("book_title1");
        book1.setIsbn("123456");

        Author savedAuthor1 = authorRepository.save(author1);
        Book savedBook1 = bookRepository.save(book1);

        Author author2 = new Author();
        author2.setFirstName("first_name2");
        author2.setLastName("last_name2");

        Book book2 = new Book();
        book2.setTitle("book_title2");
        book2.setIsbn("654321");

        Author savedAuthor2 = authorRepository.save(author2);
        Book savedBook2 = bookRepository.save(book2);

        savedAuthor1.getBooks().add(savedBook1);
        savedAuthor2.getBooks().add(savedBook2);

        authorRepository.save(savedAuthor1);
        authorRepository.save(savedAuthor2);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());





    }
}
