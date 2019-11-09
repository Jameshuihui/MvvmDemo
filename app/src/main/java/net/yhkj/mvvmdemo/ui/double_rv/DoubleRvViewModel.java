package net.yhkj.mvvmdemo.ui.double_rv;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.double_rv.DoubleRvViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/15
 * 描述：
 */
public class DoubleRvViewModel extends BaseViewModel {
    public DoubleRvViewModel(@NonNull Application application) {
        super(application);
    }

    public DoubleRvViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    //给RecyclerView添加ObservableList
    public ObservableList<DoubeLeftItemViewModel> observableLeftList = new ObservableArrayList<>();
    //给RecyclerView添加ItemBinding
    public ItemBinding<DoubeLeftItemViewModel> itemLeftBinding = ItemBinding.of(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_double_left);

    //给RecyclerView添加ObservableList
    public ObservableList<DoubleRightItemViewModel> observableRihtList = new ObservableArrayList<>();
    //给RecyclerView添加ItemBinding
    public ItemBinding<DoubleRightItemViewModel> itemRihtBinding = ItemBinding.of(BR.viewModel, R.layout.item_double_right);

    public void initData() {
        for (int i = 0; i < 30; i++) {
            observableLeftList.add(new DoubeLeftItemViewModel(this,"第"+(i+1)+"类",false));
        }
        for (int i = 0; i < 100; i++) {
            observableRihtList.add(new DoubleRightItemViewModel(this));
        }
    }
}
