package az.pashabank.springsimpleproject.model;



import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class AuthorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books;

	public AuthorModel(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public AuthorModel() {// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
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
		AuthorModel other = (AuthorModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + "," 
	+ " firstName=" + firstName + ", "
				+ "lastName=" + lastName + ","
	+ " books=" + books + "]";
	}

}
