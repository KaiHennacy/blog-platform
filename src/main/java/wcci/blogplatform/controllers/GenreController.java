package wcci.blogplatform.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.blogplatform.models.Genre;
import wcci.blogplatform.repos.GenreRepository;
import wcci.blogplatform.repos.PostRepository;

@Controller
@RequestMapping("/genres/")
public class GenreController {
	@Resource
	GenreRepository genreRepo;
	
	@Resource
	PostRepository postRepo;
	
	@RequestMapping("")
	public String getGenres(Model model) {
		model.addAttribute("genres", genreRepo.findAll());
		return "genresView";
	}
	
	@RequestMapping("{id}")
	public String getSingleGenre(@PathVariable("id") Long id, Model model) {
		model.addAttribute("genre", genreRepo.findById(id).get());
		return "singleGenreView";
	}
	
	@PostMapping("add-genre")
	public String addGenre(String name) throws Exception{
//		Collection<Genre> genres = (Collection<Genre>) genreRepo.findAll();
//		if(!genres.contains(genreRepo.findByName(name))) {
			Genre genreToAdd = new Genre(name);
			genreRepo.save(genreToAdd);
//		}
		return "redirect:/genres/" + genreRepo.findByName(name).getId();
	}
}
