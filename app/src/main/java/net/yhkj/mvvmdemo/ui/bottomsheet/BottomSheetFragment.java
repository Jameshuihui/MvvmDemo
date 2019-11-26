package net.yhkj.mvvmdemo.ui.bottomsheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentBottomsheetBinding;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.bottomsheet.BottomSheetFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/26
 * 描述：
 */
public class BottomSheetFragment extends BaseFragment<FragmentBottomsheetBinding, BottomSheetViewModel> {

    private BottomSheetBehavior<View> behavior;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_bottomsheet;
    }

    @Override
    public int initVariableId() {
        return me.goldze.mvvmhabit.BR.viewModel;
    }


    @Override
    public void initData() {
        super.initData();
        viewModel.initData();
        behavior = BottomSheetBehavior.from(binding.bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, @BottomSheetBehavior.State int newState) {
                String state = "null";
                switch (newState) {
                    case 1:
                        state = "STATE_DRAGGING";//过渡状态此时用户正在向上或者向下拖动bottom sheet
                        break;
                    case 2:
                        state = "STATE_SETTLING"; // 视图从脱离手指自由滑动到最终停下的这一小段时间
                        break;
                    case 3:
                        state = "STATE_EXPANDED"; //处于完全展开的状态

                        break;
                    case 4:
                        state = "STATE_COLLAPSED"; //默认的折叠状态
                        break;
                    case 5:
                        state = "STATE_HIDDEN"; //下滑动完全隐藏 bottom sheet
                        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        break;
                }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//                Log.d("BottomSheetDemo", "slideOffset:" + slideOffset);
            }
        });
    }
}
