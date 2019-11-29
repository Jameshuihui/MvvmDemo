package net.yhkj.mvvmdemo.ui.link_list;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;

import net.yhkj.mvvmdemo.entity.LeftDataBean;

import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.link_list.LeftItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class LeftItemViewModel extends ItemViewModel<LinkListViewModel> {
    public ObservableBoolean obIsSelect = new ObservableBoolean();
    public ObservableField<LeftDataBean> itemDatas = new ObservableField<>();

    public LeftItemViewModel(@NonNull LinkListViewModel viewModel, LeftDataBean bean) {
        super(viewModel);
        itemDatas.set(bean);
        obIsSelect.set(bean.isSelect);
    }

    public BindingCommand onItemClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            for (LeftItemViewModel leftItemViewModel : viewModel.observableListLeft) {
                leftItemViewModel.obIsSelect.set(false);
            }
            obIsSelect.set(true);
            viewModel.selectData(itemDatas.get().id);
        }
    });
}
