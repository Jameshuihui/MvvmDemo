package net.yhkj.mvvmdemo.ui.link_list;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.entity.LeftDataBean;
import net.yhkj.mvvmdemo.entity.RightDataBean;
import net.yhkj.mvvmdemo.ui.multiple_status.MulitpleStatusViewModel;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.KLog;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.link_list.LinkListViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class LinkListViewModel extends BaseViewModel {
    public UIChangeObservable uc = new UIChangeObservable();

    public boolean isLeftClick = false;

    public class UIChangeObservable {
        public SingleLiveEvent<Integer> onLeftClcikEvent = new SingleLiveEvent();
    }

    public LinkListViewModel(@NonNull Application application) {
        super(application);
    }

    public LinkListViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public ObservableList<LeftItemViewModel> observableListLeft = new ObservableArrayList<>();

    public ObservableList<RightItemViewModel> observableListRight = new ObservableArrayList<>();

    public ItemBinding itemBindingLeft = ItemBinding.of(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_link_left);

    public ItemBinding itemBindingRight = ItemBinding.of(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_link_rgiht);


    public void initLeftData() {
        for (int i = 0; i < 10; i++) {
            observableListLeft.add(new LeftItemViewModel(this, new LeftDataBean(i + 1, "第" + (i + 1) + "类", false)));
        }
        observableListLeft.get(0).itemDatas.get().isSelect = true;

        for (int i = 0; i < observableListLeft.size(); i++) {
            for (int j = 0; j < 20; j++) {
                observableListRight.add(new RightItemViewModel(this, new RightDataBean(observableListLeft.get(i).itemDatas.get().id, "第" + (i + 1) + "类", j + 1)));
            }
        }
    }

    public void changSelectById(int currentId) {
        if (isLeftClick){
            return;
        }
        for (LeftItemViewModel leftItemViewModel : observableListLeft) {
            if (leftItemViewModel.itemDatas.get().id == currentId) {
                leftItemViewModel.obIsSelect.set(true);
            } else {
                leftItemViewModel.obIsSelect.set(false);
            }
        }
    }

    public void selectData(int currentId) {
        isLeftClick = true;
        uc.onLeftClcikEvent.setValue(getFirstById(currentId));
    }

    private int getFirstById(int currentId) {
        for (int i = 0; i < observableListRight.size(); i++) {
            if (observableListRight.get(i).itemDatas.get().parentId == currentId) {
                return i;
            }
        }
        return 0;
    }
}
