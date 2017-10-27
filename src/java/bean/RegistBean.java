package bean;

import dao.*;
import entity.*;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class RegistBean implements Serializable {
 
    private Integer categoryId;
    private String title;
    private String memo;
    private Integer point;
    private List<MCategory> categoryList;

    @EJB
    private TBookDao tBookDao;
    @EJB
    private MCategoryDao mCategoryDao;

    @PostConstruct
    public void init() {
        categoryList = mCategoryDao.findAll();
    }
    
    public String regist() {
        TBook book = new TBook();
        book.setCategoryId(categoryId);
        book.setTitle(title);
        book.setMemo(memo);
        book.setPoint(point);
        tBookDao.insert(book);
        return "index.xhtml?faces-redirect=true";
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }


    public List<MCategory> getCategoryList() {
        return categoryList;
    }
}
