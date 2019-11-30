package net.yhkj.mvvmdemo.ui.update;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.update.UpdateItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class UpdateItemViewModel extends ItemViewModel<UpdateViewModel> {
    public ObservableField<String> obTitle = new ObservableField<>();
    public int tag;

    public UpdateItemViewModel(@NonNull UpdateViewModel viewModel, String title, int tag) {
        super(viewModel);
        this.tag = tag;
        obTitle.set(title);
    }

    public BindingCommand onItemClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            viewModel.onItemClick(tag);
        }
    });
}
