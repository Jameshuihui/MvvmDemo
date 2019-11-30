package net.yhkj.mvvmdemo.base;

import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.entity.UpdateError;
import com.xuexiang.xupdate.listener.OnUpdateFailureListener;
import com.xuexiang.xupdate.utils.UpdateUtils;

import net.yhkj.mvvmdemo.ui.main.MainActivity;
import net.yhkj.mvvmdemo.R;

import me.goldze.mvvmhabit.base.BaseApplication;
import me.goldze.mvvmhabit.crash.CaocConfig;
import me.goldze.mvvmhabit.utils.KLog;
import me.goldze.mvvmhabit.utils.Utils;

import static com.xuexiang.xupdate.entity.UpdateError.ERROR.CHECK_NO_NEW_VERSION;

/**
 * 文件名：net.yhkj.mvvmdemo.base.MvvmDemoApplaction
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/10
 * 描述：
 */
public class MvvmDemoApplaction extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(getApplicationContext());
        initFrame();
//        initUpdate();
    }

//    private void initUpdate() {
//        XUpdate.get()
//                .debug(true)
//                .isWifiOnly(true)                                               //默认设置只在wifi下检查版本更新
//                .isGet(true)                                                    //默认设置使用get请求检查版本
//                .isAutoMode(false)                                              //默认设置非自动模式，可根据具体使用配置
//                .param("versionCode", UpdateUtils.getVersionCode(this))         //设置默认公共请求参数
//                .param("appKey", getPackageName())
//                .setOnUpdateFailureListener(new OnUpdateFailureListener() {     //设置版本更新出错的监听
//                    @Override
//                    public void onFailure(UpdateError error) {
//                        if (error.getCode() != CHECK_NO_NEW_VERSION) {          //对不同错误进行处理
//                        }
//                    }
//                })
//                .supportSilentInstall(true)                                     //设置是否支持静默安装，默认是true
//                .setIUpdateHttpService(new OKHttpUpdateHttpService())           //这个必须设置！实现网络请求功能。
//                .init(this);                                                    //这个必须初始化
//    }

    private void initFrame() {
        //是否开启日志打印
        KLog.init(true);
//配置全局异常崩溃操作
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM) //背景模式,开启沉浸式
                .enabled(false) //是否启动全局异常捕获
                .showErrorDetails(false) //是否显示错误详细信息
                .showRestartButton(false) //是否显示重启按钮
                .trackActivities(false) //是否跟踪Activity
                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
                .errorDrawable(R.mipmap.ic_launcher) //错误图标
                .restartActivity(MainActivity.class) //重新启动后的activity
                .errorActivity(MainActivity.class) //崩溃后的错误activity
//                .eventListener(new YourCustomEventListener()) //崩溃后的错误监听
                .apply();
    }
}
