package wcci.blogplatform;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class PostController {
	@Resource
	PostRepository postRepo;
	
	@RequestMapping("")
	public String getPost(Model model) {
		Collection<Post> posts = (Collection<Post>) postRepo.findAll();
		model.addAttribute("posts", posts);
		return "home";
	}

}
