package com.epam.vakhidat.news_management.action;

import com.epam.vakhidat.news_management.dao.NewsDao;
import com.epam.vakhidat.news_management.entities.News;
import com.epam.vakhidat.news_management.entities.NewsForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public class AddNewsAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
                                 HttpServletRequest request, HttpServletResponse response) {
        NewsForm newsForm = (NewsForm) actionForm;
        NewsDao newsDao = new NewsDao();

        News news = new News();
        try {
            BeanUtils.copyProperties(news, newsForm);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return mapping.findForward("failure");
        }
        newsDao.insert(news);
        return mapping.findForward("success");
    }
}
