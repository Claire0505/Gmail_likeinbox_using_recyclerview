package com.admin.claire.gmaillikeinbox_using_recyclerview.helper;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;

import com.admin.claire.gmaillikeinbox_using_recyclerview.R;

/**
 * Created by claire on 2017/9/20.
 * 這個類有一個執行翻轉動畫的靜態方法 flipView()
 */

public class FlipAnimator {
    private static String TAG = FlipAnimator.class.getSimpleName();
    private static AnimatorSet leftIn, rightOut, leftOut, rightIn;

    /**
     * Performs flip animation on two views
     * @param context 上下文
     * @param back 後面
     * @param front 前面
     * @param showFront
     */
    public static void flipView(Context context, final View back, final View front,
                                boolean showFront){
        leftIn = (AnimatorSet)AnimatorInflater.loadAnimator(context,R.animator.card_flip_left_in);
        rightOut = (AnimatorSet)AnimatorInflater.loadAnimator(context,R.animator.card_flip_right_out);
        leftOut = (AnimatorSet)AnimatorInflater.loadAnimator(context,R.animator.card_flip_left_out);
        rightIn = (AnimatorSet)AnimatorInflater.loadAnimator(context,R.animator.card_flip_right_in);

        final AnimatorSet showFrontAnim = new AnimatorSet();
        final AnimatorSet showBackAnim = new AnimatorSet();

        leftIn.setTarget(back);
        rightOut.setTarget(front);
        showFrontAnim.playTogether(leftIn, rightOut);

        leftOut.setTarget(back);
        rightIn.setTarget(front);
        showBackAnim.playTogether(rightIn,leftOut);

        if (showFront){
            showFrontAnim.start();
        }else {
            showBackAnim.start();
        }
    }
}
