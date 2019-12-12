package net.yhkj.mvvmdemo.ui.shopcart;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.shopcart.ShopCartViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/12/5
 * 描述：
 */
public class ShopCartViewModel extends BaseViewModel {

    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //下拉刷新完成
        public SingleLiveEvent<Boolean> finishRefreshing = new SingleLiveEvent<>();
        //上拉加载完成
        public SingleLiveEvent<Boolean> finishLoadmore = new SingleLiveEvent<>();
    }

    public ShopCartViewModel(@NonNull Application application) {
        super(application);
    }

    public ShopCartViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    //给RecyclerView添加ObservableList
    public ObservableList<ShopCartItemViewModel> observableList = new ObservableArrayList<>();
    //给RecyclerView添加ItemBinding
    public ItemBinding<ShopCartItemViewModel> itemBinding = ItemBinding.of(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_goods);
    //下拉刷新
    public BindingCommand onRefreshCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showLongSafe("开始刷新");
            refreshData();
        }
    });

    private void refreshData() {
        observableList.clear();
        for (int i = 0; i < 5; i++) {
            observableList.add(new ShopCartItemViewModel(this));
        }
        uc.finishRefreshing.setValue(true);
    }

    //上拉加载
    public BindingCommand onLoadMoreCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            loadMoreData();
        }
    });

    private void loadMoreData() {
        for (int i = 0; i < 5; i++) {
            observableList.add(new ShopCartItemViewModel(this));
        }
        uc.finishLoadmore.setValue(true);
    }

    protected void requestData(){
        for (int i = 0; i <5; i++) {
            observableList.add(new ShopCartItemViewModel(this));
        }
    }
}
