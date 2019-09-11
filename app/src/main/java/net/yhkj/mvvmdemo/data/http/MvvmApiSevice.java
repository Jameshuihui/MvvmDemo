package net.yhkj.mvvmdemo.data.http;

import net.yhkj.mvvmdemo.entity.response.TokenResponse;

import java.util.Map;

import io.reactivex.Observable;

import me.goldze.mvvmhabit.http.BaseResponse;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * 文件名：net.yhkj.mvvmdemo.data.http.MvvmApiSevice
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/11
 * 描述：
 */
public  interface MvvmApiSevice {
    @GET("/authorization")
     Observable<BaseResponse<TokenResponse>> loginGet();


    @POST("/app/login")
    Observable<BaseResponse> loginPost(@PartMap Map<String, RequestBody> requestBodyMap);


}
