package net.yhkj.mvvmdemo.ui.mulist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.data.respository.LoginRepository;
import net.yhkj.mvvmdemo.entity.LableBean;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.mulist.MuListViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/27
 * 描述：
 */
public class MuListViewModel extends BaseViewModel<LoginRepository> {
    public  final String TYPE_LABLE="TYPE_LABLE";
    public  final String TYPE_FIRST="TYPE_FIRST";
    public  final String TYPE_SECOND="TYPE_SECOND";

    //给RecyclerView添加ObservableList
    public ObservableList<MultiItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<MultiItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<MultiItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, MultiItemViewModel item) {
            //通过item的类型, 动态设置Item加载的布局
            String itemType = (String) item.getItemType();
            if (TYPE_LABLE.equals(itemType)) {
                //设置头布局
                itemBinding.set(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_mu_lable);
            } else if (TYPE_FIRST.equals(itemType)) {
                //设置左布局
                itemBinding.set(BR.viewModel, R.layout.item_first);
            } else if (TYPE_SECOND.equals(itemType)) {
                //设置右布局
                itemBinding.set(BR.viewModel, R.layout.item_second);
            }
        }
    });


    public MuListViewModel(@NonNull Application application) {
        super(application);
    }

    public MuListViewModel(@NonNull Application application, LoginRepository model) {
        super(application, model);
    }

    public void initData(){
        //模拟10个条目，数据源可以来自网络
        for (int i = 0; i < 20; i++) {
            if (i == 0||i==10) {
                MultiItemViewModel item = new MuLabeItemViewModel(this,new LableBean(i==0?"荡气回肠":"君子之约"));
                //条目类型为头布局
                item.multiItemType(TYPE_LABLE);
                observableList.add(item);
            } else {
                if (i <10) {
                    MultiItemViewModel item = new MuFirstItemViewModel(this);
                    //条目类型为左布局
                    item.multiItemType(TYPE_FIRST);
                    observableList.add(item);
                } else {
                    MultiItemViewModel item = new MuSecondItemViewModel(this);
                    //条目类型为右布局
                    item.multiItemType(TYPE_SECOND);
                    observableList.add(item);
                }
            }
        }
    }
}
