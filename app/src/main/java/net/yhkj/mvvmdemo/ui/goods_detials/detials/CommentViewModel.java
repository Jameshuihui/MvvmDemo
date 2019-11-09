package net.yhkj.mvvmdemo.ui.goods_detials.detials;

import android.app.Application;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.goods_detials.detials.CommentViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/19
 * 描述：
 */
public class CommentViewModel extends BaseViewModel {
    public CommentViewModel(@NonNull Application application) {
        super(application);
    }

    public CommentViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }
}
