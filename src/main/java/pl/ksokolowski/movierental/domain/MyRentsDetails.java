package pl.ksokolowski.movierental.domain;

import java.util.Date;

public class MyRentsDetails {

	private String filmTitle;
	private Date dateReturn;
	
	public String getFilmTitle() {
		return filmTitle;
	}
	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}
	public Date getDateReturn() {
		return dateReturn;
	}
	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}
	
	
}
