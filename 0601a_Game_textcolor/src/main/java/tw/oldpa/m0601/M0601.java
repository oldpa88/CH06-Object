package tw.oldpa.m0601;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class M0601 extends AppCompatActivity {
    // ----宣告變數----
    private TextView txtComPlay, txtSelect, txtResult;
    private Button btnScissors, btnStone, btnNet;
    private String user_select;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0601);
        setupViewComponent();
    }

    private void setupViewComponent() {
        // ---取得R.java 配置碼---
        txtComPlay = (TextView) findViewById(R.id.m0601_c001); // 電腦選擇
        txtSelect = (TextView) findViewById(R.id.m0601_s001); // 選擇結果
        txtResult = (TextView) findViewById(R.id.m0601_f000); // 輸贏判斷

        btnScissors = (Button) findViewById(R.id.m0601_b001); // 剪刀
        btnStone = (Button) findViewById(R.id.m0601_b002); // 石頭
        btnNet = (Button) findViewById(R.id.m0601_b003); // 布

        // ---啟動監聽事件----
        btnScissors.setOnClickListener(btn01On);
        btnStone.setOnClickListener(btn01On);
        btnNet.setOnClickListener(btn01On);
    }
    private Button.OnClickListener btn01On = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            int      iComPlay = (int) (Math.random() * 3 + 1);
            // 1 - scissors, 2 - stone, 3 - net.
            switch (v.getId()) {
                case R.id.m0601_b001:
                    // 選擇 剪刀scissors
                    user_select=getString(R.string.m0601_s001)+" "+getString(R.string.m0601_b001);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setText(R.string.m0601_b001);
                            answer=getString(R.string.m0601_f000) + getString(R.string.m0601_f003); // 平
                            txtResult.setTextColor(Color.YELLOW); // 平用黃顯示
                        case 2:
                            txtComPlay.setText(R.string.m0601_b002);
                            answer=getString(R.string.m0601_f000) + getString(R.string.m0601_f002); // 輸
                            txtResult.setTextColor(Color.RED); // 輸用紅顯示
                            break;
                        case 3:
                            txtComPlay.setText(R.string.m0601_b003);
                            answer=getString(R.string.m0601_f000) + getString(R.string.m0601_f001); // 贏
                            txtResult.setTextColor(Color.GREEN); // 贏用綠顯示
                            break;
                    }

                    break;
                //----------------------------------------------
                case R.id.m0601_b002:
                    // 選擇 石頭stone
                    user_select=getString(R.string.m0601_s001)+" "+getString(R.string.m0601_b002);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setText(R.string.m0601_b001);
                            answer=getString(R.string.m0601_f000)+ getString(R.string.m0601_f001); // 贏
                            txtResult.setTextColor(Color.GREEN); // 贏用綠顯示
                            break;
                        case 2:
                            txtComPlay.setText(R.string.m0601_b002);
                            answer=getString(R.string.m0601_f000) + getString(R.string.m0601_f003); // 平
                            txtResult.setTextColor(Color.YELLOW); // 平用黃顯示
                            break;
                        case 3:
                            txtComPlay.setText(R.string.m0601_b003);
                            answer=getString(R.string.m0601_f000) + getString(R.string.m0601_f002); // 輸
                            txtResult.setTextColor(Color.RED); // 輸用紅顯示
                            break;
                    }
                    break;
                //---------------------------------------------
                case R.id.m0601_b003:
                    // 選擇 布net
                    user_select=getString(R.string.m0601_s001)+" "+getString(R.string.m0601_b003);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setText(R.string.m0601_b001);
                            answer=getString(R.string.m0601_f000) + getString(R.string.m0601_f002); // 輸
                            txtResult.setTextColor(Color.RED); // 輸用紅顯示
                            break;
                        case 2:
                            txtComPlay.setText(R.string.m0601_b002);
                            answer=getString(R.string.m0601_f000) + getString(R.string.m0601_f001); // 贏
                            txtResult.setTextColor(Color.GREEN); // 贏用綠顯示
                            break;
                        case 3:
                            txtComPlay.setText(R.string.m0601_b003);
                            answer=getString(R.string.m0601_f000) + getString(R.string.m0601_f003); // 平
                            txtResult.setTextColor(Color.YELLOW); // 平用黃顯示
                            break;
                    }
                    break;
            }
            txtSelect.setText(user_select);
            txtResult.setText(answer);
            }
    };
}
