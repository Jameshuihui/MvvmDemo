package net.yhkj.mvvmdemo.ui.test;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;

import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.test.TestItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class TestItemViewModel extends ItemViewModel<TestViewModel> {
    public ObservableBoolean obSelect = new ObservableBoolean();
    public TestItemViewModel(@NonNull TestViewModel viewModel,boolean isSelect) {
        super(viewModel);
        obSelect.set(isSelect);
    }

    public BindingCommand onItemClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            for (TestItemViewModel testItemViewModel : viewModel.observableList) {
                testItemViewModel.obSelect.set(false);
            }
            obSelect.set(true);
        }
    });
}
