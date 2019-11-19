package net.yhkj.mvvmdemo.ui.indicator;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.entity.IndicatorBean;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.indicator.IndicatorViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/13
 * 描述：
 */
public class IndicatorViewModel extends BaseViewModel {
    public IndicatorViewModel(@NonNull Application application) {
        super(application);
    }

    public IndicatorViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public ObservableList<IndicatorItemViewModel> observableList = new ObservableArrayList<>();
    public ItemBinding<IndicatorItemViewModel> itemBinding = ItemBinding.of(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_indicator);

    public void initData() {
        observableList.add(new IndicatorItemViewModel(this, new IndicatorBean(String.valueOf(1))));
        observableList.add(new IndicatorItemViewModel(this, new IndicatorBean("2")));
        observableList.add(new IndicatorItemViewModel(this, new IndicatorBean("3")));
    }
}
