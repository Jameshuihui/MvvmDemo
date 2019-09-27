package net.yhkj.mvvmdemo.ui.sweep_code.code_result;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.sweep_code.code_result.SweepCodeResultViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/26
 * 描述：
 */
public class SweepCodeResultViewModel extends BaseViewModel {
    public ObservableField<String> observableResultField=new ObservableField<>();
    public SweepCodeResultViewModel(@NonNull Application application) {
        super(application);
    }

    public SweepCodeResultViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }
}
