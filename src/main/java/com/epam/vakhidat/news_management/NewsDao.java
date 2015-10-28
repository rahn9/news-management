package com.epam.vakhidat.news_management;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class NewsDao {

    public List<News> getAllNews() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager entityManager = emf.createEntityManager();
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewsService");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.persist(news);
    }
}
