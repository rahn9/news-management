package com.epam.vakhidat.news_management.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class NewsForm extends ActionForm {
    private UUID uuid;
    private long id;
    private String title;
    private String creationDate;
    private String brief;
    private String content;
    private boolean deleted;

    public NewsForm() {
        this.setUuid(UUID.randomUUID());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        id = 0;
        title = null;
        creationDate = null;
        brief = null;
        content = null;
        deleted = false;
    }
}
