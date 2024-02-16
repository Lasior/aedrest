package com.cristianmartin.springaed.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "genres", schema = "pitchfork", catalog = "")
public class GenresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "genreid", nullable = false)
    private int genreid;
    @Basic
    @Column(name = "genre", nullable = true, length = 12)
    private String genre;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reviewid", referencedColumnName = "reviewid", nullable = false)
    private ReviewsEntity reviewsByReviewid;

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenresEntity that = (GenresEntity) o;

        if (genreid != that.genreid) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = genreid;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    public ReviewsEntity getReviewsByReviewid() {
        return reviewsByReviewid;
    }

    public void setReviewsByReviewid(ReviewsEntity reviewsByReviewid) {
        this.reviewsByReviewid = reviewsByReviewid;
    }
}
