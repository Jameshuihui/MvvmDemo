package net.yhkj.mvvmdemo.ui.mulist;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import net.yhkj.mvvmdemo.entity.MuFirstBean;

import me.goldze.mvvmhabit.base.MultiItemViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.mulist.MuFirstItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/27
 * 描述：
 */
public class MuFirstItemViewModel extends MultiItemViewModel<MuListViewModel> {
    public ObservableField<MuFirstBean> obItemData = new ObservableField<>(new MuFirstBean());
    public MuFirstItemViewModel(@NonNull MuListViewModel viewModel) {
        super(viewModel);
    }

}
