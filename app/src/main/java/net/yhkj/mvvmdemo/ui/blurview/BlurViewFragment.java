package net.yhkj.mvvmdemo.ui.blurview;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.components.SimpleImmersionOwner;
import com.gyf.immersionbar.components.SimpleImmersionProxy;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentBlurviewBinding;
import net.yhkj.mvvmdemo.utils.StatusBarUtil;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.blurview.BlurViewFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/12/12
 * 描述：
 */
public class BlurViewFragment extends BaseFragment<FragmentBlurviewBinding,BlurViewViewModel> implements SimpleImmersionOwner {

    /**
     * ImmersionBar代理类
     */
    private SimpleImmersionProxy mSimpleImmersionProxy = new SimpleImmersionProxy(this);

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_blurview;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.include.toolbar);
        //状态栏透明和间距处理
        StatusBarUtil.darkMode(getActivity());
        StatusBarUtil.setPaddingSmart(getContext(), binding.recyclerView);
        StatusBarUtil.setPaddingSmart(getContext(), binding.include.toolbar);
        StatusBarUtil.setPaddingSmart(getContext(),binding.blurView);
        viewModel.setTitleText("白酒");
        viewModel.requestReq();
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.uc.finishRefreshing.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.refreshLayout.finishRefresh(aBoolean);
                if (aBoolean){
                    binding.refreshLayout.resetNoMoreData();
                }
            }
        });
        viewModel.uc.finishLoadmore.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.refreshLayout.finishLoadMore(aBoolean);
            }
        });

        viewModel.uc.noMoreData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.refreshLayout.finishLoadMoreWithNoMoreData();
            }
        });

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSimpleImmersionProxy.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSimpleImmersionProxy.onDestroy();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        mSimpleImmersionProxy.onHiddenChanged(hidden);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mSimpleImmersionProxy.onConfigurationChanged(newConfig);
    }

    @Override
    public void initImmersionBar() {
//        ImmersionBar.with(this)
//                .statusBarDarkFont(true)
////                .fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
////                .statusBarColor(R.color.white)
//                .init();
    }

    /**
     * 是否可以实现沉浸式，当为true的时候才可以执行initImmersionBar方法
     * Immersion bar enabled boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean immersionBarEnabled() {
        return true;
    }}
