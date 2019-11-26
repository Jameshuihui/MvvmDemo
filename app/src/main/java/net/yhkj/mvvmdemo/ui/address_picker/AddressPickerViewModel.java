package net.yhkj.mvvmdemo.ui.address_picker;

import android.app.Application;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.address_picker.AddressPickerViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/19
 * 描述：
 */
public class AddressPickerViewModel extends BaseViewModel {
    public AddressPickerViewModel(@NonNull Application application) {
        super(application);
    }

    public AddressPickerViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public SingleLiveEvent<Boolean> showAddressDialogEvent = new SingleLiveEvent<>();

    public BindingCommand onAddressClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            showAddressDialogEvent.setValue(true);
        }
    });
}
