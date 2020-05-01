package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Book book1 = new Book("Ramayan", "1");
		Author author1 = new Author("Valmiki", "Rishi");
		book1.getAuthors().add(author1);
		author1.getBooks().add(book1);
		
		Book book2 = new Book("Mahabharat", "2");
		Author author2 = new Author("Ved", "Vyasa");
		book2.getAuthors().add(author2);
		author2.getBooks().add(book2);
		
		authorRepository.save(author1);
		bookRepository.save(book1);
		authorRepository.save(author2);
		bookRepository.save(book2);
		
		System.out.println("Started in BootStrap");
		System.out.println("Number of books : " + bookRepository.count());
		System.out.println("Number of authors : " + authorRepository.count());
		
		Publisher publisher = new Publisher("Publisher", "Adityapur 1", "Jamshedpur", "Jharkhand", "831013");
		publisherRepository.save(publisher);
		System.out.println("Number of publishers : " + publisherRepository.count());
		
	}

}
