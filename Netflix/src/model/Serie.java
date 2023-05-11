package model;

public class Serie
{
    public String major_genre;
    public String title;
    public String subgenre;
    public int premiere_year;
    public String episodes;
    public String status;
    public int imdb_rating;

    public String getMajor_genre() {
        return major_genre;
    }

    public void setMajor_genre(String major_genre) {
        this.major_genre = major_genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    public int getPremiere_year() {
        return premiere_year;
    }

    public void setPremiere_year(int premiere_year) {
        this.premiere_year = premiere_year;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(int imdb_rating) {
        this.imdb_rating = imdb_rating;
    }
}
