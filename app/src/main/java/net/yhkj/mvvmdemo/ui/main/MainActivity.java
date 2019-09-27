package net.yhkj.mvvmdemo.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.Manifest;
import android.os.Bundle;

import com.tbruyelle.rxpermissions2.RxPermissions;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.ActivityMainBinding;
import net.yhkj.mvvmdemo.ui.sweep_code.SweepCodeActivity;

import io.reactivex.functions.Consumer;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        binding.setAdapter(new BindingRecyclerViewAdapter());
        viewModel.initData();
        getPermission();
    }

    private void getPermission() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            ToastUtils.showShort("相机权限已经打开，直接跳入相机");
                        } else {
                            ToastUtils.showShort("权限被拒绝");
                        }
                    }
                });
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.onItemClcikEvent.observe(this, new Observer<MainItemViewModel>() {
            @Override
            public void onChanged(MainItemViewModel mainItemViewModel) {
                switch (mainItemViewModel.obMainData.get().tag) {
                    case 1:
                        //扫码
                        startActivity(SweepCodeActivity.class);
                        break;
                }
            }
        });
    }
}
