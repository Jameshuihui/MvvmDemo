package net.yhkj.mvvmdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import net.yhkj.mvvmdemo.R;
import net.yhkj.mvvmdemo.view.HorizontalProgressBarWithNumber;


/**
 * Created by ZouHui on 2017/2/12.
 */
public class WineUpdateDialog extends Dialog {
    public Button btu_on;
    public Button btu_off;
    public HorizontalProgressBarWithNumber progress;
    public LinearLayout bottom;
    public ConstraintLayout llUpdateContent;
    public TextView tvUpContent,tvSize,tvVersionNo;
    public View v1,v2,v3;

    public WineUpdateDialog(Context context) {
        super(context, R.style.MyProgressDialog);
        this.setContentView(R.layout.dialog_update);

        btu_on = (Button) findViewById(R.id.btu_on);
        btu_off = (Button) findViewById(R.id.btu_off);
        progress = (HorizontalProgressBarWithNumber) findViewById(R.id.progress);
        bottom = (LinearLayout) findViewById(R.id.bottom);
        llUpdateContent = (ConstraintLayout) findViewById(R.id.ll_update_content);
        tvUpContent = (TextView) findViewById(R.id.tv_update_content);
        tvUpContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        tvSize = findViewById(R.id.tv_size);
        tvVersionNo = findViewById(R.id.tv_version_no);
//        ll = (LinearLayout) findViewById(R.id.ll);
        v2  = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);
    }
}
