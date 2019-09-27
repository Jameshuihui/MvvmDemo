package net.yhkj.mvvmdemo.ui.sweep_code;

import android.os.Bundle;

import com.google.zxing.Result;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.ActivitySweepCodeBinding;
import net.yhkj.mvvmdemo.ui.sweep_code.code_result.SweepResultActivity;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.KLog;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.sweep_code.SweepCodeActivity
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/26
 * 描述：
 */
public class SweepCodeActivity extends BaseActivity<ActivitySweepCodeBinding,SweepCodeViewModel> implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private String TAG=">>>>>";

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_sweep_code;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        mScannerView = binding.scannerView;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Bundle bundle = new Bundle();
        bundle.putString("DATA",rawResult.getText());
        startActivity(SweepResultActivity.class,bundle);
        ToastUtils.showShort(rawResult.getText().toString());
        KLog.v(TAG, rawResult.getText()); // Prints scan results
        KLog.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
    }
}
