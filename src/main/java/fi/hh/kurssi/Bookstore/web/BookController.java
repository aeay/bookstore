package fi.hh.kurssi.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.kurssi.Bookstore.domain.Book;
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
	
	 @RequestMapping(value = "/add")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	        return "addbook";
	    }     
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	        return "redirect:booklist";
	    }    
	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    	repository.delete(bookId);
	        return "redirect:/booklist";
	    }  
	 
	 @RequestMapping(value= "/edit/{id}", method=RequestMethod.GET)
	 	public String editBook(@PathVariable("id") Long bookId, Model model) {
		 	repository.edit(bookId);
	 }
	

}
