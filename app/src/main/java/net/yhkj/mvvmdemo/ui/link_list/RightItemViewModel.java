package net.yhkj.mvvmdemo.ui.link_list;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import net.yhkj.mvvmdemo.entity.RightDataBean;

import me.goldze.mvvmhabit.base.ItemViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.link_list.RightItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class RightItemViewModel extends ItemViewModel<LinkListViewModel> {
    public ObservableField<RightDataBean> itemDatas = new ObservableField<>();

    public RightItemViewModel(@NonNull LinkListViewModel viewModel, RightDataBean bean) {
        super(viewModel);
        itemDatas.set(bean);
    }

}
