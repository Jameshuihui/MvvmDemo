package net.yhkj.mvvmdemo.ui.double_rv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentDoubleRvBinding;
import net.yhkj.mvvmdemo.minterface.OnParentTouchEvent;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.tatarka.bindingcollectionadapter2.LayoutManagers;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.double_rv.DoubeRvFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/15
 * 描述：
 */
public class DoubeRvFragment extends BaseFragment<FragmentDoubleRvBinding,DoubleRvViewModel> implements OnParentTouchEvent {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_double_rv;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        viewModel.initData();
        binding.recyclerView1.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    binding.recyclerView2.scrollBy(dx, dy);

                }
            }
        });

        binding.recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    binding.recyclerView1.scrollBy(dx, dy);
                }
            }
        });
        binding.recyclerView1.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }


    private void moveToPosition(int n) {
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) binding.recyclerView1.getLayoutManager();
        int firstItem =linearLayoutManager.findFirstVisibleItemPosition();
        int lastItem = linearLayoutManager.findLastVisibleItemPosition();
        //然后区分情况
        if (n <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
            binding.recyclerView2.scrollToPosition(n);
        } else if (n <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            int top =  binding.recyclerView2.getChildAt(n - firstItem).getTop();
            binding.recyclerView2.scrollBy(0, top);
        } else {
            //当要置顶的项在当前显示的最后一项的后面时
            binding.recyclerView2.scrollToPosition(n);
            //这里这个变量是用在RecyclerView滚动监听里面的
        }
    }



    private boolean touchEventInView(View view, float x, float y) {
        if (view == null) {
            return false;
        }

        int[] location = new int[2];
        view.getLocationOnScreen(location);

        int left = location[0];
        int top = location[1];

        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();

        if (y >= top && y <= bottom && x >= left && x <= right) {
            return true;
        }

        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        /**
         * 如果用户的手指同时放在屏幕上滑动，不要触发滚动事件。
         *
         */
        if (event.getPointerCount() >= 2) {
            return true;
        }

        /**
         * 如果左侧的RecyclerView1在滚动中，但是此时用户又在RecyclerView2中触发滚动事件，则停止所有滚动，等待新一轮滚动。
         *
         */
        if (binding.recyclerView1.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
            if (touchEventInView(binding.recyclerView2, event.getX(), event.getY())) {
                binding.recyclerView1.stopScroll();
                binding.recyclerView2.stopScroll();
                return true;
            }
        }

        /**
         * 如果右侧的RecyclerView2在滚动中，但是此时用户又在RecyclerView1中触发滚动事件，则停止所有滚动，等待新一轮滚动。
         *
         */
        if (binding.recyclerView2.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
            if (touchEventInView(binding.recyclerView1, event.getX(), event.getY())) {
                binding.recyclerView2.stopScroll();
                binding.recyclerView1.stopScroll();
                return true;
            }
        }
        return false;
    }
}
