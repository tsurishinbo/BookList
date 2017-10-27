package bean;

import dao.*;
import entity.*;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.*;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexBean implements Serializable {
    
    private List<TBook> bookList;

    @EJB
    private TBookDao tBookDao;
    
    @PostConstruct
    public void init() {
        bookList = tBookDao.findAll();
    }

    public String add() {
        return "regist.xhtml?faces-redirect=true";
    }
    
    public String update(int id) {
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
