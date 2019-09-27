package net.yhkj.mvvmdemo.ui.main;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import net.yhkj.mvvmdemo.entity.response.MainBean;

import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.main.MainItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/26
 * 描述：
 */
public class MainItemViewModel extends ItemViewModel<MainViewModel> {
    public ObservableField<MainBean> obMainData = new ObservableField<>();

    public MainItemViewModel(@NonNull MainViewModel viewModel, MainBean bean) {
        super(viewModel);
        obMainData.set(bean);
    }
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            viewModel.onItemClcikEvent.setValue(MainItemViewModel.this);
        }
    });

}
