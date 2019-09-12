package net.yhkj.mvvmdemo.data;

import net.yhkj.mvvmdemo.entity.response.TokenResponse;

import java.util.Map;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * 文件名：net.yhkj.mvvmdemo.data.HttpDataSevice
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/11
 * 描述：
 */
public interface HttpDataSevice {
    Observable<BaseResponse<TokenResponse>> getToken();

    Observable<BaseResponse> login(Map requestBody);
}
