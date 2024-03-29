package net.yhkj.mvvmdemo.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import net.yhkj.mvvmdemo.R;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.utils.KLog;


/**
 * Created by liuliaopu on 2017/1/23.
 */

public class WineStepsView
        extends FrameLayout
        implements View.OnClickListener {
    private static final String TAG = "StepsView";

    /**
     * 步骤数
     */
    private int mStepsCount;
    /**
     * 当前步骤
     */
    private int mCurrentStepIndex = 0;

    /**
     * 当前操作位置
     */
    private int mCurrentStepPos = 0;

    /**
     * 步骤控件列表
     */
    private ArrayList<TextImageView> mStepViews = new ArrayList<>();

    /**
     * 步骤之间分割线列表
     */
    private ArrayList<ImageView> mSplitLines = new ArrayList<>();

    /**
     * 步骤变化监听
     */
    private OnStepChangedListener mOnStepChangedListener;

    /**
     * 左右边距
     */
    private final int mMarginLeftRightSide;
    /**
     * 控件之间间隙
     */
    private final int mMarginLeftRightGap;
    /**
     * 步骤字体颜色值
     */
    private final int mStepTextColor;
    /**
     * 步骤字体没有选择时的颜色值
     */
    private int mStepNormalTextColor;
    /**
     * 步骤字体大小值
     */
    private int mStepTextSize = sp2px(12);

    /**
     * 所有控件总宽度
     */
    private int mTotalWidth;
    /**
     * step控件的宽度
     */
    private int mStepViewWidth = -1;
    /**
     * step控件高度
     */
    private int mStepViewHeight = -1;
    /**
     * split控件宽度
     */
    private int mSplitLineWidth = dp2px(18);
    /**
     * split控件高度
     */
    private int mSplitLineHeight = -1;

    /**
     * 下三角颜色
     */
    private int mDownTriangleColor;

    private List<String> mStepTextDatas;

    /**
     * 是否开启点击更新步骤
     *
     * @param context
     */
    private boolean isOpenClickUpdateStep = false;

    public WineStepsView(Context context) {
        this(context, null);
    }

    public WineStepsView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public WineStepsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.wine_steps_view);
        mDownTriangleColor = typedArray.getColor(R.styleable.wine_steps_view_down_triangle_color, 0xffffffff);
        mStepTextSize = typedArray.getDimensionPixelSize(R.styleable.wine_steps_view_text_size, mStepTextSize);
        mStepNormalTextColor = typedArray.getColor(R.styleable.wine_steps_view_text_color, 0xffffffff);
        mSplitLineWidth = typedArray.getDimensionPixelSize(R.styleable.wine_steps_view_split_line_width, mSplitLineWidth);
        typedArray.recycle();

        Resources res = context.getResources();
        mMarginLeftRightSide = res.getDimensionPixelOffset(R.dimen.margin_left_right_side);
        mMarginLeftRightGap = res.getDimensionPixelOffset(R.dimen.margin_left_right_gap);

        mStepTextColor = res.getColor(R.color.default_text_color);

