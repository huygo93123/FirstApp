package huydk.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton radHinh1,radHinh2;
    ImageView imgHinh;
    ImageButton btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        radHinh1 = findViewById(R.id.radHinh1);
        radHinh2 = findViewById(R.id.radHinh2);
        imgHinh = findViewById(R.id.imgHinh);
        btnThoat = findViewById(R.id.btnThoat);
    }

    private void addEvents() {
        radHinh2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    imgHinh.setImageResource(R.drawable.f419ce99c915254b7c04);
                }
            }
        });

        radHinh1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    imgHinh.setImageResource(R.drawable.ellemanvn);
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
