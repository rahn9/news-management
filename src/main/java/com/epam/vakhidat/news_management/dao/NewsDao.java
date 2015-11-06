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
    }


    @Override
    public List<News> getAll() {
        em = emf.createEntityManager();
        TypedQuery<News> typedQuery = em.createQuery("SELECT e FROM News e", News.class);
        try {
            return typedQuery.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void insert(News news) {
        em = emf.createEntityManager();
        em.persist(news);
        em.close();
    }

    @Override
    public void update(News news) {
        em = emf.createEntityManager();
        News editedNews = find(news);
        editedNews.setTitle(news.getTitle());
        editedNews.setCreationDate(news.getCreationDate());
        editedNews.setBrief(news.getBrief());
        editedNews.setContent(news.getContent());
        editedNews.setCreationDate(news.getCreationDate());

        em.merge(editedNews);
        em.close();
    }

    @Override
    public void delete(News news) {
        em = emf.createEntityManager();
        news.setDeleted(true);
        Query query = em.createNativeQuery("UPDATE NEWS SET DELETED = 1 WHERE ID = " + news.getId());
        query.executeUpdate();
        em.close();
    }

    @Override
    public News find(News news) {
        em = emf.createEntityManager();
        try {
            return em.find(News.class, news.getId());
        } finally {
            em.close();
        }
    }

    public News find(long id) {
        em = emf.createEntityManager();
        try {
            return em.find(News.class, id);
        } finally {
            em.close();
        }
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
