package net.yhkj.mvvmdemo.base;


import net.yhkj.mvvmdemo.data.HttpDataSevice;
import net.yhkj.mvvmdemo.data.LocDataSevice;
import net.yhkj.mvvmdemo.data.http.HttpDataSourceImpl;
import net.yhkj.mvvmdemo.data.http.MvvmApiSevice;
import net.yhkj.mvvmdemo.data.local.LocalDataSourceImpl;
import net.yhkj.mvvmdemo.data.respository.LoginRepository;
import net.yhkj.mvvmdemo.utils.RetrofitClient;

/**
 * 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 * Created by goldze on 2019/3/26.
 */
public class Injection {
    public static LoginRepository provideLoginRepository() {
        //网络API服务
        MvvmApiSevice apiService = RetrofitClient.getInstance().create(MvvmApiSevice.class);
        //网络数据源
        HttpDataSevice httpDataSource = HttpDataSourceImpl.getInstance(apiService);
        //本地数据源
        LocDataSevice localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return LoginRepository.getInstance(httpDataSource, localDataSource);
    }
}
