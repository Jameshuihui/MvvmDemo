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
import net.yhkj.mvvmdemo.entity.CityCodeBean;
import net.yhkj.mvvmdemo.entity.RxBean;
import net.yhkj.mvvmdemo.entity.response.MainBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.bus.RxBus;
import me.goldze.mvvmhabit.bus.RxSubscriptions;
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
    //订阅者
    private Disposable mSubscription;

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
        observableList.add(new MainItemViewModel(this, new MainBean("多布局", 2)));
        observableList.add(new MainItemViewModel(this, new MainBean("图片选择", 3)));
        observableList.add(new MainItemViewModel(this, new MainBean("双表联动", 4)));
        observableList.add(new MainItemViewModel(this, new MainBean("商品详情", 5)));
        observableList.add(new MainItemViewModel(this, new MainBean("状态视图", 6)));
        observableList.add(new MainItemViewModel(this, new MainBean("价格", 7)));
        observableList.add(new MainItemViewModel(this, new MainBean("RxBus", 8)));
        observableList.add(new MainItemViewModel(this, new MainBean("购物车", 9)));
        observableList.add(new MainItemViewModel(this, new MainBean("待定", 0)));
    }

//    public void calCityCodeTree(){
//        List<CityCodeBean> cityCodeDatas = new ArrayList<>();
//        for (int i = 0; i < 3000; i++) {
//            cityCodeDatas.add(new CityCodeBean("110000","010",null,2));
//        }
//
//        for (CityCodeBean cityCodeData : cityCodeDatas) {
//            if (cityCodeData.getAdCode().substring(2,6).equals("0000")){
//                cityCodeData.setRank(1);
//                cityCodeData.setParentId("100000");
//            }else if (cityCodeData.getAdCode().substring(4,6).equals("00")){
//                cityCodeData.setRank(3);
//                cityCodeData.setParentId(cityCodeData.getAdCode().substring(0,2)+"0000");
//            }else{
//                cityCodeData.setRank(4);
//                cityCodeData.setParentId(cityCodeData.getAdCode().substring(0,4)+"00");
//            }
//        }
//    }

//    //注册RxBus
//    @Override
//    public void registerRxBus() {
//        super.registerRxBus();
//        mSubscription = RxBus.getDefault().toObservable(RxBean.class)
//                .subscribe(new Consumer<RxBean>() {
//                    @Override
//                    public void accept(RxBean bean) throws Exception {
//                        ToastUtils.showLong(bean.getText());
//                    }
//                });
//        //将订阅者加入管理站
//        RxSubscriptions.add(mSubscription);
//    }
//
//    //移除RxBus
//    @Override
//    public void removeRxBus() {
//        super.removeRxBus();
//        //将订阅者从管理站中移除
//        RxSubscriptions.remove(mSubscription);
//    }

}
