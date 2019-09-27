package net.yhkj.mvvmdemo.ui.mulist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentMulistBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.mulist.MuListFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/27
 * 描述：
 */
public class MuListFragment extends BaseFragment<FragmentMulistBinding, MuListViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_mulist;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        viewModel.initData();
    }
}
