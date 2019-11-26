package net.yhkj.mvvmdemo.ui.drawiamge;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.drawiamge.DrawImageItemView
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/22
 * 描述：
 */
public class DrawImageItemView extends ItemViewModel<DrawImageViewModel> {
    public DrawImageItemView(@NonNull DrawImageViewModel viewModel) {
        super(viewModel);
    }

    public BindingCommand onDrawCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            viewModel.observableList.remove(DrawImageItemView.this);
        }
    });
}
