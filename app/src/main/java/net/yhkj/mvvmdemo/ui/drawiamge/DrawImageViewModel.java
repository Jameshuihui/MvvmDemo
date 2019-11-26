package net.yhkj.mvvmdemo.ui.drawiamge;

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
 * 文件名：net.yhkj.mvvmdemo.ui.drawiamge.DrawImageViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/22
 * 描述：
 */
public class DrawImageViewModel extends BaseViewModel {
    public DrawImageViewModel(@NonNull Application application) {
        super(application);
    }

    public DrawImageViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }

    public ObservableList<DrawImageItemView> observableList = new ObservableArrayList<>();

    public ItemBinding<DrawImageItemView> itemBinding= ItemBinding.of(net.yhkj.mvvmdemo.BR.viewModel, R.layout.item_draw_image);

    public void requestReq(){
        for (int i = 0; i < 9; i++) {
            observableList.add(new DrawImageItemView(this));
        }
    }
}
