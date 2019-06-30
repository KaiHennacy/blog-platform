package wcci.blogplatform.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.blogplatform.models.TagEntity;
import wcci.blogplatform.repos.PostRepository;
import wcci.blogplatform.repos.TagRepository;

@Controller
@RequestMapping("/tags/")
public class TagController {
	@Resource
	TagRepository tagRepo;
	
	@Resource
	PostRepository postRepo;
	
	@RequestMapping("")
	public String getTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tagsView";
	}
	
	@RequestMapping("{id}/")
	public String getSingleGenre(@PathVariable("id") Long id, Model model) {
		model.addAttribute("tag", tagRepo.findById(id).get());
		return "singleTagView";
	}
	
	@PostMapping("add-empty-tag")
	public String addTag(String name) {
		TagEntity tagToAdd = new TagEntity(name);
		tagRepo.save(tagToAdd);
		
		return "redirect:/tags/";
	}
}
