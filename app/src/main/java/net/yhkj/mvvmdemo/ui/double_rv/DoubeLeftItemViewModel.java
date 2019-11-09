package net.yhkj.mvvmdemo.ui.double_rv;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import me.goldze.mvvmhabit.base.ItemViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.double_rv.DoubeLeftItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/15
 * 描述：
 */
public class DoubeLeftItemViewModel extends ItemViewModel<DoubleRvViewModel> {
    public String text;
    public ObservableField<Boolean> obIsSelected=new ObservableField<>(false);
    public DoubeLeftItemViewModel(@NonNull DoubleRvViewModel viewModel,String text,boolean isSelected) {
        super(viewModel);
        this.text = text;
        obIsSelected.set(isSelected);
    }
}
