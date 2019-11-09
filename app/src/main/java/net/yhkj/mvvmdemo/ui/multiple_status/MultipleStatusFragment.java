package net.yhkj.mvvmdemo.ui.multiple_status;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentMulitpleStatusBinding;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.multiple_status.MultipleStatusFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/30
 * 描述：
 */
public class MultipleStatusFragment extends BaseFragment<FragmentMulitpleStatusBinding, MulitpleStatusViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_mulitple_status;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
//        binding.multipleStatusView.showLoading();
        binding.multipleStatusView.showError();
        binding.multipleStatusView.showEmpty();
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.uc.loadingEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                KLog.e("加载视图");
                binding.multipleStatusView.showLoading();
            }
        });
        viewModel.uc.emptyEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                KLog.e("空视图");
                binding.multipleStatusView.showEmpty();
            }
        });

        viewModel.uc.errorEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                KLog.e("错误视图");
                binding.multipleStatusView.showError();
            }
        });

        viewModel.uc.netEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                KLog.e("网络错误视图");
                binding.multipleStatusView.showNoNetwork();
            }
        });

        viewModel.uc.contentEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                KLog.e("内容视图");
                binding.multipleStatusView.showContent();
            }
        });
    }
}
