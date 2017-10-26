package bean;

import dao.*;
import entity.*;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.*;
import javax.inject.Named;

@Named
@RequestScoped
public class IndexBean {
    
    private List<TBook> bookList;

    @EJB
    private TBookDao tBookDao;
    
    @PostConstruct
    public void init() {
        bookList = tBookDao.findAll();
    }

    public String editAction(int id) {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("id", id);
        return "edit.xhtml?faces-redirect=true";
    }
    
    public String getPointMark(int point) {
        String pointMark = null;
        switch (point) {
            case 1:
                pointMark = "☆";
                break;
            case 2:
                pointMark = "☆☆";
                break;
            case 3:
                pointMark = "☆☆☆";
                break;
            case 4:
                pointMark = "☆☆☆☆";
                break;
            case 5:
                pointMark = "☆☆☆☆☆";
                break;
        }
        return pointMark;
    }
    
    public List<TBook> getBookList() {
        return bookList;
    }
}
