package net.yhkj.mvvmdemo.entity;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 文件名：net.yhkj.onlywine.entity.ToolbarBean
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/24
 * 描述：
 */
public class ToolbarBean implements Parcelable {
    public Drawable rightIconSrc;
    public String title;
    public String rightText;
    public Drawable leftIconSrc;

    public ToolbarBean() {
    }

    protected ToolbarBean(Parcel in) {
        title = in.readString();
        rightText = in.readString();
    }

    public static final Creator<ToolbarBean> CREATOR = new Creator<ToolbarBean>() {
        @Override
        public ToolbarBean createFromParcel(Parcel in) {
            return new ToolbarBean(in);
        }

        @Override
        public ToolbarBean[] newArray(int size) {
            return new ToolbarBean[size];
        }
    };

    public Drawable getRightIconSrc() {
        return rightIconSrc;
    }

    public void setRightIconSrc(Drawable rightIconSrc) {
        this.rightIconSrc = rightIconSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRightText() {
        return rightText;
    }

    public void setRightText(String rightText) {
        this.rightText = rightText;
    }

    public Drawable getLeftIconSrc() {
        return leftIconSrc;
    }

    public void setLeftIconSrc(Drawable leftIconSrc) {
        this.leftIconSrc = leftIconSrc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeValue(rightIconSrc);
        parcel.writeValue(leftIconSrc);
        parcel.writeString(rightText);
    }
}
