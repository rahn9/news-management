package com.epam.vakhidat.news_management;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class NewsDao {
    @PersistenceContext
    private EntityManager em;
    private EntityManagerFactory emf;

    public NewsDao() {
        emf = Persistence.createEntityManagerFactory("NewsDao");
        em = emf.createEntityManager();
    }

    public List<News> getAllNews() {
        Query query = em.createNativeQuery("SELECT * FROM NEWS");
        return query.getResultList();
    }

    public void remove(News news) {
        news.setDeleted(true);
        Query query = em.createNativeQuery("UPDATE NEWS SET DELETED = 1 WHERE ID = " + news.getId());
        query.executeUpdate();
    }

    public News findById(long id) {
        return em.find(News.class, id);
    }

    public void edit(News news) {
        News editedNews = findById(news.getId());
        editedNews.setTitle(news.getTitle());
        editedNews.setCreationDate(news.getCreationDate());
        editedNews.setBrief(news.getBrief());
        editedNews.setContent(news.getContent());
        editedNews.setCreationDate(news.getCreationDate());

        em.merge(editedNews);
    }

    public void addNews(News news) {
        em.persist(news);
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
