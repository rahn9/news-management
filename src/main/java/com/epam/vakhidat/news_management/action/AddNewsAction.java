package com.epam.vakhidat.news_management.action;

import com.epam.vakhidat.news_management.dao.NewsDao;
import com.epam.vakhidat.news_management.entities.News;
import com.epam.vakhidat.news_management.entities.NewsForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddNewsAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
                                 HttpServletRequest request, HttpServletResponse response) {
        NewsForm newsForm = (NewsForm) actionForm;
        NewsDao newsDao = new NewsDao();
        News news = new News();
        news.setTitle(newsForm.getTitle());
        String[] dates = newsForm.getCreationDate().split("-");
        int day = Integer.valueOf(dates[0]);
        int month = Integer.valueOf(dates[1]);
        int year = Integer.valueOf(dates[2]);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        news.setCreationDate(calendar.getTime());
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        newsDao.insert(news);
        return mapping.findForward("success");
    }
}
