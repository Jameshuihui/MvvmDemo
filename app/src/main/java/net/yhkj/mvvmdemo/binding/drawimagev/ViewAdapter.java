package net.yhkj.mvvmdemo.binding.drawimagev;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.google.android.material.button.MaterialButton;

import net.yhkj.mvvmdemo.view.DragDeleteView;

import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 文件名：net.yhkj.mvvmdemo.binding.drawimagev.ViewAdapter
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/22
 * 描述：
 */
public class ViewAdapter {
    @BindingAdapter(value = {"onDraw"}, requireAll = false)
    public static void setOnClickBackCommand(final AppCompatImageView view, final BindingCommand clickBackCommand) {
        DragDeleteView.attach(view, new DragDeleteView.Callback() {
            @Override
            public void onDelete() {
                clickBackCommand.execute();
            }
        });
    }
}
