package com.epam.vakhidat.news_management.action;

import com.epam.vakhidat.news_management.entities.News;
import com.epam.vakhidat.news_management.dao.NewsDao;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteNewsAction extends ActionSupport{
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
                                 HttpServletRequest request, HttpServletResponse response) {
        NewsDao newsDao = (NewsDao) getWebApplicationContext().getBean("newsDao");
        long id = Long.valueOf(request.getParameter("id"));
        News news = newsDao.find(id);
        newsDao.delete(news);
        return mapping.findForward("success");
    }
}
