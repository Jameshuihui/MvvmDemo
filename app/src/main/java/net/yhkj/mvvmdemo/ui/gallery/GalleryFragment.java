package net.yhkj.mvvmdemo.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentGalleryBinding;
import net.yhkj.mvvmdemo.view.HorizontalScrollViewAdapter;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.gallery.GalleryFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/9
 * 描述：
 */
public class GalleryFragment extends BaseFragment<FragmentGalleryBinding, GalleryViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_gallery;
    }

    @Override
    public int initVariableId() {
        return me.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        List<Integer> mDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDatas.add(R.mipmap.ic_launcher);
        }
      HorizontalScrollViewAdapter adapter=  new HorizontalScrollViewAdapter(getContext(),mDatas);
        binding.horizontalScrollView.initDatas(adapter);
    }
}
