package net.yhkj.mvvmdemo.ui.goods_detials;

import android.app.Application;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.goods_detials.GoodsDetidalsViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/19
 * 描述：
 */
public class GoodsDetidalsViewModel extends BaseViewModel {
    public GoodsDetidalsViewModel(@NonNull Application application) {
        super(application);
    }

    public GoodsDetidalsViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }
}
