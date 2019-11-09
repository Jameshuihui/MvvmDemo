package net.yhkj.mvvmdemo.entity;

/**
 * 文件名：net.yhkj.mvvmdemo.entity.RxBean
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/31
 * 描述：
 */
public class RxBean {
    private String text;

    public RxBean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
