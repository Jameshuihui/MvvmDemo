package net.yhkj.mvvmdemo.base;

import net.yhkj.mvvmdemo.ui.main.MainActivity;
import net.yhkj.mvvmdemo.R;

import me.goldze.mvvmhabit.base.BaseApplication;
import me.goldze.mvvmhabit.crash.CaocConfig;
import me.goldze.mvvmhabit.utils.KLog;
import me.goldze.mvvmhabit.utils.Utils;

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
    }

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
