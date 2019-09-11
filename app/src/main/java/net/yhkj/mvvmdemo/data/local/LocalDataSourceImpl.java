package net.yhkj.mvvmdemo.data.local;

import net.yhkj.mvvmdemo.data.LocDataSevice;

/**
 * 文件名：net.yhkj.mvvmdemo.data.local.LocalDataSourceImpl
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/11
 * 描述：
 */
public class LocalDataSourceImpl implements LocDataSevice {
    private volatile static LocalDataSourceImpl INSTANCE = null;

    public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private LocalDataSourceImpl() {
        //数据库Helper构建
    }


}
