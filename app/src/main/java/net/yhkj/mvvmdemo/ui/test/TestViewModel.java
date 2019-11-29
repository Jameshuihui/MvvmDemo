package net.yhkj.mvvmdemo.ui.test;

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
 * 文件名：net.yhkj.mvvmdemo.ui.test.TestViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class TestViewModel extends BaseViewModel {
    public TestViewModel(@NonNull Application application) {
        super(application);
    }

    public TestViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public ObservableList<TestItemViewModel> observableList = new ObservableArrayList<>();

    public ItemBinding<TestItemViewModel> itemBinding = ItemBinding.of(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_test);

    public void initData() {
        for (int i = 0; i < 10; i++) {
            observableList.add(new TestItemViewModel(this, false));
        }
        observableList.get(0).obSelect.set(true);
    }
}
