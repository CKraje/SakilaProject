package it.objectmethod.sakila.domain;

public class Film {
private String filmId;
public String getFilmId() {
	return filmId;
}
public void setFilmId(String filmId) {
	this.filmId = filmId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getReleaseYear() {
	return releaseYear;
}
public void setReleaseYear(int releaseYear) {
	this.releaseYear = releaseYear;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
private String title;
private int releaseYear;
private String description;


}
