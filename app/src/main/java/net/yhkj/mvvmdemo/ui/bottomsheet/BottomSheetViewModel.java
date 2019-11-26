package net.yhkj.mvvmdemo.ui.bottomsheet;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import net.yhkj.mvvmdemo.R;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.tatarka.bindingcollectionadapter2.BR;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.bottomsheet.BottomSheetViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/26
 * 描述：
 */
public class BottomSheetViewModel extends BaseViewModel {
    public BottomSheetViewModel(@NonNull Application application) {
        super(application);
    }

    public BottomSheetViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public ObservableList<BottomSheetItemViewModel> observableList = new ObservableArrayList<>();

    public ItemBinding<BottomSheetItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item_bottom_sheet);

    public void initData() {
        for (int i = 0; i < 20; i++) {
            observableList.add(new BottomSheetItemViewModel(this));
        }
    }
}
