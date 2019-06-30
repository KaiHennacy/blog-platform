package wcci.blogplatform.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.blogplatform.models.Author;
import wcci.blogplatform.repos.AuthorRepository;


@Controller
@RequestMapping("/authors/")

public class AuthorController {

	@Resource
	AuthorRepository authorRepo;
	
	@RequestMapping("")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authorsView";
	}

	@RequestMapping("{id}")
	public String getAuthor(@PathVariable("id") Long id, Model model) {
		model.addAttribute("author", authorRepo.findById(id).get());
		return "singleAuthorView";
	}
	@PostMapping("add-author")
	public String addAuthor(String name) {
		authorRepo.save(new Author(name));
		return "redirect:/authors/";
	}

	
}


