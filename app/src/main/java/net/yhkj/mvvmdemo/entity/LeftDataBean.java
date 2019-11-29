package net.yhkj.mvvmdemo.entity;

public class LeftDataBean {
    public int id;
    public String title;
    public boolean isSelect;

    public LeftDataBean(int id, String title, boolean isSelect) {
        this.id = id;
        this.title = title;
        this.isSelect = isSelect;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}