package net.yhkj.mvvmdemo.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.gallery.GalleryViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/9
 * 描述：
 */
public class GalleryViewModel extends BaseViewModel {
    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }

    public GalleryViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }
}
