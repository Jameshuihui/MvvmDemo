package net.yhkj.mvvmdemo.entity;

/**
 * 文件名：net.yhkj.mvvmdemo.entity.RightDataBean
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class RightDataBean {
    public int parentId;
    public String title;
    public int pos;

    public RightDataBean(int parentId, String title,int pos) {
        this.parentId = parentId;
        this.title = title;
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
