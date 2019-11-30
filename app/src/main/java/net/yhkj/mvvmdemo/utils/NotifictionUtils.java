package net.yhkj.mvvmdemo.utils;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;


import net.yhkj.mvvmdemo.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * 文件名：net.yhkj.notificationdemo.NotifictionUtils
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/28
 * 描述：
 */
public class NotifictionUtils {
    private volatile static NotifictionUtils mInstance = null;

    private NotificationManager mManager;

    public static NotifictionUtils getInstance() {
        if (mInstance == null) {
            synchronized (NotifictionUtils.class) {
                if (mInstance == null) {
                    mInstance = new NotifictionUtils();
                }
            }
        }
        return mInstance;
    }


    @TargetApi(Build.VERSION_CODES.O)
    public void createNotificationChannel(Context mContext, String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.setShowBadge(true);
        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
    }

    public void sendNotification(Context mContxt, int notifyId, Notification notification) {
        getManager(mContxt).notify(notifyId, notification);
    }

    public NotificationCompat.Builder sendProgressNotification(Context mContext, int progress) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext, NotificationEnum.PROGRESS.getChannelId())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("正在下载")
                .setContentText(progress + "%")
                .setProgress(100, progress, false);

        Notification notification = builder.build();
        sendNotification(mContext, NotificationEnum.PROGRESS.getId(), notification);
        return builder;
    }


    private NotificationManager getManager(Context mContext) {
        if (mManager == null) {
            mManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }
}
