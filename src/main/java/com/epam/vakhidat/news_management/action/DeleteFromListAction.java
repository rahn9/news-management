package com.epam.vakhidat.news_management.action;

import com.epam.vakhidat.news_management.dao.NewsDao;
import com.epam.vakhidat.news_management.entity.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteFromListAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
                                 HttpServletRequest request, HttpServletResponse response) {
        NewsDao newsDao = new NewsDao();
        DynaActionForm newsForm = (DynaActionForm) actionForm;
        List<News> newsList = (List<News>) newsForm.get("newsList");
        newsList.stream().filter(News::isDeleted).forEach(newsDao::delete);
        return mapping.findForward("success");
    }
}
