package net.yhkj.mvvmdemo.ui.blurview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.view.ToolbarViewmodel;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.blurview.BlurViewViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/12/12
 * 描述：
 */
public class BlurViewViewModel extends ToolbarViewmodel {

    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //下拉刷新完成
        public SingleLiveEvent<Boolean> finishRefreshing = new SingleLiveEvent<>();
        //上拉加载完成
        public SingleLiveEvent<Boolean> finishLoadmore = new SingleLiveEvent<>();

        public SingleLiveEvent<Boolean> noMoreData = new SingleLiveEvent<>();

    }

    public BlurViewViewModel(@NonNull Application application) {
        super(application);
    }

    public BlurViewViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    //给RecyclerView添加ObservableList
    public ObservableList<BlurViewItemViewModel> observableList = new ObservableArrayList<>();
    //给RecyclerView添加ItemBinding
    public ItemBinding<BlurViewItemViewModel> itemBinding = ItemBinding.of(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_blurview);

    //下拉刷新
    public BindingCommand onRefreshCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            refreshDataReq();
        }
    });

    private void refreshDataReq() {
        observableList.clear();
        for (int i = 0; i < 10; i++) {
            observableList.add(new BlurViewItemViewModel(this));
        }
        uc.finishRefreshing.setValue(true);
    }

    //上拉加载
    public BindingCommand onLoadMoreCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            loadMoreDataReq();
        }
    });

    private void loadMoreDataReq() {
        for (int i = 0; i < 10; i++) {
            observableList.add(new BlurViewItemViewModel(this));
        }
        uc.finishLoadmore.setValue(true);
    }

    public void requestReq() {
        for (int i = 0; i < 10; i++) {
            observableList.add(new BlurViewItemViewModel(this));
        }
    }
}
