package wcci.blogplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private PostRepository postRepo;


	@Override
	public void run(String... args) throws Exception {
		Post cedarPoint = new Post("My Trip to Cedar Point","Kai Hennacy", "I had a really good time at Cedar Point! I loved the part when I went super fast down, and almost died. The ride's track broke and birds tried to eat my...");
		postRepo.save(cedarPoint);
		
		Post myAwesomeCat = new Post("Why My Cat Is Awesome","Kai Hennacy", "I was out in the wild and I saw a wild cat. It looked so fierce, it barred it's teath at me and snarled. My first thought was 'what a fur-ocious cat! Now I own that cat...'");
		postRepo.save(myAwesomeCat);
	}
}
