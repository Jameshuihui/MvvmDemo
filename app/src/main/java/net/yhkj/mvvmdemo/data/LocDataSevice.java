package net.yhkj.mvvmdemo.data;

/**
 * 文件名：net.yhkj.mvvmdemo.data.LocDataSevice
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/11
 * 描述：
 */
public interface LocDataSevice {
    /**
     * 保存登录状态
     */
    void saveLoginStatus(boolean isLogin);

    /**
     * 获取登录状态
     */
    boolean getLoignStatus();
}
