package net.yhkj.mvvmdemo.ui.sweep_code;

import android.app.Application;

import androidx.annotation.NonNull;

import net.yhkj.mvvmdemo.data.respository.LoginRepository;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.sweep_code.SweepCodeViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/26
 * 描述：
 */
public class SweepCodeViewModel extends BaseViewModel {
    public SweepCodeViewModel(@NonNull Application application) {
        super(application);
    }

    public SweepCodeViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }
}
