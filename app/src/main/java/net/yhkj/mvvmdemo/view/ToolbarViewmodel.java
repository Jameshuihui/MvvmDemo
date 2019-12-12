package net.yhkj.mvvmdemo.view;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;


import net.yhkj.mvvmdemo.entity.ToolbarBean;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 文件名：net.yhkj.onlywine.view.toolbar.ToolbarViewmodel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/19
 * 描述：
 */
public class ToolbarViewmodel<M extends BaseModel> extends BaseViewModel<M> {

    public ObservableInt obPageStatus = new ObservableInt(MultipleStatusView.STATUS_CONTENT);
    //
    public ObservableField<ToolbarBean> toolbarBeanObservableField = new ObservableField<>();
    //标题文字
    public ObservableField<String> titleText = new ObservableField<>("忘记密码");
    //右边文字
    public ObservableField<String> rightText = new ObservableField<>("");
    //右边文字的观察者
    public ObservableInt rightTextVisibleObservable = new ObservableInt(View.GONE);
    //右边图标的观察者
    public ObservableInt rightIconVisibleObservable = new ObservableInt(View.GONE);

    //右边图标的观察者ContextCompat.getDrawable(getApplication(), R.drawable.home_icon_goods)
    public ObservableField<String> rightIconSrcObservable = new ObservableField<>();

    //兼容databinding，去泛型化
    public ToolbarViewmodel toolbarViewModel;
    private ToolbarBean bean;


    public ToolbarViewmodel(@NonNull Application application) {
        this(application, null);
    }

    public ToolbarViewmodel(@NonNull Application application, M model) {
        super(application, model);
        toolbarViewModel = this;
    }



    /**
     * 设置标题
     *
     * @param text 标题文字
     */
    public void setTitleText(String text) {
        titleText.set(text);
    }

    /**
     * 设置右边文字
     *
     * @param text 右边文字
     */
    public void setRightText(String text) {
        setRightTextVisible(View.VISIBLE);
        rightText.set(text);
    }

    /**
     * 设置右边文字的显示和隐藏
     *
     * @param visibility
     */
    public void setRightTextVisible(int visibility) {
        rightTextVisibleObservable.set(visibility);
    }

    /**
     * 设置右边图标的显示和隐藏
     *
     * @param visibility
     */
    public void setRightIconVisible(int visibility) {
        rightIconVisibleObservable.set(visibility);
    }

    public void setRightIcon(int icon) {
        setRightIconVisible(View.VISIBLE);
        rightIconSrcObservable.set(String.valueOf(icon));
//        bean.setRightIconSrc();
//        toolbarBeanObservableField.set(bean);
    }

    /**
     * 返回按钮的点击事件
     */
    public final BindingCommand backOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            finish();
        }
    });

    public BindingCommand rightTextOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            rightTextOnClick();
        }
    });
    public BindingCommand rightIconOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            rightIconOnClick();
        }
    });

    /**
     * 右边文字的点击事件，子类可重写
     */
    protected void rightTextOnClick() {
    }

    /**
     * 右边图标的点击事件，子类可重写
     */
    protected void rightIconOnClick() {
    }


}
