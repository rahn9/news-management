package com.epam.vakhidat.news_management.dao;

import com.epam.vakhidat.news_management.entities.News;

import javax.persistence.*;
import java.util.List;

public class NewsDao implements Dao<News> {
    @PersistenceContext
    private EntityManager em;
    private EntityManagerFactory emf;

    public NewsDao() {
        emf = Persistence.createEntityManagerFactory("NewsDao");
        em = emf.createEntityManager();
    }

    @Override
    public List<News> getAll() {
        TypedQuery<News> typedQuery = em.createQuery("SELECT e FROM News e", News.class);
        return typedQuery.getResultList();
    }

    @Override
    public void insert(News news) {
        em.persist(news);
    }

    @Override
    public void update(News news) {
        News editedNews = find(news);
        editedNews.setTitle(news.getTitle());
        editedNews.setCreationDate(news.getCreationDate());
        editedNews.setBrief(news.getBrief());
        editedNews.setContent(news.getContent());
        editedNews.setCreationDate(news.getCreationDate());

        em.merge(editedNews);
    }

    @Override
    public void delete(News news) {
        news.setDeleted(true);
        Query query = em.createNativeQuery("UPDATE NEWS SET DELETED = 1 WHERE ID = " + news.getId());
        query.executeUpdate();
    }

    @Override
    public News find(News news) {
        return em.find(News.class, news.getId());
    }

    public News find(long id) {
        return em.find(News.class, id);
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
