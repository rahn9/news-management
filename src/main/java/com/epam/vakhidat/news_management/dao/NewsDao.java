package com.epam.vakhidat.news_management.dao;

import com.epam.vakhidat.news_management.entity.News;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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
        List<News> newsList = typedQuery.getResultList().stream().filter(news -> !news.isDeleted()).collect(Collectors.toList());
        try {
            return newsList;
        } finally {
            em.close();
        }
    }

    @Override
    public void insert(News news) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(news);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(News news) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(news);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(News news) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(news);
        em.getTransaction().commit();
        em.close();
    }

    @Override
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
