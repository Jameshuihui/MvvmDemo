package net.yhkj.mvvmdemo.ui.update;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.ui.link_list.LinkListViewModel;
import net.yhkj.mvvmdemo.utils.NotifictionUtils;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.update.UpdateViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class UpdateViewModel extends BaseViewModel {
    private int porgess = 10;
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        public SingleLiveEvent<Boolean> showForceUpdate = new SingleLiveEvent<>();
    }

    public UpdateViewModel(@NonNull Application application) {
        super(application);
    }

    public UpdateViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public ObservableList<UpdateItemViewModel> observableList = new ObservableArrayList<>();

    public ItemBinding<UpdateItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item_update);


    public void initData() {
        observableList.add(new UpdateItemViewModel(this, "强制更新", 1));
        observableList.add(new UpdateItemViewModel(this, "后台更新", 1));
    }

    public void onItemClick(int tag) {
        switch (tag) {
            case 1:
                NotifictionUtils.getInstance().sendProgressNotification(getApplication(), ++porgess);
                break;
            case 2:

                break;
        }
    }
}
