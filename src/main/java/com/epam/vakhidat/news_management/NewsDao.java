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
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public List<News> getAllNews() {
        entityManagerFactory = Persistence.createEntityManagerFactory("NewsDao");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM NEWS");
        return query.getResultList();
    }

   /* public void removeById(long id) {
        Session session = sessionFactory.getCurrentSession();
        News news = (News) session.get(News.class, id);
        session.delete(news);
    }*/

    public News findById(long id) {
        entityManagerFactory = Persistence.createEntityManagerFactory("NewsDao");
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(News.class, id);
    }

   /* public void edit(News news) {
        Session session = sessionFactory.getCurrentSession();
        News editedNews = (News) session.get(News.class, news.getId());

        editedNews.setTitle(news.getTitle());
        editedNews.setBrief(news.getBrief());
        editedNews.setContent(news.getContent());
        editedNews.setCreationDate(news.getCreationDate());

        session.save(editedNews);
    }*/

    public void addNews(News news) {
        entityManagerFactory = Persistence.createEntityManagerFactory("NewsDao");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(news);
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
