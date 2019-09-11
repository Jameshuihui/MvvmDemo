package net.yhkj.mvvmdemo.data.http;

import net.yhkj.mvvmdemo.data.HttpDataSevice;
import net.yhkj.mvvmdemo.entity.response.TokenResponse;

import java.util.Map;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * 文件名：net.yhkj.mvvmdemo.data.http.HttpDataSourceImpl
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/11
 * 描述：
 */
public class HttpDataSourceImpl implements HttpDataSevice {
    private MvvmApiSevice mvvmApiSevice;

    private volatile static HttpDataSourceImpl INSTANCE = null;

    public HttpDataSourceImpl(MvvmApiSevice apiService) {
        this.mvvmApiSevice = apiService;
    }

    public static HttpDataSourceImpl getInstance(MvvmApiSevice apiService) {
        if (INSTANCE == null) {
            synchronized (HttpDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSourceImpl(apiService);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public Observable<BaseResponse<TokenResponse>> getToken() {
        return mvvmApiSevice.loginGet();
    }

    @Override
    public Observable<BaseResponse> login(Map requestBody){
        return mvvmApiSevice.loginPost(requestBody);
    }
}
