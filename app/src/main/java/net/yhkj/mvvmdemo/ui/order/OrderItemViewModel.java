package net.yhkj.mvvmdemo.ui.order;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import net.yhkj.mvvmdemo.entity.response.OrderResponse;

import me.goldze.mvvmhabit.base.ItemViewModel;

/**
 * 文件名：net.yhkj.mvvmdemo.ui.order.OrderItemViewModel
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/9/12
 * 描述：
 */
public class OrderItemViewModel extends ItemViewModel<OrderViewModel> {
    public ObservableField<OrderResponse> entity=new ObservableField<>();

    public OrderItemViewModel(@NonNull OrderViewModel viewModel, ObservableField<OrderResponse> entity) {
        super(viewModel);
        this.entity = entity;
    }
}
