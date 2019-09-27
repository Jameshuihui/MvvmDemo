package net.yhkj.mvvmdemo.ui.mulist;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import net.yhkj.mvvmdemo.entity.LableBean;

import me.goldze.mvvmhabit.base.MultiItemViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.mulist.MuLabeItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/27
 * 描述：
 */
public class MuLabeItemViewModel extends MultiItemViewModel<MuListViewModel> {
    public ObservableField<LableBean> obItemData=new ObservableField<>();

    public MuLabeItemViewModel(@NonNull MuListViewModel viewModel,LableBean lableBean) {
        super(viewModel);
        obItemData.set(lableBean);
    }


}
