package wcci.blogplatform;

import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostEntityMappingTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private TagRepository tagRepo;
	
	@Test
	public void shouldSaveAndLoadPost() {
		Author testAuthor = new Author("");
		Genre testGenre = new Genre();
		Post testPost = new Post("My Trip to Cedar Point", testAuthor, "fun trip", testGenre);
		postRepo.save(testPost);
		authorRepo.save(testAuthor);
		genreRepo.save(testGenre);
		entityManager.flush();
		entityManager.clear();
		
		Post foundPost = postRepo.findById(testPost.getId()).get();
		assertThat(foundPost, is(testPost));
		assertThat(foundPost.getTitle()).isEqualTo(testPost.getTitle());		
	}
	@Test
	public void shouldSaveAndLoadGenre() {
		Author testAuthor = new Author("");
		Genre testGenre = new Genre();
		Post testPost = new Post("My Trip to Cedar Point", testAuthor, "fun trip", testGenre);
		postRepo.save(testPost);
		authorRepo.save(testAuthor);
		genreRepo.save(testGenre);
		entityManager.flush();
		entityManager.clear();
		
		Genre foundGenre = genreRepo.findById(testGenre.getId()).get();
		assertThat(foundGenre, is(testGenre));
		assertThat(foundGenre.getType()).isEqualTo(testGenre.getType());		
	}
	@Test
	public void shouldSaveAndLoadAuthor() {
		Author testAuthor = new Author("");
		Genre testGenre = new Genre();
		Post testPost = new Post("My Trip to Cedar Point", testAuthor, "fun trip", testGenre);
		postRepo.save(testPost);
		authorRepo.save(testAuthor);
		genreRepo.save(testGenre);
		entityManager.flush();
		entityManager.clear();
		
		Author foundAuthor = authorRepo.findById(testAuthor.getId()).get();
		assertThat(foundAuthor, is(testAuthor));
		assertThat(foundAuthor.getName()).isEqualTo(testAuthor.getName());		
	}
	
}
