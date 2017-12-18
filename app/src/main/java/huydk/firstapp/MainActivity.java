package huydk.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener{

    EditText txtNumberA,txtNumberB;
    Button btnSub;
    Button btnNhan;
    Button btnChia;
    Button btnHide,btnThoat;

    View.OnClickListener suKienChiase = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                xuLyPhepTru();
            }
        });

        suKienChiase = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnNhan){
                    xuLyPhepNhan();
                } else if (view.getId() == R.id.btnChia) {
                    xulyPhepChia();
                }
            }
        };

        btnNhan.setOnClickListener(suKienChiase);
        btnChia.setOnClickListener(suKienChiase);
        btnHide.setOnLongClickListener(this);
        btnThoat.setOnClickListener(new MyEvent());
    }

    private void xulyPhepChia() {
        int a = Integer.parseInt(txtNumberA.getText().toString());
        int b = Integer.parseInt(txtNumberB.getText().toString());
        int c = a/b;

        Toast.makeText(MainActivity.this,"Chia ="+c,Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepNhan() {
        int a = Integer.parseInt(txtNumberA.getText().toString());
        int b = Integer.parseInt(txtNumberB.getText().toString());
        int c = a/b;

        Toast.makeText(MainActivity.this,"Nhan ="+c,Toast.LENGTH_LONG).show();

    }

    private void xuLyPhepTru() {
        int a = Integer.parseInt(txtNumberA.getText().toString());
        int b = Integer.parseInt(txtNumberB.getText().toString());
        int c = a-b;

        Toast.makeText(MainActivity.this,"Hiệu = "+c,Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        txtNumberA = (EditText) findViewById(R.id.txtNumberA);
        txtNumberB = (EditText) findViewById(R.id.txtNumberB);
        btnSub = findViewById(R.id.btnSub);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnHide = findViewById(R.id.btnHide);
        btnThoat = findViewById(R.id.btnThoat);
    }

    public void xuLyPhepCong(View v){
        int a = Integer.parseInt(txtNumberA.getText().toString());
        int b = Integer.parseInt(txtNumberB.getText().toString());
        int c = a+b;

        Toast.makeText(MainActivity.this,"Tổng ="+c,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId() == R.id.btnHide){
            btnHide.setVisibility(View.INVISIBLE);
        }
        return false;
    }

    public class MyEvent  implements View.OnLongClickListener,View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btnThoat){
                finish();
            }
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public void xuLyDoiManHinhKhac(View view){
        Button btnMoi;
        btnMoi = new Button(MainActivity.this);
        {

        };
    }
}
