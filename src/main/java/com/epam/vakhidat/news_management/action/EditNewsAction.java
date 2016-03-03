package com.epam.vakhidat.news_management.action;

import com.epam.vakhidat.news_management.dao.NewsDao;
import com.epam.vakhidat.news_management.entity.News;
import com.epam.vakhidat.news_management.form.NewsForm;
import com.epam.vakhidat.news_management.util.DateConverter;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

public class EditNewsAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
                                 HttpServletRequest request, HttpServletResponse response) throws ParseException {
        NewsDao newsDao = new NewsDao();
        NewsForm newsForm = (NewsForm) actionForm;
        News news = new News();
        long id = Long.valueOf(request.getParameter("id"));
        news.setId(id);
        news.setTitle(newsForm.getTitle());
        news.setCreationDate(DateConverter.dateFromString(newsForm.getCreationDate()));
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        newsDao.update(news);
        return mapping.findForward("success");
    }
}
