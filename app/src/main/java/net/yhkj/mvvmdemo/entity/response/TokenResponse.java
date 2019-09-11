package net.yhkj.mvvmdemo.entity.response;

import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * 文件名：net.yhkj.mvvmdemo.entity.response.TokenResponse
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/11
 * 描述：
 */
public class TokenResponse {
    private String authorization;

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
}
