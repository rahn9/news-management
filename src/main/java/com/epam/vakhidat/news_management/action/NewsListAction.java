package com.epam.vakhidat.news_management.action;

import com.epam.vakhidat.news_management.News;
import com.epam.vakhidat.news_management.NewsDao;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class NewsListAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
                                 HttpServletRequest request, HttpServletResponse response) {
        NewsDao newsDao = (NewsDao) getWebApplicationContext().getBean("newsDao");
        List<News> allNews = newsDao.getAllNews();
        request.setAttribute("news-list", allNews);
        return mapping.findForward("success");
    }
}
