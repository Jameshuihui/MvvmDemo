package net.yhkj.mvvmdemo.ui.addcart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentAddCartBinding;
import net.yhkj.mvvmdemo.utils.AnimManager;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.addcart.AddCartFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/1
 * 描述：
 */
public class AddCartFragment extends BaseFragment<FragmentAddCartBinding, AddCartViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_add_cart;
    }

    @Override
    public int initVariableId() {
        return me.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.addCartEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                new AnimManager.Builder()
                        .with(getActivity())
                        .startView(binding.tvAddCart)
                        .endView(binding.tvCart)
                        .imageUrl("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2458591601,1703332609&fm=26&gp=0.jpg")
                        .build()
                        .startAnim();
            }
        });
    }
}
