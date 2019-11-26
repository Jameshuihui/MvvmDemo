package net.yhkj.mvvmdemo.ui.suction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentSuctionTopBinding;
import net.yhkj.mvvmdemo.utils.TimeUtil;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.utils.KLog;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.suction.SuctionTopFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/26
 * 描述：
 */
public class SuctionTopFragment extends BaseFragment<FragmentSuctionTopBinding, SuctionTopViewModel> {
    private int mSuspensionHeight;
    private LinearLayoutManager linearLayoutManager;
    private int mCurrentPosition = 0;
    private LinearLayout llTop;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_suction_top;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        llTop = binding.llTop;
        linearLayoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        viewModel.initData();
        binding.setAdapter(new BindingRecyclerViewAdapter());
        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mSuspensionHeight = binding.llTop.getHeight();
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                MultiItemViewModel item = (MultiItemViewModel) binding.getAdapter().getAdapterItem(mCurrentPosition + 1);
                int itemType = (int) item.getItemType();
                if (itemType == viewModel.MultiRecycleTypeDate) {
                    View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                    if (view != null) {
                        if (view.getTop() <= mSuspensionHeight) {
                            llTop.setY(-(mSuspensionHeight - view.getTop()));
                        } else {
                            llTop.setY(0);
                        }
                    }
                    updateData();
                }

                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    KLog.e(">>>>" + mCurrentPosition + "****" + linearLayoutManager.findFirstVisibleItemPosition());
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    llTop.setY(0);
                } else {
                    KLog.e("+++>>>>" + mCurrentPosition + "****" + linearLayoutManager.findFirstVisibleItemPosition());
                }
            }
        });
        updateData();
    }

    private void updateData() {
        binding.tvTimeDay.setText(TimeUtil.getTime2(System.currentTimeMillis()));
    }
}
