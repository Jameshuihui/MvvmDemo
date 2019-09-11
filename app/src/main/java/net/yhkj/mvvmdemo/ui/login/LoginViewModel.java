package net.yhkj.mvvmdemo.ui.login;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import net.yhkj.mvvmdemo.data.respository.LoginRepository;
import net.yhkj.mvvmdemo.entity.response.TokenResponse;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.KLog;
import me.goldze.mvvmhabit.utils.RegexUtils;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.login.LoginViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/10
 * 描述：
 */
public class LoginViewModel extends BaseViewModel<LoginRepository> {
    //用户名的绑定
    public ObservableField<String> userName = new ObservableField<String>("15585095866");
    //密码的绑定
    public ObservableField<String> password = new ObservableField<String>("");


    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public LoginViewModel(@NonNull Application application, LoginRepository model) {
        super(application, model);
    }

    public BindingCommand loginClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            login();
        }
    });

    private void login() {
        if (TextUtils.isEmpty(userName.get())) {
            ToastUtils.showShort("请输入您的手机号码");
            return;
        }
        if (!RegexUtils.isMobileSimple(userName.get())) {
            ToastUtils.showShort("手机号格式不正确");
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtils.showShort("请输入密码");
            return;
        }
        getToken();
    }

    @SuppressLint("CheckResult")
    private void getToken() {
        model.getToken()
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(this)//请求与ViewModel周期同步
                .compose(RxUtils.exceptionTransformer()) // 网络错误的异常转换, 这里可以换成自己的ExceptionHandle
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        showDialog("正在登录...");
                    }
                }).subscribe(new Consumer<BaseResponse<TokenResponse>>() {

            @Override
            public void accept(BaseResponse<TokenResponse> response) throws Exception {
                KLog.e(response.getResult().getAuthorization());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                KLog.e("出问题了"+throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                ToastUtils.showShort("完犊子了");
            }
        });

    }

    private void loginReq() {

    }
}
