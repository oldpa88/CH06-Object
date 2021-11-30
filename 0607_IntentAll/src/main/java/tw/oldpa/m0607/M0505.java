package tw.oldpa.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0505 extends AppCompatActivity {
    // ==============宣告變數===============
    private Button b001, b002;
    private AutoCompleteTextView e001;
    private ArrayAdapter<String> adapAutoCompText;

    // =============================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0505);
        setupViewComponent();
    }

    private void setupViewComponent() {

        // 設定class標題
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        // 從資源類別R中取得介面元件
        b001 = (Button) findViewById(R.id.m0505_b001);
        b002 = (Button) findViewById(R.id.m0505_b002);
        e001 = (AutoCompleteTextView) findViewById(R.id.m0505_a001);

        adapAutoCompText = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line);

        e001.setAdapter(adapAutoCompText);
        // --宣告傾聽--
        b001.setOnClickListener(b001On); // 加入自動完成文字
        b002.setOnClickListener(b002On); // 清除自動完成文字
    }
    // -----加入自動完成文字事件-----------------------------------------------
    private Button.OnClickListener b001On = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            String s = e001.getText().toString();
            adapAutoCompText.add(s);
            e001.setText("");
        }
    };
    // -----清除自動完成文字事件------------------------------------------
    private Button.OnClickListener b002On = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            adapAutoCompText.clear();
        }
    };
}
