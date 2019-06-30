package wcci.blogplatform;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import wcci.blogplatform.controllers.PostController;
import wcci.blogplatform.models.Post;
import wcci.blogplatform.repos.AuthorRepository;
import wcci.blogplatform.repos.GenreRepository;
import wcci.blogplatform.repos.PostRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerMvcTest {
	
	@Resource
	private MockMvc mvc;
	
	@MockBean
	private PostRepository postRepo;
	
	@MockBean 
	private GenreRepository genreRepo;
	
	@MockBean
	private AuthorRepository authorRepo;
	
	@Mock
	private Post postOne;
	
	@Mock
	private Post postTwo;
	
	@Test
	public void shouldReturnAStatusOfOk() throws Exception {
		Collection<Post> posts = Arrays.asList(postOne, postTwo);
		when(postRepo.findAll()).thenReturn(posts);
		mvc.perform(get("/home")).andExpect(view().name(is("homeView")));
	}

}
