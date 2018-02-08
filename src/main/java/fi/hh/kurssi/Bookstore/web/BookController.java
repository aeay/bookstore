package fi.hh.kurssi.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.kurssi.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@ResponseBody
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String welcomeBookstore(){
		return "Tervetuloa kirjakauppaan!";
	}
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String listBooks(Model model){
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	

}
