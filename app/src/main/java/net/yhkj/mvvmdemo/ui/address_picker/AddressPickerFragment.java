package net.yhkj.mvvmdemo.ui.address_picker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.FragmentAddressPickerBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.address_picker.AddressPickerFragment
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/11/19
 * 描述：
 */
public class AddressPickerFragment extends BaseFragment<FragmentAddressPickerBinding, AddressPickerViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_address_picker;
    }

    @Override
    public int initVariableId() {
        return net.yhkj.mvvmdemo.BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        binding.address.setTabAmount(3);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.showAddressDialogEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                showAddressPickDialog();
            }
        });
    }

    private void showAddressPickDialog() {

    }
}
