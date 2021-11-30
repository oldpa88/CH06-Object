package tw.oldpa.m0602;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class M0602 extends AppCompatActivity {

    // ----宣告變數----
    private ImageView txtComPlay;
    private TextView txtSelect, txtResult;
    private ImageButton btnScissors, btnStone, btnNet;
    private String user_select;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0602);
        setupViewComponent();
    }

    private void setupViewComponent() {
        // ---取得R.java 配置碼---
        txtComPlay = (ImageView) findViewById(R.id.m0602_c001); // 電腦選擇
        txtSelect = (TextView) findViewById(R.id.m0602_s001); // 選擇結果
        txtResult = (TextView) findViewById(R.id.m0602_f000); // 輸贏判斷
        btnScissors = (ImageButton) findViewById(R.id.m0602_b001); // 剪刀
        btnStone = (ImageButton) findViewById(R.id.m0602_b002); // 石頭
        btnNet = (ImageButton) findViewById(R.id.m0602_b003); // 布

        // ---啟動監聽事件----
        btnScissors.setOnClickListener(btn01On);
        btnStone.setOnClickListener(btn01On);
        btnNet.setOnClickListener(btn01On);
    }
    private Button.OnClickListener btn01On = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1);
            switch (iComPlay) {
                case 1: //電腦:剪刀scissors
                    user_select = getString(R.string.m0602_s002) + getString(R.string.m0602_b001) + " ";
                    txtComPlay.setImageResource(R.drawable.scissors); // 轉換ImageView剪刀
                    break;
                case 2: //電腦:石頭stone
                    user_select = getString(R.string.m0602_s002) + getString(R.string.m0602_b002) + " ";
                    txtComPlay.setImageResource(R.drawable.stone); // 轉換ImageView石頭
                    break;
                case 3: // 電腦:布net
                    user_select = getString(R.string.m0602_s002) + getString(R.string.m0602_b003) + " ";
                    txtComPlay.setImageResource(R.drawable.net); // 轉換ImageView布
                    break;
            }
            // 1 - scissors, 2 - stone, 3 - net.
            switch (v.getId()) {
                case R.id.m0602_b001:  // 選擇 剪刀scissors
                    user_select += getString(R.string.m0602_s001) + getString(R.string.m0602_b001);
                    u_setalpha();
                    btnScissors.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Red));
                    btnScissors.getBackground().setAlpha(150);
                    switch (iComPlay) {
                        case 1: //電腦:剪刀scissors
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f003); // 平
                            txtResult.setTextColor(getResources().getColor(R.color.Yellow)); // 平用黃顯示
                            break;
                        case 2: //電腦:石頭stone
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f002); // 輸
                            txtResult.setTextColor(getResources().getColor(R.color.Red)); // 輸用紅顯示
                            break;
                        case 3: // 電腦:布net
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f001); // 贏
                            txtResult.setTextColor(getResources().getColor(R.color.Lime)); // 贏用綠顯示
                            break;
                    }

                    break;
                //----------------------------------------------
                case R.id.m0602_b002:          // 選擇 石頭stone
                    user_select += getString(R.string.m0602_s001) + getString(R.string.m0602_b002);
                    u_setalpha();
                    btnStone.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Red));
                    btnStone.getBackground().setAlpha(150);
                    switch (iComPlay) {
                        case 1: //電腦:剪刀scissors
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f001); // 贏
                            txtResult.setTextColor(getResources().getColor(R.color.Lime)); // 贏用綠顯示
                            break;
                        case 2: //電腦:石頭stone
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f003); // 平
                            txtResult.setTextColor(getResources().getColor(R.color.Yellow)); // 平用黃顯示
                            break;
                        case 3: // 電腦:布net
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f002); // 輸
                            txtResult.setTextColor(getResources().getColor(R.color.Red)); // 輸用紅顯示
                            break;
                    }
                    break;
                //---------------------------------------------
                case R.id.m0602_b003:        // 選擇 布net
                    user_select += getString(R.string.m0602_s001) + getString(R.string.m0602_b003);
                    u_setalpha();
                    btnNet.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.Red));
                    btnNet.getBackground().setAlpha(150);
                    switch (iComPlay) {
                        case 1: //電腦:剪刀scissors
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f002); // 輸
                            txtResult.setTextColor(getResources().getColor(R.color.Red)); // 輸用紅顯示
                            break;
                        case 2: //電腦:石頭stone
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f001); // 贏
                            txtResult.setTextColor(getResources().getColor(R.color.Lime)); // 贏用綠顯示
                            break;
                        case 3: // 電腦:布net
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f003); // 平
                            txtResult.setTextColor(getResources().getColor(R.color.Yellow)); // 平用黃顯示
                            break;
                    }
                    break;
            }
            txtSelect.setText(user_select);
            txtResult.setText(answer);
        }
    };

    private void u_setalpha() {
        btnScissors.getBackground().setAlpha(0);
        btnStone.getBackground().setAlpha(0);
        btnNet.getBackground().setAlpha(0);
        btnScissors.setBackgroundColor(ContextCompat.getColor(this, R.color.Black));
        btnStone.setBackgroundColor(ContextCompat.getColor(this, R.color.Black));
        btnNet.setBackgroundColor(ContextCompat.getColor(this, R.color.Black));
    }
}
