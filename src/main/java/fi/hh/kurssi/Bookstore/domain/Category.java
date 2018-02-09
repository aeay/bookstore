package fi.hh.kurssi.Bookstore.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany
	private List<Book> books;
	
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.books = null;
	}
	
	public Category() {
		super();
		this.id = null;
		this.name = null;
		this.books = null;
	}
	
	public Category(String name) {
		super();
		this.id = null;
		this.name = name;
		this.books = null;
	}
	
	
	
	

}
