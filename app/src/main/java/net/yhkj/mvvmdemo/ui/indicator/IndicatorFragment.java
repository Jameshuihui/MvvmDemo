package net.yhkj.mvvmdemo.ui.indicator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentIndicatorBinding;
import net.yhkj.mvvmdemo.ui.indicator.step.StepView2Fragment;
import net.yhkj.mvvmdemo.ui.indicator.step.StepViewFragment;
import net.yhkj.mvvmdemo.view.WineStepsView;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.indicator.IndicatorFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/13
 * 描述：
 */
public class IndicatorFragment extends BaseFragment<FragmentIndicatorBinding, IndicatorViewModel> {
    private StepView2Fragment step2;
    private StepViewFragment step1;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_indicator;
    }

    @Override
    public int initVariableId() {
        return me.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        binding.stepView.setStepsCount(2);
        binding.stepView.setCurrentStep(0);
        binding.setAdapter(new BindingRecyclerViewAdapter());
        binding.stepView.setAddViewSelectListener(new WineStepsView.addViewSelectListener() {
            @Override
            public void viewSelect(View view, int position) {
                changeFragment(position);
            }
        });
        viewModel.initData();
        step1 = new StepViewFragment();
        step2 = new StepView2Fragment();
        fm = getChildFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.frame, step1).add(R.id.frame,step2).hide(step2).show(step1).commit();

    }


    private void changeFragment(int position) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (position) {
            case 0:
                fragmentTransaction.hide(step2).show(step1);
                break;
            case 1:
                fragmentTransaction.hide(step1).show(step2);
                break;
        }
        fragmentTransaction.commit();
    }
}
