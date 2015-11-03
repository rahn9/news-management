package com.epam.vakhidat.news_management.action;

import com.epam.vakhidat.news_management.entities.News;
import com.epam.vakhidat.news_management.dao.NewsDao;
import com.epam.vakhidat.news_management.entities.NewsForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public class EditNewsAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
                                 HttpServletRequest request, HttpServletResponse response) {
        NewsDao newsDao = (NewsDao) getWebApplicationContext().getBean("newsDao");
        long id = Long.valueOf(request.getParameter("id"));
        NewsForm newsForm = (NewsForm) actionForm;
        News news = newsDao.find(id);
        news.setId(id);
        try {
            BeanUtils.copyProperties(news, newsForm);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        newsDao.update(news);
        return mapping.findForward("success");
    }
}
