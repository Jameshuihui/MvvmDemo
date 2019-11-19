package net.yhkj.mvvmdemo.ui.indicator;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import net.yhkj.mvvmdemo.entity.IndicatorBean;

import me.goldze.mvvmhabit.base.ItemViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.indicator.IndicatorItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/13
 * 描述：
 */
public class IndicatorItemViewModel extends ItemViewModel<IndicatorViewModel> {
    public ObservableBoolean obShowHeadLine = new ObservableBoolean(true);
    public ObservableBoolean obShowFootLine = new ObservableBoolean(true);
    public ObservableBoolean obIsComplete = new ObservableBoolean(false);
    public ObservableField<IndicatorBean> itemDatas = new ObservableField<>();
    public int pos = 0;

    public IndicatorItemViewModel(@NonNull IndicatorViewModel viewModel, IndicatorBean bean) {
        super(viewModel);
        itemDatas.set(bean);
        pos = viewModel.observableList.indexOf(IndicatorItemViewModel.this);
        initData();
    }

    private void initData() {
        if (pos == 0) {
            obShowHeadLine.set(false);
        } else if (pos == viewModel.observableList.size() - 1) {
            obShowFootLine.set(false);
        }
    }
}
