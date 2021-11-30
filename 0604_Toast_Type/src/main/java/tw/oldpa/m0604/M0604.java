package tw.oldpa.m0604;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class M0604 extends AppCompatActivity {
    private Button b001;
    private Button b002;
    private Button b003;
    private Button b004;
    private Toast toast=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0604);
        setupViewComponent();
    }

    private void setupViewComponent() {
        // ---取得R.java 配置碼---
        b001 = (Button) findViewById(R.id.m0604_b001); // 默認
        b002 = (Button) findViewById(R.id.m0604_b002); // 自定義顯示位置
        b003 = (Button) findViewById(R.id.m0604_b003); // 帶圖片
        b004 = (Button) findViewById(R.id.m0604_b004); // 完全自定義

        b001.setOnClickListener(btoast);
        b002.setOnClickListener(btoast);
        b003.setOnClickListener(btoast);
        b004.setOnClickListener(btoast);
    }
    private Button.OnClickListener btoast = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            toast = null;
            switch (v.getId()) {
                case R.id.m0604_b001: // 默認 Toast
                    Toast.makeText(getApplicationContext(), getText(R.string.m0604_t001), Toast.LENGTH_LONG).show();
                    break;

                case R.id.m0604_b002: // 自定義顯示位置 Toast
                    toast = Toast.makeText(getApplicationContext(), getString(R.string.m0604_b002), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER|Gravity.START, 0, 0);
                    toast.show();
                    break;

                case R.id.m0604_b003: //帶圖片 Toast

                    toast = Toast.makeText(getApplicationContext(), getString(R.string.m0604_b003),Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.END, 0, 0);
                    //------------------------------------

                    LinearLayout toastView = (LinearLayout) toast.getView();
                    ImageView imageCodeProject = new ImageView(getApplicationContext());
                    imageCodeProject.setImageResource(R.drawable.ic_sample);
                    toastView.addView(imageCodeProject, 0);
                    //------------------------------------
                    toast.show();
                    break;

                case R.id.m0604_b004: //完全定義顯示位置 Toast
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom, (ViewGroup) findViewById(R.id.llToast));

                    ImageView image = (ImageView) layout.findViewById(R.id.tvImageToast);
                    TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
                    TextView text = (TextView) layout.findViewById(R.id.tvTextToast);

                    image.setImageResource(R.drawable.ic_sample);
                    title.setText(getString(R.string.m0604_t001).toString());
                    text.setText(getString(R.string.m0604_test).toString());
//-----------------------------------
                    toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.START | Gravity.TOP, 20, 40);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                    break;
            }
        }
    };
}
