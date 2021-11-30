package tw.oldpa.m0608b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class M0608 extends AppCompatActivity {

    // ---------宣告變數------------
    private Button btn01;
    private TextView txt01;
    // ------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0608);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        btn01 = (Button) findViewById(R.id.m0608_btn01);
        txt01 = (TextView) findViewById(R.id.m0608_txt001);
        // 設定 button 按鍵的事件
        btn01.setOnClickListener(btn01OnClick);
    }

    private Button.OnClickListener btn01OnClick = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            String ans01 = getString(R.string.m0608_txt01);
            try {
                for (int i = 1; i < 99; i++) {
                    String idName = "m0608_chb" + String.format("%02d", i);
                    int resID = getResources().getIdentifier(idName, "id", getPackageName());
                    CheckBox btn = ((CheckBox) findViewById(resID));
                    if (btn.isChecked()) ans01 += btn.getText().toString();
                }
            } catch (Exception e) {
                //xxxxxxxxxxxxxxxxxxxxxx
            }

            txt01.setText(ans01);
        }
    };
}
