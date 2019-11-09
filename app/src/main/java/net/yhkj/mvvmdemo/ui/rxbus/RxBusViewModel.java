package net.yhkj.mvvmdemo.ui.rxbus;

import android.app.Application;

import androidx.annotation.NonNull;

import net.yhkj.mvvmdemo.entity.RxBean;
import net.yhkj.mvvmdemo.ui.money.MoneyFragment;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.bus.RxBus;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.rxbus.RxBusViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/31
 * 描述：
 */
public class RxBusViewModel extends BaseViewModel {
    public RxBusViewModel(@NonNull Application application) {
        super(application);
    }

    public RxBusViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public BindingCommand onSendCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startContainerActivity(MoneyFragment.class.getCanonicalName());
            RxBus.getDefault().postSticky(new RxBean("发送一下"));
            Messenger.getDefault().send(new RxBean("发送一下"),"DATA");
        }
    });
}
