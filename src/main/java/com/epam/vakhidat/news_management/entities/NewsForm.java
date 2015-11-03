package com.epam.vakhidat.news_management.entities;

import org.apache.struts.action.ActionForm;
import org.joda.time.LocalDate;

import java.util.UUID;

public class NewsForm extends ActionForm {
    private UUID uuid;
    private String title;
    private LocalDate creationDate;
    private String brief;
    private String content;

    public NewsForm() {
        this.setUuid(UUID.randomUUID());
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

    public void setCreationDate(String creationDate) {
        this.creationDate = LocalDate.parse(creationDate);
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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsForm newsForm = (NewsForm) o;

        return uuid.equals(newsForm.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
