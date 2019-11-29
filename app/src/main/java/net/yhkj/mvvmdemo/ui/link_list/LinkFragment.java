package net.yhkj.mvvmdemo.ui.link_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentLinkListBinding;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.binding.viewadapter.recyclerview.ViewAdapter;
import me.goldze.mvvmhabit.utils.KLog;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.link_list.LinkFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class LinkFragment extends BaseFragment<FragmentLinkListBinding, LinkListViewModel> {

    private LinearLayoutManager layoutManager;
    private int mCurrentPosition = 0;
    private int currentId;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_link_list;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        binding.setLeftAdapter(new BindingRecyclerViewAdapter());
        binding.setRightApapter(new BindingRecyclerViewAdapter());
        initLeft();
        viewModel.initLeftData();
    }

    private void initLeft() {
        RecyclerView recyclerViewRight = binding.recyclerViewRight;
        layoutManager = new LinearLayoutManager(getContext());
        recyclerViewRight.setLayoutManager(layoutManager);
        recyclerViewRight.setAdapter(new BindingRecyclerViewAdapter());

        binding.setLeftAdapter(new BindingRecyclerViewAdapter());

        recyclerViewRight.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                KLog.e(">>>>>" + newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        viewModel.isLeftClick = false;
                        break;
                    case RecyclerView.SCROLL_STATE_IDLE:
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        break;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RightItemViewModel itemViewModel = (RightItemViewModel) binding.getRightApapter().getAdapterItem(mCurrentPosition);
                if (currentId != itemViewModel.itemDatas.get().parentId) {
                    currentId = itemViewModel.itemDatas.get().parentId;
                    viewModel.changSelectById(currentId);
                }

                if (mCurrentPosition != layoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = layoutManager.findFirstVisibleItemPosition();
                }
            }
        });
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.uc.onLeftClcikEvent.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                layoutManager.scrollToPositionWithOffset(integer, 0);
            }
        });
    }
}
