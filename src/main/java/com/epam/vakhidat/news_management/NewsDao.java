package com.epam.vakhidat.news_management;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Slf4j
public class NewsDao {
    private SessionFactory sessionFactory;

    public List<News> getAllNews() {
        log.debug("Retrieving all news");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM  News");
        log.debug("News were retrieved");
        return  query.list();
    }

    public void removeById(long id) {
        Session session = sessionFactory.getCurrentSession();
        News news = (News) session.get(News.class, id);
        session.delete(news);
        log.debug("News were deleted {}",  news);
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
        log.debug("Editing news success {}", editedNews);
    }

    public void addNews(News news) {
        Session session = sessionFactory.getCurrentSession();
        session.save(news);
        log.debug("Adding news success {}", news);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
