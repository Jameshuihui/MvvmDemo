package net.yhkj.mvvmdemo.ui.shopcart;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.ItemViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.shopcart.ShopCartItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/12/5
 * 描述：
 */
public class ShopCartItemViewModel extends ItemViewModel<ShopCartViewModel> {

    public ShopCartItemViewModel(@NonNull ShopCartViewModel viewModel) {
        super(viewModel);
    }
}
