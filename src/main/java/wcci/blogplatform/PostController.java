package wcci.blogplatform;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PostController {
	@Resource
	PostRepository postRepo;
	
	@Resource
	GenreRepository genreRepo;
	
	@RequestMapping("home")
	public String getPosts(Model model) {
		Collection<Post> posts = (Collection<Post>) postRepo.findAll();
		model.addAttribute("posts", posts);
//		Collection<Genre> genres = (Collection<Genre>) genreRepo.findAll();
//		model.addAttribute("genre", genres);
		
		return "homeView";
	}
	
	@RequestMapping("{id}")
	public String getSinglePost(@PathVariable("id") Long id, Model model) {
		model.addAttribute("post", postRepo.findById(id).get());
		return "singlePostView";
	}

}
