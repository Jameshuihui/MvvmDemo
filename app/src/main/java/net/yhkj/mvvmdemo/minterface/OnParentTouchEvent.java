package net.yhkj.mvvmdemo.minterface;

import android.view.MotionEvent;

/**
 * 文件名：net.yhkj.mvvmdemo.minterface.OnParentTouchEvent
 * 创建者：MCeil
 * 邮箱：mceil_allin@163.com
 * 创建时间：2019/10/15
 * 描述：
 */
public interface OnParentTouchEvent {

    boolean dispatchTouchEvent(MotionEvent ev);
}
