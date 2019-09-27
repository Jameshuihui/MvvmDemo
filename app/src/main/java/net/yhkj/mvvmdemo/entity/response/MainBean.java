package net.yhkj.mvvmdemo.entity.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 文件名：net.yhkj.mvvmdemo.entity.response.MainBean
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/26
 * 描述：
 */
public class MainBean implements Parcelable {
    public String title;
    public int tag;

    public MainBean() {
    }

    public MainBean(String title, int tag) {
        this.title = title;
        this.tag = tag;
    }

    protected MainBean(Parcel in) {
        title = in.readString();
        tag = in.readInt();
    }

    public static final Creator<MainBean> CREATOR = new Creator<MainBean>() {
        @Override
        public MainBean createFromParcel(Parcel in) {
            return new MainBean(in);
        }

        @Override
        public MainBean[] newArray(int size) {
            return new MainBean[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tag);
        dest.writeString(title);
    }
}
