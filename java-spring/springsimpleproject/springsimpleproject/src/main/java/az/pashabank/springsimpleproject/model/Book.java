package az.pashabank.springsimpleproject.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
private String title;
private String isbn;

@ManyToMany
@JoinTable(name = "author_book" , joinColumns = @JoinColumn(name = "book_id"),
inverseJoinColumns = @JoinColumn(name = "author_id") )
private Set<AuthorModel> authors;
public Book(String title, String isbn) {
	super();
	this.title = title;
	this.isbn = isbn;

}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public Set<AuthorModel> getAuthors() {
	return authors;
}
public void setAuthors(Set<AuthorModel> authors) {
	this.authors = authors;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	return Objects.equals(id, other.id);
}

@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", authors=" + authors + "]";
}



}