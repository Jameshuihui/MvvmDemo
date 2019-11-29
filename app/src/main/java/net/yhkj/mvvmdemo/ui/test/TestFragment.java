package net.yhkj.mvvmdemo.ui.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentTestBinding;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.test.TestFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class TestFragment extends BaseFragment<FragmentTestBinding,TestViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_test;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        binding.setAdatper(new BindingRecyclerViewAdapter());
        viewModel.initData();
    }
}
