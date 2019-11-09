package net.yhkj.mvvmdemo.ui.goods_detials;

import android.app.Application;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.goods_detials.GoodsContentViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/19
 * 描述：
 */
public class GoodsContentViewModel extends BaseViewModel {
    public GoodsContentViewModel(@NonNull Application application) {
        super(application);
    }

    public GoodsContentViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }
}
