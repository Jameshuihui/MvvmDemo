package net.yhkj.mvvmdemo.ui.multiple_status;

import android.app.Application;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.multiple_status.MulitpleStatusViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/30
 * 描述：
 */
public class MulitpleStatusViewModel extends BaseViewModel {

    public UIChangeObservable uc = new UIChangeObservable();
    public class UIChangeObservable {
        public SingleLiveEvent<Boolean> contentEvent = new SingleLiveEvent();

        public SingleLiveEvent<Boolean> netEvent = new SingleLiveEvent();

        public SingleLiveEvent<Boolean> errorEvent = new SingleLiveEvent();

        public SingleLiveEvent<Boolean> emptyEvent = new SingleLiveEvent();

        public SingleLiveEvent<Boolean> loadingEvent = new SingleLiveEvent();
    }
    public MulitpleStatusViewModel(@NonNull Application application) {
        super(application);
    }

    public MulitpleStatusViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public BindingCommand contentCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.contentEvent.setValue(true);
        }
    });

    public BindingCommand netCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.netEvent.setValue(true);
        }
    });


    public BindingCommand errortCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.errorEvent.setValue(true);
        }
    });


    public BindingCommand emptyCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.emptyEvent.setValue(true);
        }
    });


    public BindingCommand loadingCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.loadingEvent.setValue(true);
        }
    });
}
