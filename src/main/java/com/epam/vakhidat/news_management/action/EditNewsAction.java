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
import java.time.LocalDate;

public class EditNewsAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
                                 HttpServletRequest request, HttpServletResponse response) {
        NewsDao newsDao = new NewsDao();
        long id = Long.valueOf(request.getParameter("id"));
        NewsForm newsForm = (NewsForm) actionForm;
        News news = newsDao.find(id);
        news.setId(id);
        news.setTitle(newsForm.getTitle());
//        news.setCreationDate(LocalDate.parse(newsForm.getCreationDate()));
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        newsDao.update(news);
        return mapping.findForward("success");
    }
}
