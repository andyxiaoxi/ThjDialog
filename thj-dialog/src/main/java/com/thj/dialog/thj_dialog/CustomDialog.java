package com.thj.dialog.thj_dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/10/17.
 *
 * 这个对话框具有一般性，可移植性
 */
public class CustomDialog {
    /**
     * 这个context ,可能为 service这种Context上下文的子类吗？,答：不能
     */
    private Context context;

    private AlertDialog dialog;

    private OnComfirmListener mComfirmListenner;

    private OnCancelListener mCancelListenner;
    /**下面的是对话框的属性*/
    private String title;

    private String message;


    public CustomDialog(Context context) {
        this.context = context;
    }

    //显示
    public void show(String title,String message){
        show(title,message,null);
    }

    public void show(String title,String message,OnComfirmListener comfirmListener){
        show(title,message,comfirmListener,null);
    }

    public void show(String title,String message,OnComfirmListener comfirmListener,OnCancelListener cancellistener){
        this.title = title;
        this.message = message;
        mComfirmListenner = comfirmListener;
        mCancelListenner = cancellistener;
        create();
    }
    /**
     * 创建对话框
     */
    private void create() {
        //为了使用自定义的布局，需要设置对话框的主题
        dialog= new AlertDialog.Builder(context,R.style.MyDialogStyle).show();
        //设置对话框
        WindowManager.LayoutParams p = dialog.getWindow().getAttributes();
        //dialog的布局
        View layout = View.inflate(context, R.layout.dialog_thj_layout,null);
        Log.e("lp","高："+p.height);
        Log.e("lp","宽："+p.width);
        Log.e("lp","type："+p.type);

        dialog.setContentView(layout);
        dialog.setCanceledOnTouchOutside(false);

        //填充对话框
        TextView title_tv = (TextView) layout.findViewById(R.id.title);
        TextView message_tv = (TextView) layout.findViewById(R.id.message);
        TextView comfirm_btn = (TextView) layout.findViewById(R.id.positiveButton);
        TextView cancel_btn = (TextView) layout.findViewById(R.id.negativeButton);


        if(!TextUtils.isEmpty(title)){
            title_tv.setText(title);
        }
        if(!TextUtils.isEmpty(message)){
            message_tv.setText(message);
        }
        //确认按钮的监听
        if(mComfirmListenner!=null){
            comfirm_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //确认按钮
                    mComfirmListenner.onClick(CustomDialog.this);
                }
            });
        }else{
            comfirm_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        //取消按钮的监听
        if(mCancelListenner!=null){
            cancel_btn.setVisibility(View.VISIBLE);
            cancel_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //取消
                    mCancelListenner.onClick(CustomDialog.this);
                }
            });
        }else{
            cancel_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        //设置对话框的宽和高
        WindowManager wm =dialog.getWindow().getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        Log.e("widown","宽=="+width+"----------高=="+height);
        p.height = (int) (height*0.35);
        p.width = (int) (width*0.7);
        p.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(p);
    }

    //销毁对话框
    public void dismiss(){
        dialog.dismiss();
        dialog = null;
    }

    /**
     * 对话框按钮点击监听
     */
    public interface OnComfirmListener{
        void onClick(CustomDialog dialog);
    }

    public interface OnCancelListener{
        void onClick(CustomDialog dialog);
    }
}
