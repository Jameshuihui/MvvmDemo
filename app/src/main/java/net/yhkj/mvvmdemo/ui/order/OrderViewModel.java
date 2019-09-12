package net.yhkj.mvvmdemo.ui.order;

import android.app.Application;

import androidx.annotation.NonNull;

import net.yhkj.mvvmdemo.data.respository.LoginRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.order.OrderViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/12
 * 描述：
 */
public class OrderViewModel extends BaseViewModel<LoginRepository> {
    public OrderViewModel(@NonNull Application application, LoginRepository model) {
        super(application, model);
    }

}
