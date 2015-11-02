package com.epam.vakhidat.news_management;


import org.joda.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "NEWS")
public class News {
    @Id
    @GeneratedValue()
    private long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;
    @Column(name = "BRIEF")
    private String brief;
    @Column(name = "CONTENT")
    private String content;
    private boolean deleted;

    public News() {
    }

    public News(String title, LocalDate creationDate, String brief, String content) {
        this.title = title;
        this.creationDate = creationDate;
        this.brief = brief;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
