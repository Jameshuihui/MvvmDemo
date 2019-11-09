package net.yhkj.mvvmdemo.ui.money;

import android.app.Application;

import androidx.annotation.NonNull;

import net.yhkj.mvvmdemo.entity.RxBean;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.bus.RxBus;
import me.goldze.mvvmhabit.bus.RxSubscriptions;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.money.MoneyViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/30
 * 描述：
 */
public class MoneyViewModel extends BaseViewModel {
    //订阅者
    private Disposable mSubscription;

    public MoneyViewModel(@NonNull Application application) {
        super(application);
        initMessger();
    }

    public MoneyViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
        initMessger();
    }

    private void initMessger() {
        Messenger.getDefault().register(this, "DATA", RxBean.class, new BindingConsumer<RxBean>() {
            @Override
            public void call(RxBean s) {
                ToastUtils.showLong(s.getText());
            }
        });
    }


    //注册RxBus
    @Override
    public void registerRxBus() {
        super.registerRxBus();
        mSubscription = RxBus.getDefault().toObservable(RxBean.class)
                .subscribe(new Consumer<RxBean>() {
                    @Override
                    public void accept(RxBean bean) throws Exception {

                    }
                });
        //将订阅者加入管理站
        RxSubscriptions.add(mSubscription);
    }

    //移除RxBus
    @Override
    public void removeRxBus() {
        super.removeRxBus();
        //将订阅者从管理站中移除
        RxSubscriptions.remove(mSubscription);
    }
}
