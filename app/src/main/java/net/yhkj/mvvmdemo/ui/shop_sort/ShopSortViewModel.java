package net.yhkj.mvvmdemo.ui.shop_sort;

import android.app.Application;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.shop_sort.ShopSortViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/20
 * 描述：
 */
public class ShopSortViewModel extends BaseViewModel {
    public ShopSortViewModel(@NonNull Application application) {
        super(application);
    }

    public ShopSortViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }
}
