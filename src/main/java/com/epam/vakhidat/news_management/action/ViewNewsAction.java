package com.epam.vakhidat.news_management.action;

import com.epam.vakhidat.news_management.dao.NewsDao;
import com.epam.vakhidat.news_management.entity.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewNewsAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
                                 HttpServletRequest request, HttpServletResponse response) {
        NewsDao newsDao = new NewsDao();
        long id = Long.valueOf(request.getParameter("id"));
        News news = newsDao.find(id);
        getServlet().getServletConfig().getServletContext().setAttribute("news", news);
        return mapping.findForward("success");
    }
}
