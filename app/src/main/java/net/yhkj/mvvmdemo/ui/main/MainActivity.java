package net.yhkj.mvvmdemo.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.Manifest;
import android.os.Bundle;
import android.view.MotionEvent;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trello.rxlifecycle2.components.RxFragment;

import net.yhkj.mvvmdemo.BR;
import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.databinding.ActivityMainBinding;
import net.yhkj.mvvmdemo.minterface.OnParentTouchEvent;
import net.yhkj.mvvmdemo.ui.addcart.AddCartFragment;
import net.yhkj.mvvmdemo.ui.address_picker.AddressPickerFragment;
import net.yhkj.mvvmdemo.ui.bottomsheet.BottomSheetFragment;
import net.yhkj.mvvmdemo.ui.double_rv.DoubeRvFragment;
import net.yhkj.mvvmdemo.ui.drawiamge.DrawImageFragment;
import net.yhkj.mvvmdemo.ui.gallery.GalleryFragment;
import net.yhkj.mvvmdemo.ui.goods_detials.GoodsDetialsFragment;
import net.yhkj.mvvmdemo.ui.indicator.IndicatorFragment;
import net.yhkj.mvvmdemo.ui.money.MoneyFragment;
import net.yhkj.mvvmdemo.ui.mulist.MuListFragment;
import net.yhkj.mvvmdemo.ui.multiple_status.MultipleStatusFragment;
import net.yhkj.mvvmdemo.ui.rxbus.RxBusFragment;
import net.yhkj.mvvmdemo.ui.suction.SuctionTopFragment;
import net.yhkj.mvvmdemo.ui.sweep_code.SweepCodeActivity;

import io.reactivex.functions.Consumer;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {
    private OnParentTouchEvent onParentTouchEvent;

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
        onParentTouchEvent = new OnParentTouchEvent() {
            @Override
            public boolean dispatchTouchEvent(MotionEvent ev) {
                return false;
            }
        };
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
//                            ToastUtils.showShort("相机权限已经打开，直接跳入相机");
                        } else {
//                            ToastUtils.showShort("权限被拒绝");
                        }
                    }
                });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        onParentTouchEvent.dispatchTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
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
                    case 2:
                        //多布局
                        startContainerActivity(MuListFragment.class.getCanonicalName());
                        break;
                    case 3:
                        pickPhoto();
                        break;
                    case 4:
                        startContainerActivity(DoubeRvFragment.class.getCanonicalName());
                        break;
                    case 5:
                        startContainerActivity(GoodsDetialsFragment.class.getCanonicalName());
                        break;
                    case 6:
                        startContainerActivity(MultipleStatusFragment.class.getCanonicalName());
                        break;
                    case 7:
                        startContainerActivity(MoneyFragment.class.getCanonicalName());
                        break;
                    case 8:
                        startContainerActivity(RxBusFragment.class.getCanonicalName());
                        break;
                    case 9:
                        startContainerActivity(AddCartFragment.class.getCanonicalName());
                        break;
                    case 10:
                        startContainerActivity(GalleryFragment.class.getCanonicalName());
                        break;
                    case 11:
                        startContainerActivity(IndicatorFragment.class.getCanonicalName());
                        break;
                    case 12:
                        startContainerActivity(AddressPickerFragment.class.getCanonicalName());
                        break;
                    case 13:
                        startContainerActivity(DrawImageFragment.class.getCanonicalName());
                        break;
                    case 14:
                        startContainerActivity(BottomSheetFragment.class.getCanonicalName());
                        break;
                    case 15:
                        startContainerActivity(SuctionTopFragment.class.getCanonicalName());
                        break;

                }
            }
        });
    }

    private void pickPhoto() {
        PictureSelector.create(MainActivity.this)
                .openGallery(PictureMimeType.ofImage())
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }
}
