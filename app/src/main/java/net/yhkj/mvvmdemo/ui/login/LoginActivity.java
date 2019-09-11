package net.yhkj.mvvmdemo.ui.login;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.base.AppViewModelFactory;
import net.yhkj.mvvmdemo.databinding.ActivityLoginBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.login.LoginActivity
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/10
 * 描述：
 */
public class LoginActivity extends BaseActivity <ActivityLoginBinding,LoginViewModel>{

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public LoginViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(LoginViewModel.class);
    }


}
