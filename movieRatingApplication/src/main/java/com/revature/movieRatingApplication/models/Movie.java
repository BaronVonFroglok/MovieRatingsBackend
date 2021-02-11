package com.revature.movieRatingApplication.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String year;

    @Column(unique = true, nullable = false)
    private String imbdId;

    @Column
    private String poster;

    public Movie() {
        super();
    }

    public Movie(String title, String year, String imbdId) {
        this.title = title;
        this.year = year;
        this.imbdId = imbdId;
    }

    public Movie(String title, String year, String imbdId, String poster) {
        this(title, year, imbdId);
        this.poster = poster;
    }

    public Movie(Integer id, String title, String year, String imbdId, String poster) {
        this(title, year, imbdId, poster);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImbdId() {
        return imbdId;
    }

    public void setImbdId(String imbdId) {
        this.imbdId = imbdId;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(year, movie.year) && Objects.equals(imbdId, movie.imbdId) && Objects.equals(poster, movie.poster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, imbdId, poster);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imbdId='" + imbdId + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
