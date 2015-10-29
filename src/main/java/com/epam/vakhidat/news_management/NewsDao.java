package com.epam.vakhidat.news_management;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class NewsDao {
    private EntityManagerFactory entityManagerFactory;
    @PersistenceContext
    private EntityManager entityManager;

    public List<News> getAllNews() {
        entityManagerFactory = Persistence.createEntityManagerFactory("NewsDao");
        entityManager = entityManagerFactory.createEntityManager();
        javax.persistence.Query query = entityManager.createNativeQuery("SELECT * FROM NEWS");
        return query.getResultList();
    }

   /* public void removeById(long id) {
        Session session = sessionFactory.getCurrentSession();
        News news = (News) session.get(News.class, id);
        session.delete(news);
    }

    public News findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        News news = (News) session.get(News.class, id);
        return news;
    }

    public void edit(News news) {
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
        entityManager.getTransaction().begin();
        entityManager.persist(news);
        entityManager.getTransaction().commit();
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
