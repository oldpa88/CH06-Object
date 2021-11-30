package tw.oldpa.m0609;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;


public class M0502p extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m05_la1);
//---------------------------------------------------------------------------------------------
        final TextView myTextView = (TextView) findViewById(R.id.myTextView);    //文字框變數
        final EditText myEditText = (EditText) findViewById(R.id.editText1);    //編輯框物件
        final Button bt1 = (Button) findViewById(R.id.button1);
        DatePicker myDatePicker = (DatePicker) findViewById(R.id.datePicker1);            //取得物件
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker1);        //取得物件
        //----------------------------------------
        Intent intent = this.getIntent();
        int mode_sel = intent.getIntExtra("ap_se", 0);
        String mode_title = intent.getStringExtra("appname");
        this.setTitle(this.getResources().getIdentifier(mode_title, "string",
                getCallingPackage()));
        final Window bg = getWindow();                                //取得視窗物件
        OnClickListener listener = null;                                    //宣告監聽器
        OnLongClickListener longlistener;                                //長按監聽器
        //---------------------------------------------------------------------------------------------
        switch (mode_sel) {
            case 1:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                //--------------------------------------------
                bt1.setOnClickListener(listener = new OnClickListener() {                //設定監聽器
                    @Override
                    public void onClick(View v) {
                        Resources res = getResources();                        //資源
                        Drawable drawable = res.getDrawable(R.drawable.white);
                        bg.setBackgroundDrawable(drawable);                    //設定背景圖片
                        myTextView.setTextColor(Color.RED);                    //設定字型彩色
                        myTextView.setText("背景已經設定為白色！");                //設定文字
                    }
                });
                break;

            case 2:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                //--------------------------------------------
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                //----------------------------------------
                OnFocusChangeListener focuslistener;                                //監聽器
                bt1.setOnLongClickListener(longlistener = new OnLongClickListener() {    //設定監聽器
                    @Override
                    public boolean onLongClick(View v) {
                        bt1.setBackgroundColor(Color.RED);                    //設定按鈕的背景色
                        bt1.setTextColor(Color.BLACK);                        //設定按鈕字型彩色
                        bt1.setText("執行了長按按鈕的動作！");                    //設定按鈕文字
                        myTextView.setText("長按按鈕改變了按鈕的彩色！");
                        return false;
                    }
                });
                break;

            case 3:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                //--------------------------------------------
                bt1.setOnFocusChangeListener(focuslistener = new OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {                //設定監聽器動作
                        if (hasFocus)                                            //判斷是否獲得焦點
                        {
                            Toast.makeText(getApplicationContext(), "按鈕獲得焦點！", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "按鈕失去焦點！", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;

            case 4:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                //--------------------------------------------
                bt1.setOnTouchListener(new View.OnTouchListener() {                //設定觸摸監聽器
                    int px;                                                //觸摸點的x座標
                    int py;                                                //觸摸點的y座標

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {            //多載onTouch方法
                        // TODO Auto-generated method stub
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:                    //觸摸按下
                                px = (int) event.getX();
                                py = (int) event.getY();
                                myTextView.setText("px=" + px + ";py=" + py);
                                break;
                            case MotionEvent.ACTION_MOVE:                    //觸摸搬移
                                //ViewGroup.LayoutParams lp=new AbsoluteLayout.LayoutParams(-2, -2, (int)event.getRawX()-px-4, (int)event.getRawY()-py-52);
                                //bt1.setLayoutParams(lp);
                                px = (int) event.getX();
                                py = (int) event.getY();
                                myTextView.setText("目前觸摸點的座標為：px=" + px + "，py=" + py);
                        }
                        return false;
                    }
                });
                break;

            case 5:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                //--------------------------------------------
                bt1.setPressed(true);                                        //設定按下狀態。
                break;

            case 6:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                //--------------------------------------------
                bt1.setOnClickListener(listener = new OnClickListener() {                //設定監聽器
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Resources res = getResources();                        //資源
                        Drawable drawable = res.getDrawable(R.drawable.white);
                        bg.setBackgroundDrawable(drawable);                    //設定背景圖片
                        myTextView.setTextColor(Color.RED);                    //設定字型彩色
                        myTextView.setText("背景已經設定為白色！");                //設定文字
                    }
                });
                bt1.setClickable(false);
                break;

            case 7:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                //--------------------------------------------
                bt1.setOnLongClickListener(longlistener = new OnLongClickListener() {    //設定監聽器

                    @Override
                    public boolean onLongClick(View v) {
                        bt1.setBackgroundColor(Color.RED);                    //設定按鈕的背景色
                        bt1.setTextColor(Color.BLACK);                        //設定按鈕字型彩色
                        bt1.setText("執行了長按按鈕的動作！");                    //設定按鈕文字
                        myTextView.setText("長按按鈕改變了按鈕的彩色！");
                        return false;
                    }
                });
                bt1.setLongClickable(false);
                break;

        }
    }
}