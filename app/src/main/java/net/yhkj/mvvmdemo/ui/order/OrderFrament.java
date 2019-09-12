package net.yhkj.mvvmdemo.ui.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;


import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.base.AppViewModelFactory;
import net.yhkj.mvvmdemo.databinding.FragmentOrderBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.order.OrderFrament
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/12
 * 描述：
 */
public class OrderFrament extends BaseFragment<FragmentOrderBinding, OrderViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_order;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public OrderViewModel initViewModel() {

        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(OrderViewModel.class);
    }
}
