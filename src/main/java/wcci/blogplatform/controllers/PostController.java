package wcci.blogplatform.controllers;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.blogplatform.models.Post;
import wcci.blogplatform.models.TagEntity;
import wcci.blogplatform.repos.AuthorRepository;
import wcci.blogplatform.repos.GenreRepository;
import wcci.blogplatform.repos.PostRepository;
import wcci.blogplatform.repos.TagRepository;

@Controller
@RequestMapping("/")
public class PostController {
	@Resource
	PostRepository postRepo;
	
	@Resource
	GenreRepository genreRepo;
	
	@Resource
	AuthorRepository authorRepo;
	
	@Resource
	TagRepository tagRepo;
	
	@RequestMapping("home")
	public String getHome(Model model) {
		Collection<Post> posts = (Collection<Post>) postRepo.findAll();
		LocalDateTime latestDate = LocalDateTime.MIN;
		Long latestPostId = null;
		for(Post post : posts) {
			LocalDateTime postDate = post.getDateAndTime();
			if(postDate.isAfter(latestDate)) {
				latestDate = postDate;
				latestPostId = post.getId();
			}
		}
		model.addAttribute("post", postRepo.findById(latestPostId).get());
		return "homeView";
	}
	
	@RequestMapping("posts")
	public String getPosts(Model model) {
		Collection<Post> posts = (Collection<Post>) postRepo.findAll();
		model.addAttribute("posts", posts);
		return "postsView";
	}
	
	@RequestMapping("{id}")
	public String getSinglePost(@PathVariable("id") Long id, Model model) {
		model.addAttribute("post", postRepo.findById(id).get());
		return "singlePostView";
	}
	@RequestMapping("/posts/new")
	public String getNewPost(Model model) {
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("authors", authorRepo.findAll());
		return "newPostView";
	}
	@PostMapping("add-post")
	public String addPost(String title, String author, String content, String genre) {
		Post postAdd = new Post(title, authorRepo.findByName(author), content, genreRepo.findByName(genre));
		postRepo.save(postAdd);
		return "redirect:/" + postAdd.getId(); 
	}
	@PostMapping("add-tag")
	public String addTag(String name, Long id) throws Exception{
		Collection<TagEntity> tags = (Collection<TagEntity>)tagRepo.findAll();
		if (!tags.contains(tagRepo.findByName(name))) {
			postRepo.findById(id).get().addTag(tagRepo.save(new TagEntity(name)));
			postRepo.save(postRepo.findById(id).get());
		} else if (!postRepo.findById(id).get().getTags().contains(tagRepo.findByName(name))) {
			postRepo.findById(id).get().addTag(tagRepo.save(tagRepo.findByName(name)));
			postRepo.save(postRepo.findById(id).get());	
		}
		return "redirect:/" + id;
	}

}
