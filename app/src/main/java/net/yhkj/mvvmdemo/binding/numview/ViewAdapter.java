package net.yhkj.mvvmdemo.binding.numview;

import androidx.databinding.BindingAdapter;

import com.google.android.material.button.MaterialButton;

import net.yhkj.mvvmdemo.view.NumberPickerView;

import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 文件名：net.yhkj.mvvmdemo.binding.numview.ViewAdapter
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/12/5
 * 描述：
 */
public class ViewAdapter {
    @BindingAdapter(value = {"num"}, requireAll = false)
    public static void setOnClickBackCommand(final NumberPickerView view, final BindingCommand clickBackCommand) {

    }
}
