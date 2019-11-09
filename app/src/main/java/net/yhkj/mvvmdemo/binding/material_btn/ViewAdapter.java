package net.yhkj.mvvmdemo.binding.material_btn;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.google.android.material.button.MaterialButton;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 文件名：net.yhkj.mvvmdemo.binding.material_btn.ViewAdapter
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/30
 * 描述：
 */
public class ViewAdapter {
    @BindingAdapter(value = {"onClickCommand"}, requireAll = false)
    public static void setOnClickBackCommand(final MaterialButton view, final BindingCommand clickBackCommand) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxView.clicks(view)
                        .subscribe(new Consumer<Object>() {
                            @Override
                            public void accept(Object object) throws Exception {
                                if (clickBackCommand != null) {
                                    clickBackCommand.execute();
                                }
                            }
                        });
            }
        });
    }
}
