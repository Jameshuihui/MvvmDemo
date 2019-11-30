package net.yhkj.mvvmdemo.ui.update;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;

import com.xuexiang.xupdate.entity.PromptEntity;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.proxy.IUpdateHttpService;
import com.xuexiang.xupdate.proxy.IUpdateProxy;
import com.xuexiang.xupdate.service.OnFileDownloadListener;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentUpdateBinding;
import net.yhkj.mvvmdemo.dialog.CustomUpdatePrompter;
import net.yhkj.mvvmdemo.dialog.UpdateDialog;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.update.UpadteFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/29
 * 描述：
 */
public class UpadteFragment extends BaseFragment<FragmentUpdateBinding,UpdateViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_update;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        viewModel.initData();
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.uc.showForceUpdate.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                ToastUtils.showLongSafe("更新一下");
                showUpdate1Dialog();
            }
        });
    }

    private void showUpdate1Dialog() {
        UpdateDialog dialog= new UpdateDialog(getContext());
        dialog.show();
    }
}
