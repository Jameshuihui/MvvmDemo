package net.yhkj.mvvmdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

/**
 * 文件名：net.yhkj.mvvmdemo.view.DataBindingRadioGroup
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/30
 * 描述：
 */
@InverseBindingMethods({
        @InverseBindingMethod(
                type = DataBindingRadioGroup.class,
                attribute = "checkedValue",
                event = "checkedValueAttrChanged",
                method = "getCheckedValue")
})
public class DataBindingRadioGroup extends RadioGroup {
    private Integer checkedValue;
    private OnValueChangedListener listener;

    public DataBindingRadioGroup(Context context) {
        super(context);
        init();
    }

    public DataBindingRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId > 0) {
                DataBindingRadioButton radioButton = (DataBindingRadioButton) findViewById(checkedId);
                setCheckedValue(radioButton.isChecked() ? radioButton.getValue() : null);
            } else {
                setCheckedValue(null);
            }
        });
    }

    public Integer getCheckedValue() {
        return checkedValue;
    }

    public void setCheckedValue(Integer checkedValue) {

        if (this.checkedValue == checkedValue) {
            return;
        }

        this.checkedValue = checkedValue;

        if (this.checkedValue == null) {
            clearCheck();
        } else {
            DataBindingRadioButton customRadioButton = (DataBindingRadioButton) findViewById(getCheckedRadioButtonId());
            if (customRadioButton == null || checkedValue==customRadioButton.getValue()) {

                for (int i = 0; i < getChildCount(); i++) {
                    View child = getChildAt(i);
                    if (child instanceof DataBindingRadioButton) {
                        Integer value = ((DataBindingRadioButton) child).getValue();
                        if (checkedValue==value) {
                            ((DataBindingRadioButton) child).setChecked(true);
                        }
                    }
                }
            }
        }

        if (listener != null) {
            listener.onValueChanged();
        }
    }

    public void setListener(OnValueChangedListener listener) {
        this.listener = listener;
    }

    public interface OnValueChangedListener {
        void onValueChanged();
    }

    @BindingAdapter("checkedValueAttrChanged")
    public static void setValueChangedListener(DataBindingRadioGroup view, final InverseBindingListener bindingListener) {
        if (bindingListener == null) {
            view.setListener(null);
        } else {
            // 通知 ViewModel
            view.setListener(bindingListener::onChange);
        }
    }

}
