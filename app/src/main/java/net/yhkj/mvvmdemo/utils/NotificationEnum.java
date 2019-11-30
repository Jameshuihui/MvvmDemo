package net.yhkj.mvvmdemo.utils;

/**
 * 文件名：net.yhkj.notificationdemo.NotificationEnum
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/28
 * 描述：
 */
public enum NotificationEnum {
    PROGRESS(0, "下载进度", "progress", "下载通知"),
    OREDER(1, "订单消息", "order", "订单通知"),
    ACCOUNT(2, "账户消息", "account", "账户通知"),
    SYSTEM(3, "系统消息", "system", "系统消息"),
    ;

    private int id;
    private String tag;
    private String channelId;
    private String channelName;

    NotificationEnum(int id, String tag, String channelId, String channelName) {
        this.id = id;
        this.tag = tag;
        this.channelId = channelId;
        this.channelName = channelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
