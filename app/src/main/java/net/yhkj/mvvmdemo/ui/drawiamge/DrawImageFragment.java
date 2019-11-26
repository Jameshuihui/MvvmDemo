package net.yhkj.mvvmdemo.ui.drawiamge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentDrawImgaeBinding;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.drawiamge.DrawImageFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/22
 * 描述：
 */
public class DrawImageFragment extends BaseFragment<FragmentDrawImgaeBinding, DrawImageViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_draw_imgae;
    }

    @Override
    public int initVariableId() {
        return me.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        viewModel.requestReq();
    }
}
