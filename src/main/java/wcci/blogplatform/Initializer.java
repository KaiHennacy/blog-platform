package wcci.blogplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		Genre travel = new Genre("travel");
		genreRepo.save(travel);
		
		Genre pets = new Genre("pets");
		genreRepo.save(pets);
		
		Author kai = new Author("Kai Hennacy");
		authorRepo.save(kai);
		
		Author isaac = new Author("Isaac Kim");
		authorRepo.save(isaac);
		
		TagEntity park = new TagEntity("park");
		tagRepo.save(park);
		
		TagEntity cat = new TagEntity("cat");
		tagRepo.save(cat);

		
		
		Post cedarPoint = new Post("My Trip to Cedar Point", kai, "I had a really good time at Cedar Point! I loved the part when I went super fast down, and almost died. The ride's track broke and birds tried to eat my...", travel);
		postRepo.save(cedarPoint);
		
		Post myAwesomeCat = new Post("Why My Cat Is Awesome", isaac, "I was out in the wild and I saw a wild cat. It looked so fierce, it barred it's teath at me and snarled. My first thought was 'what a fur-ocious cat! Now I own that cat...'", pets);
		postRepo.save(myAwesomeCat);
		
		
		cedarPoint.addTag(park);
		myAwesomeCat.addTag(cat);
	}
}