//        mStepTextSize = DisplayUtil.sp2px(context, 18);
    }

    /**
     * 设置步骤数，会把当前步骤设置为初始值，列表也会初始化
     *
     * @param count 数
     */
    public void setStepsCount(int count) {
        mStepsCount = count;
        initViews();

        setCurrentStep(0);
    }

    /**
     * 初始化所有子view
     */
    private void initViews() {
        removeAllViews();

        mStepViews.clear();
        mSplitLines.clear();

        mTotalWidth = 0;

        mStepViewWidth = -1;
        mSplitLineWidth = -1;

        for (int i = 0; i < mStepsCount; i++) {
            TextImageView stepView = new TextImageView(getContext());
            stepView.setText((i + 1) + "");

            stepView.setTextSize(mStepTextSize);

            //默认第一个步骤为正在处理
            if (i == 0) {
                stepView.setImageResource(R.drawable.icon_label_now);
                stepView.setTextColor(mStepTextColor);
            } else {
                stepView.setImageResource(R.drawable.icon_label_normal);
                stepView.setTextColor(mStepNormalTextColor);
            }

            stepView.measure(0, 0);

            if (mStepViewWidth < 0) {
                mStepViewWidth = stepView.getMeasuredWidth();
                mStepViewHeight = stepView.getMeasuredHeight();
            }

            mTotalWidth += mStepViewWidth;
            //添加ID
            stepView.setId(i);
            stepView.setOnClickListener(this);
            addView(stepView);

            mStepViews.add(stepView);

            /*分割线比步骤小一个*/
            if (i < mStepsCount - 1) {
                ImageView splitLineView = new ImageView(getContext());
                splitLineView.setImageResource(R.drawable.icon_split_line_disable);
                splitLineView.measure(0, 0);
                mTotalWidth += mMarginLeftRightGap * 2;//添加控件间距

                if (mSplitLineWidth < 0) {
                    mSplitLineWidth = splitLineView.getMeasuredWidth();
                    mSplitLineHeight = splitLineView.getMeasuredHeight();
                }

                mTotalWidth += mSplitLineWidth;//添加分割线宽度

                addView(splitLineView);

                mSplitLines.add(splitLineView);
            }
        }
        invalidate();
    }

    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int width = right - left;
        int height = bottom - top;

        int leftBound = (width - mTotalWidth) / 2;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int childViewWidth = 0;
            int childViewHeight = 0;
            if (i % 2 == 0) {
                childViewWidth = mStepViewWidth;
                childViewHeight = mStepViewHeight;
            } else {
                childViewWidth = mSplitLineWidth;
                childViewHeight = mSplitLineHeight;
            }
            if (i != 0) {
                leftBound += mMarginLeftRightGap;
            }

            childView.layout(leftBound, (height - childViewHeight) / 2,
                    leftBound + childViewWidth, (height + childViewHeight) / 2);
            leftBound += childViewWidth;
        }
    }

    /**
     * 设置步骤变化监听
     *
     * @param listener {@link OnStepChangedListener}
     */
    public void setStepChangedListener(OnStepChangedListener listener) {
        mOnStepChangedListener = listener;
    }

    /**
     * 跳到当前步骤
     *
     * @param stepIndex 步骤索引
     */
    public void setCurrentStep(int stepIndex) {

        if (stepIndex < 0 || mCurrentStepIndex == stepIndex) {
            return;
        }

        mCurrentStepIndex = stepIndex;
        mCurrentStepPos = stepIndex;

        updateStepStatus(mCurrentStepIndex);

        if (mOnStepChangedListener != null) {
            mOnStepChangedListener.onStepChanged(mCurrentStepIndex);
        }

        if (mListener != null) {
            mListener.viewSelect(mStepViews.get(mCurrentStepIndex), mCurrentStepPos);
        }
    }

    /**
     * 跳到下一步
     */
    public void nextStep() {
        if (mCurrentStepIndex >= mStepsCount) {
            mCurrentStepIndex = mStepsCount;
            return;
        }

        setCurrentStep(++mCurrentStepIndex);
    }

    /**
     * 跳到上一步
     */
    public void lastStep() {
        if (mCurrentStepIndex <= 0) {
            mCurrentStepIndex = 0;
            return;
        }
        setCurrentStep(--mCurrentStepIndex);
    }

    private void updateStepStatus(int stepIndex) {
        if (stepIndex < 0) {
            return;
        }

        if (stepIndex >= mStepsCount) {
            doneAll();
            return;
        }

        //小于当前步骤的，设置已经完成该步骤
        for (int i = 0; i < stepIndex; i++) {
            TextImageView stepImageView = mStepViews.get(i);
            //设置完成打钩
            // stepImageView.setImageResource(R.drawable.icon_label_now);
            // stepImageView.setText(null);
            stepImageView.setImageResource(R.drawable.icon_label_now);
            stepImageView.setTextColor(mStepNormalTextColor);
            ImageView splitLineView = mSplitLines.get(i);
            //步骤之间的连接图 已完成
            splitLineView.setImageResource(R.drawable.icon_split_line_enable);
            stepImageView.setTextColor(mStepTextColor);
        }

        //所有大于当前步骤的，设置为未完成状态
        for (int i = stepIndex + 1; i < mStepsCount; i++) {
            TextImageView stepImageView = mStepViews.get(i);
            stepImageView.setImageResource(R.drawable.icon_label_normal);
            stepImageView.setTextColor(mStepNormalTextColor);

            //设置显示的数字
            stepImageView.setText((i + 1) + "");

            ImageView splitLineView = mSplitLines.get(i - 1);
            //步骤之间的连接图 未完成
            splitLineView.setImageResource(R.drawable.icon_split_line_disable);
        }

        //当前步骤正在进行时
        TextImageView stepImageView = mStepViews.get(stepIndex);
        stepImageView.setText((stepIndex + 1) + "");
        stepImageView.setImageResource(R.drawable.icon_label_now);
        stepImageView.setTextColor(mStepTextColor);


        invalidate();
    }

    /**
     * 所有的步骤都已完成
     */
    private void doneAll() {
        for (int i = 0; i < mStepsCount; i++) {
            TextImageView stepImageView = mStepViews.get(i);
            stepImageView.setImageResource(R.drawable.icon_label_now);
            stepImageView.setText(null);

            if (i != mStepsCount - 1) {
                ImageView splitLineView = mSplitLines.get(i);
                splitLineView.setImageResource(R.drawable.icon_split_line_enable);
            }
        }
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        int selectedIndex = mCurrentStepIndex >= mStepsCount ? mStepsCount - 1 : mCurrentStepIndex;
//        if (mStepViews == null || mStepViews.size() == 0) {
//            return;
//        }
        View childView = mStepViews.get(selectedIndex);

        if (childView == null) {
            return;
        }

        int height = getHeight();
        int left = childView.getLeft();

        /*下三角高度*/
        int downTrian = (getHeight() - mStepViewHeight) / 2;

        Path path = new Path();
        path.moveTo(left + mStepViewWidth / 2, height - downTrian);
        path.lineTo(left + mStepViewWidth / 2 - downTrian, height);
        path.lineTo(left + mStepViewWidth / 2 + downTrian, height);
        path.close();

        Paint paint = new Paint();
        paint.setColor(mDownTriangleColor);

        canvas.drawPath(path, paint);
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            int id = v.getId();
            mCurrentStepPos = id;
            mListener.viewSelect(v, mCurrentStepPos);
            if (isOpenClickUpdateStep) {
                mCurrentStepIndex = id;
                updateStepStatus(mCurrentStepIndex);
            }
        } else {
            KLog.e("请初始化监听事件");
        }
    }

    public void setOpenClickUpdateStep(boolean openClickUpdateStep) {
        isOpenClickUpdateStep = openClickUpdateStep;
    }

    public interface OnStepChangedListener {
        /**
         * 进行到某一步，从0开始计算
         *
         * @param stepIndex 步骤索引
         */
        void onStepChanged(int stepIndex);
    }

    private int sp2px(int sp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
    }

    private int dp2px(float dipValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    private addViewSelectListener mListener;

    public interface addViewSelectListener {
        void viewSelect(View view, int position);
    }

    public void setAddViewSelectListener(addViewSelectListener listener) {
        this.mListener = listener;
    }

}
