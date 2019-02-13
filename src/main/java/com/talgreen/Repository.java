package com.talgreen;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Repository {
    @Id
    private int id;
    private String title;
    private String description;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    private URL url;
    //private List<String> tags;
    private LocalDateTime lastUpdate;
    private String language;
    private int stars;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<String> getTags() {
//        return tags;
//    }

//    public void setTags(List<String> tags) {
//        this.tags = tags;
//    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url=" + url +
               // ", tags=" + tags +
                ", lastUpdate=" + lastUpdate +
                ", language='" + language + '\'' +
                ", stars=" + stars +
                '}';
    }
}
