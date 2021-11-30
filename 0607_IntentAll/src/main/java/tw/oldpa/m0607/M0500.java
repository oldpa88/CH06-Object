package tw.oldpa.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class M0500 extends AppCompatActivity {

    //宣告變數
    private EditText e001;
    private Button b001;
    private TextView t003;
    private String mode_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        // 設定class標題
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        //
        e001 = (EditText) findViewById(R.id.m0500_e001); //公斤kg 輸入的欄位變數名稱
        b001 = (Button) findViewById(R.id.m0500_b001); //執行按鈕變數名稱
        t003 = (TextView) findViewById(R.id.m0500_t003); //磅lb 欄位變數名稱

        // --宣告傾聽--
        b001.setOnClickListener(b001ON);

    }

    private Button.OnClickListener b001ON = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            DecimalFormat pondsFormat = new DecimalFormat(".#####");

            String outcome = pondsFormat.format(Float.parseFloat(e001
                    .getText().toString()) * 2.20462262);
            t003.setText(outcome);
        }
    };

}
