package huydk.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    AutoCompleteTextView autoTinhThanh;

    Button btnXacNhan;
    TextView txtThongTin;

    String []arrTinhThanh;

    ArrayAdapter<String>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXacNhanThongTin();
            }
        });
    }

    private void xuLyXacNhanThongTin() {
        String s = txtName.getText().toString() + "\n" + autoTinhThanh.getText().toString();
        txtThongTin.setText(s);
    }

    private void addControls() {
        txtName = findViewById(R.id.txtName);
        btnXacNhan = findViewById(R.id.btnXacNhan);
        txtThongTin = findViewById(R.id.txtThongTin);
        autoTinhThanh = findViewById(R.id.txtAutoCompelete);

        arrTinhThanh = getResources().getStringArray(R.array.DanhSachTinh);

        arrayAdapter= new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrTinhThanh
        );
        autoTinhThanh.setAdapter(arrayAdapter);
    }

}
