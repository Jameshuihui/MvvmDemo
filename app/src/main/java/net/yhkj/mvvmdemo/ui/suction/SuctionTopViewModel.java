package net.yhkj.mvvmdemo.ui.suction;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.suction.SuctionTopViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/26
 * 描述：
 */
public class SuctionTopViewModel extends BaseViewModel {
    public final int MultiRecycleTypeDate = 1;
    public final int MultiRecycleTypeBill = 2;


    public SuctionTopViewModel(@NonNull Application application) {
        super(application);
    }

    public SuctionTopViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    //给RecyclerView添加ObservableList
    public ObservableList<MultiItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<MultiItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<MultiItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, MultiItemViewModel item) {
            //通过item的类型, 动态设置Item加载的布局
            int itemType = (Integer) item.getItemType();
            if (MultiRecycleTypeDate == itemType) {
                //设置头布局
                itemBinding.set(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_suction_date);
            } else if (MultiRecycleTypeBill == itemType) {
                //设置左布局
                itemBinding.set(BR.viewModel, R.layout.item_suction_bill);
            }
        }
    });

    public void initData() {
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                MultiItemViewModel item =new SuctionTopDateItemViewModel(this);
                item.multiItemType(MultiRecycleTypeDate);
                observableList.add(item);
            } else {
                MultiItemViewModel item =new SuctionTopBillItemViewModel(this);
                item.multiItemType(MultiRecycleTypeBill);
                observableList.add(item);
            }
        }
    }
}
