package net.yhkj.mvvmdemo.data.respository;

import androidx.annotation.NonNull;

import net.yhkj.mvvmdemo.data.HttpDataSevice;
import net.yhkj.mvvmdemo.data.LocDataSevice;
import net.yhkj.mvvmdemo.entity.response.TokenResponse;

import java.util.Map;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * 文件名：com.goldze.mvvmhabit.data.respository.LoginRepository
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/11
 * 描述：
 */
public class LoginRepository extends BaseModel implements LocDataSevice, HttpDataSevice {

    private volatile static LoginRepository INSTANCE = null;
    private final HttpDataSevice mHttpDataSevice;

    private final LocDataSevice mLocDataSevice;

    private LoginRepository(@NonNull HttpDataSevice httpDataSevice,
                           @NonNull LocDataSevice locDataSevice) {
        this.mHttpDataSevice = httpDataSevice;
        this.mLocDataSevice = locDataSevice;
    }

    public static LoginRepository getInstance(HttpDataSevice httpDataSevice,
                                             LocDataSevice locDataSevice) {
        if (INSTANCE == null) {
            synchronized (LoginRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LoginRepository(httpDataSevice, locDataSevice);
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public Observable<BaseResponse<TokenResponse>> getToken() {
        return mHttpDataSevice.getToken();
    }

    @Override
    public Observable<BaseResponse> login(Map requestBody) {
        return mHttpDataSevice.login(requestBody);
    }


}
