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
public class EditBean implements Serializable {
    
    private TBook book;
    private List<MCategory> categoryList;

    @EJB
    private TBookDao tBookDao;
    @EJB
    private MCategoryDao mCategoryDao;

    @PostConstruct
    public void init() {
        categoryList = mCategoryDao.findAll();
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        if (flash.size() > 0) {
            book = tBookDao.findById((Integer)flash.get("id"));
        }
    }
    
    public String regist() {
        tBookDao.update(book);
        return "index.xhtml?faces-redirect=true";
    }

    public TBook getBook() {
        return book;
    }

    public void setBook(TBook book) {
        this.book = book;
    }
    
    public List<MCategory> getCategoryList() {
        return categoryList;
    }
}
