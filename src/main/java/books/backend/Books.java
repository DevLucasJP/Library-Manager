package books.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {

	@Id
	private int id;
	@Column(name = "nome")
	private String name;
	@Column(name = "autor")
	private String author;
	@Column(name = "ano_de_lançamento")
	private int yearRelease;

	public Books() {
	}

	public Books(String name, String author, int yearRelease) {

		this.name = name;
		this.author = author;
		this.yearRelease = yearRelease;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(int yearRelease) {
		this.yearRelease = yearRelease;
	}
}
