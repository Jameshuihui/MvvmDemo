package net.yhkj.mvvmdemo.ui.sweep_code.code_result;

import android.content.Intent;
import android.os.Bundle;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.ActivitySwCodeResultBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.sweep_code.code_result.SweepResultActivity
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/26
 * 描述：
 */
public class SweepResultActivity extends BaseActivity<ActivitySwCodeResultBinding, SweepCodeResultViewModel> {
    private String result = "";

    @Override
    public void initParam() {
        super.initParam();
        Intent intent = getIntent();
        result = intent.getStringExtra("DATA");
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_sw_code_result;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        viewModel.observableResultField.set(result);
    }
}
