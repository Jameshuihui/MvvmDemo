package net.yhkj.mvvmdemo.ui.addcart;

import android.app.Application;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.addcart.AddCartViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/1
 * 描述：
 */
public class AddCartViewModel extends BaseViewModel {
    public SingleLiveEvent<Boolean> addCartEvent = new SingleLiveEvent<>();

    public AddCartViewModel(@NonNull Application application) {
        super(application);
    }

    public AddCartViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public BindingCommand onAddCartCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showLongSafe("加入购物车");
            addCartEvent.setValue(true);
        }
    });
}
