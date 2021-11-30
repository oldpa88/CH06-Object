package tw.oldpa.m0609;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class M0501p extends AppCompatActivity {
    private TextView myTextView, name;
    private EditText myEditText;
    private DatePicker myDatePicker;
    private TimePicker timePicker;
    private Button bt1;// = null;// 宣告按鈕變數

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m05);
        // ---------------------------------------------------------------------------------------------
        OnClickListener listener = null;// 宣告監聽器
        LinearLayout m05_layout = (LinearLayout) findViewById(R.id.M05layout);
        myTextView = new TextView(this);
        m05_layout.addView(myTextView);
        myEditText = new EditText(this);
        m05_layout.addView(myEditText);
        myDatePicker = new DatePicker(this);
        m05_layout.addView(myDatePicker);
        timePicker = new TimePicker(this);
        m05_layout.addView(timePicker);
        bt1 = new Button(this);
        m05_layout.addView(bt1);

//--------------------------------------
        name = new TextView(this);
        name.setText(getString(R.string.myname));
        name.setGravity(Gravity.START);
        name.setTextColor(getResources().getColor(R.color.Yellow));
        m05_layout.addView(name);

        // ----------------------------------------
        Intent intent = this.getIntent();
        int mode_sel = intent.getIntExtra("ap_se", 0);
        String mode_title = intent.getStringExtra("appname");
        this.setTitle(this.getResources().getIdentifier(mode_title, "string",
                getPackageName()));

        switch (mode_sel) {
            case 1:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.INVISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // --------------------------------------------
                myTextView.append("12345"); // 採用第一種模式追加文字
                myTextView.append("ABCDEFGH", 2, 5); // 採用第二種模式追加文字
                break;

            case 2:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.INVISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // --------------------------------------------
                myTextView.append("12345"); // 採用第一種模式追加文字
                myTextView.append("ABCDEFGH", 2, 5); // 採用第二種模式追加文字
                myTextView.addTextChangedListener(new TextWatcher() { // 加入監聽器
                    @Override
                    public void afterTextChanged(Editable s) { // 文字改變後
                    }

                    @Override
                    public void beforeTextChanged(CharSequence s,
                                                  int start, int count, int after) {
                        //文字改變前
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start,
                                              int before, int count) {
                        //文字改變時
                        Toast.makeText(
                                getApplicationContext(),
                                "原字串共" + String.valueOf(before) + "個字元。"
                                        + "從第" + String.valueOf(start)
                                        + "個字元開始變更為字串：" + s + "。共"
                                        + String.valueOf(count) + "字元。",
                                Toast.LENGTH_LONG).show(); // 顯示提示訊息
                    }
                });
                myTextView.setText("1234567890"); // 重設文字內容
                break;

            case 3:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                // myTextView=(TextView)findViewById(R.id.myTextView); //取得物件
                myTextView.setText("setText方法：\r\n"
                        + "       "
                        + "該方法用於設定一個TextView文字框的顯示內容，可以直接給予值一個字串，也可以透過資源ID的模式來參考。該方法是設定文字框顯示文字的最常用的方法。"); // 設定顯示內容
                break;

            case 4:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                myTextView.setText("setTextSize方法：\r\n" + "       " + "該方法用於設定一個TextView文字框顯示內容的字型，可以透過指定單位和字型數值大小，也可以直接指定sp（scaled pixel）單位的字型大小。該方法是設定文字框顯示文字字型大小的最常用的方法。"); // 設定內容
                myTextView.setTextSize(30); // 設定字型
                break;

            case 5:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                myTextView.setText("setTextColor方法：\r\n"
                        + "       "
                        + "該方法用於設定一個TextView文字框顯示內容的字型彩色，可以透過XML檔案的彩色狀態清單來設定，或是直接指定彩色值。該方法是設定文字框顯示文字彩色的最常用的方法。"); // 設定文字內容
                myTextView.setTextSize(30); // 設定字型大小
                myTextView.setTextColor(Color.RED); // 設定字型彩色
                // 設定字型
                break;

            case 6:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                myTextView
                        .setText("setTypeface方法：\r\n"
                                + "       "
                                + "該方法用於設定一個TextView文字框顯示內容的字型型態，可以指定系統附帶的字型，也可以使用自訂的字型。該方法是設定文字框顯示文字字型的最常用的方法。"); // 設定文字內容
                myTextView.setTextSize(30); // 設定字型大小
                myTextView.setTextColor(Color.RED); // 設定彩色
                myTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD); // 設定字型型態
                break;

            case 7:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                myTextView
                        .setText("setBackgroundColor方法：\r\n"
                                + "       "
                                + "該方法用於設定一個TextView文字框的背景彩色，一般透過直接設定彩色值來表示。該方法是設定文字框背景色的最常用的方法。"); // 設定文字
                myTextView.setTextSize(30); // 設定字型大小
                myTextView.setTextColor(Color.RED); // 設定字型彩色
                myTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD); // 設定字型型態
                myTextView.setBackgroundColor(Color.WHITE); // 設定背景彩色
                break;

            case 8:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                myTextView.setText("setHeight方法：\r\n" + "       "
                        + "該方法用於設定一個TextView文字框的高度，單位是pt。一般用於設定和變更文字框大小的場合。");
                myTextView.setTextSize(30); // 設定字型大小
                myTextView.setTextColor(Color.RED); // 設定字型彩色
                myTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD); // 設定字型型態
                myTextView.setBackgroundColor(Color.WHITE); // 設定背景彩色
                myTextView.setHeight(500); // 設定文字框高度
                break;

            case 9:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.INVISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                myTextView.setText("取得TextView的參數訊息！"); // 設定文字
                myTextView.setTextColor(Color.BLUE); // 設定字型彩色
                System.out.println("字型的彩色是" + myTextView.getCurrentTextColor()); // 取得字型彩色
                break;

            case 10:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.INVISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                myTextView.setText("取得TextView的參數訊息！"); // 設定文字內容
                System.out.println("文字框的內容為：" + myTextView.getText()); // 取得文字框的內容
                break;

            case 11:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------

                myTextView.setText("取得TextView的參數訊息！"); // 設定文字
                bt1.setOnClickListener(listener = new OnClickListener() { // 設定監聽器
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getApplicationContext(),
                                "文字框的高度為：" + myTextView.getHeight(),
                                Toast.LENGTH_LONG).show(); // 顯示訊息
                    }
                });
                break;

            case 12:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                myTextView.setText("取得TextView的參數訊息！"); // 設定文字
                bt1.setOnClickListener(listener = new OnClickListener() { // 設定監聽器
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getApplicationContext(),
                                "文字框的寬度為：" + myTextView.getWidth(),
                                Toast.LENGTH_LONG).show(); // 顯示訊息
                    }
                });
                break;

            case 13:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.INVISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                myTextView.setText("setPadding方法：\r\n" + "       "
                        + "該方法用於設定一個TextView文字框的內邊距，單位是pt。一般用於自訂文字框顯示型態的場合。");
                myTextView.setTextSize(30); // 設定字型大小
                myTextView.setTextColor(Color.RED); // 設定字型彩色
                myTextView.setBackgroundColor(Color.WHITE); // 設定背景彩色
                myTextView.setPadding(35, 35, 35, 35); // 設定文字框內邊距
                break;

            case 14:
            case 15:
            case 16:
            case 17:
                myTextView.setVisibility(View.VISIBLE);
                myEditText.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.INVISIBLE);
                myDatePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                // ---------------------------------------------------------------------------------------------
                myTextView.setText("setPadding方法：\r\n" + "       "
                        + "該方法用於設定一個TextView文字框的內邊距，單位是pt。一般用於自訂文字框顯示型態的場合。");
                myTextView.setTextSize(30); // 設定字型大小
                myTextView.setTextColor(Color.RED); // 設定字型彩色
                myTextView.setBackgroundColor(Color.WHITE); // 設定背景彩色
                myTextView.setPadding(35, 50, 35, 50); // 設定內邊距
                System.out.println("文字框左側內邊距為：" + myTextView.getPaddingLeft()); // 取得左側內邊距
                System.out.println("文字框上部內邊距為：" + myTextView.getPaddingTop()); // 取得上部內邊距
                System.out.println("文字框右側內邊距為：" + myTextView.getPaddingRight()); // 取得右側內邊距
                System.out.println("文字框下部內邊距為：" + myTextView.getPaddingBottom()); // 取得下部內邊距
                break;
        }
        // /---------------- end switch -----------
    }
}