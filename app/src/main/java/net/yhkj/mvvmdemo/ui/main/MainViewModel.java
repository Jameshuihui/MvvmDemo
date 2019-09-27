package net.yhkj.mvvmdemo.ui.main;

import android.Manifest;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.tbruyelle.rxpermissions2.RxPermissions;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.data.respository.LoginRepository;
import net.yhkj.mvvmdemo.entity.response.MainBean;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.main.MainViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/26
 * 描述：
 */
public class MainViewModel extends BaseViewModel<LoginRepository> {
    public SingleLiveEvent<MainItemViewModel> onItemClcikEvent = new SingleLiveEvent<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MainViewModel(@NonNull Application application, LoginRepository model) {
        super(application, model);
    }

    //给RecyclerView添加ObservableList
    public ObservableList<MainItemViewModel> observableList = new ObservableArrayList<>();
    //给RecyclerView添加ItemBinding
    public ItemBinding<MainItemViewModel> itemBinding = ItemBinding.of(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_main);

    public void initData() {
        observableList.add(new MainItemViewModel(this, new MainBean("扫码入库", 1)));
        observableList.add(new MainItemViewModel(this, new MainBean("待定", 0)));
    }

}
