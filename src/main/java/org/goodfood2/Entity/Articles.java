package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Articles
 */
@Entity
public class Articles extends PanacheEntity{
    public String refArticle;
    public String des;
    public String url_img;
    public String tycode;
    public String grp_0001;
    public String grp_0002;
    public String grp_0003;
    @ManyToOne
    @JoinColumn(name="refArticle",referencedColumnName ="refArticleDetail",insertable=false, updatable=false)
    public Articles_Detail article_Detail;
    
    public String getRefArticle() {
        return refArticle;
    }
    public void setRefArticle(String refArticle) {
        this.refArticle = refArticle;
    }
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public String getUrl_img() {
        return url_img;
    }
    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
    public String getTycode() {
        return tycode;
    }
    public void setTycode(String tycode) {
        this.tycode = tycode;
    }
    public String getGrp_0001() {
        return grp_0001;
    }
    public void setGrp_0001(String grp_0001) {
        this.grp_0001 = grp_0001;
    }
    public String getGrp_0002() {
        return grp_0002;
    }
    public void setGrp_0002(String grp_0002) {
        this.grp_0002 = grp_0002;
    }
    public String getGrp_0003() {
        return grp_0003;
    }
    public void setGrp_0003(String grp_0003) {
        this.grp_0003 = grp_0003;
    }
    
    
}