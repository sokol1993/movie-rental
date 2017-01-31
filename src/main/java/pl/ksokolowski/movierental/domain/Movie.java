package pl.ksokolowski.movierental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	private String title;
	@ManyToOne
	private Director director;
	@ManyToOne
	private CountryOfProduction countryOfProduction;
	@ManyToOne
	private ProducitonYear producitonYear;
	@ManyToOne
	private Genre genre;
	@ManyToOne
	private AgeCategory ageCategory;
	
	private String available = "TAK"; 
	
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public CountryOfProduction getCountryOfProduction() {
		return countryOfProduction;
	}
	public void setCountryOfProduction(CountryOfProduction countryOfProduction) {
		this.countryOfProduction = countryOfProduction;
	}
	public ProducitonYear getProducitonYear() {
		return producitonYear;
	}
	public void setProducitonYear(ProducitonYear producitonYear) {
		this.producitonYear = producitonYear;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public AgeCategory getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}
	
	
}
