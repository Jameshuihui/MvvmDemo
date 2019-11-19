package net.yhkj.mvvmdemo.ui.indicator.step;

import android.app.Application;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.indicator.step.StepViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/14
 * 描述：
 */
public class StepViewModel extends BaseViewModel {
    public StepViewModel(@NonNull Application application) {
        super(application);
    }

    public StepViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }
}
