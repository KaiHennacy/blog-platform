package wcci.blogplatform;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


public class PostControlllerTest {
	
	@InjectMocks
	PostController underTest;
	@Mock
	private Post mockPost;
	@Mock
	PostRepository mockPostRepo;
	@Mock
	Model mockModel;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	Genre genre = new Genre();
	
	@Test
	public void shouldReturnOnePost() {
		Post testPost = new Post();
		List<Post> testPosts = Collections.singletonList(testPost);
		Mockito.when(mockPostRepo.findAll()).thenReturn(testPosts);
		underTest.getPosts(mockModel);
		Mockito.verify(mockModel).addAttribute("posts", testPosts);	
	}
	@Test
	public void shouldReturnAllReviews() {
		Post testPost1 = new Post();
		Post testPost2 = new Post();
		Post testPost3 = new Post();
		List<Post> testPosts= Arrays.asList(testPost1,testPost2,testPost3);
		Mockito.when(mockPostRepo.findAll()).thenReturn(testPosts);
		underTest.getPosts(mockModel);
		Mockito.verify(mockModel).addAttribute("posts", testPosts);
	}
	@Test
	public void displayPostsReturnsPostTemplate() {
		String templateName = underTest.getPosts(mockModel);
		assertEquals("homeView", templateName);	
	}
	@Test
	public void displayPostsAddPostsToModel() {
		when(mockPostRepo.findAll()).thenReturn(Collections.singletonList(mockPost));
		underTest.getPosts(mockModel);
		verify(mockModel).addAttribute("posts", Collections.singletonList(mockPost));
	}
	
}
