package springframework.spring6webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.spring6webapp.domain.Author;
import springframework.spring6webapp.domain.Book;
import springframework.spring6webapp.domain.Publisher;
import springframework.spring6webapp.repositories.AuthorRepository;
import springframework.spring6webapp.repositories.BookRepository;
import springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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
        savedBook1.getAuthors().add(savedAuthor1);
        savedBook2.getAuthors().add(savedAuthor2);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Publisher1");
        publisher.setAddress("United State");
        publisherRepository.save(publisher);

        savedBook1.setPublisher(publisher);
        savedBook2.setPublisher(publisher);


        authorRepository.save(savedAuthor1);
        authorRepository.save(savedAuthor2);
        bookRepository.save(savedBook1);
        bookRepository.save(savedBook2);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());





    }
}
