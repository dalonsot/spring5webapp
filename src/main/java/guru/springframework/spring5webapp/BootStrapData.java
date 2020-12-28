package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.entities.Author;
import guru.springframework.spring5webapp.repositories.AuthorsRepository;
import guru.springframework.spring5webapp.entities.Publisher;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private PublisherRepository publisherRepository;

    public BootStrapData(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    AuthorsRepository authorsRepository;

    public BootStrapData(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setName("Stephen King");
        authorsRepository.save(author1);

        Author author2 = new Author();
        author2.setName("Miguel de Cervantes");
        authorsRepository.save(author2);

        System.out.println("Authors added: " + authorsRepository.count());

        System.out.println("Begin BootStrapData");

        Publisher publisher = new Publisher();
        publisher.setAddressLine("Calle Augusto Figueroa");
        publisher.setCity("Madrid");
        publisher.setPostcode(28004);

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
