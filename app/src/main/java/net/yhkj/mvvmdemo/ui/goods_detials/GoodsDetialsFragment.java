package net.yhkj.mvvmdemo.ui.goods_detials;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentGoodsDetialsBinding;
import net.yhkj.mvvmdemo.ui.base.BaseFragmentPagerAdapter;
import net.yhkj.mvvmdemo.ui.goods_detials.detials.CommentFragment;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.goods_detials.GoodsDetialsFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/19
 * 描述：
 */
public class GoodsDetialsFragment extends BaseFragment<FragmentGoodsDetialsBinding,GoodsDetidalsViewModel> {
    private List<Fragment> mFragments;
    private List<String> titlePager;
    private float totalHight1;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_goods_detials;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        mFragments = new ArrayList<>();
        titlePager =new ArrayList<>();

        mFragments.add(new CommentFragment());
        titlePager.add("详情");
        mFragments.add(new CommentFragment());
        titlePager.add("评价");

        mFragments.add(new CommentFragment());
        titlePager.add("whatever");

        //设置Adapter
        BaseFragmentPagerAdapter pagerAdapter = new BaseFragmentPagerAdapter(getChildFragmentManager(),0, mFragments, titlePager);
        binding.viewPager.setAdapter(pagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewPager);
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabs));

        //APPBAR滚动监听
        binding.appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (totalHight1==0) {
                    totalHight1 = (float) (binding.appbar.getHeight() - binding.tabs.getHeight());
                    binding.tabs.setVisibility(View.GONE);
                }
                float alpha = (-1*i)/totalHight1;
                if (alpha>0.4f){
                    binding.tabs.setVisibility(View.VISIBLE);
                }else{
                    binding.tabs.setVisibility(View.GONE);
                }
                KLog.e(">>>>>"+alpha);
                binding.tabs.setAlpha(alpha);
            }
        });
    }
}
