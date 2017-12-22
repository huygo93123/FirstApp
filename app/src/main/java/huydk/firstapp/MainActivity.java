package huydk.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtName,txtSoNgay;
    Button btnXacNhan;
    ArrayList<String>arrCongViec;

    Spinner spThu;
    ListView lsCongTac;
    ArrayList<String>dsThu;
    ArrayAdapter<String>adapterThu;
    ArrayAdapter<String>adapterNhanVien;

    int lastSelected = -1 ;
    
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
                xuLyXacNhanCongTac();
            }
        });
        spThu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Bạn chon " + dsThu.get(i),Toast.LENGTH_SHORT).show();
                lastSelected = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void xuLyXacNhanCongTac() {
        if (lastSelected == -1)
        {
            Toast.makeText(MainActivity.this,"Chưa chọn thứ",Toast.LENGTH_SHORT).show();
            return;
        }
        NhanVien nv = new NhanVien();
        nv.setTenNhanVien(txtName.getText().toString());
        nv.setThuBatDauCongTac(dsThu.get(lastSelected));
        nv.setSoNgayDuKienCongTac(Integer.parseInt(txtSoNgay.getText().toString()));

        //save list
        arrCongViec.add(nv.toString());
        adapterNhanVien.notifyDataSetChanged();

        Toast.makeText(MainActivity.this,nv.toString(),Toast.LENGTH_SHORT).show();
    }

    private void addControls() {
        txtName = findViewById(R.id.txtName);
        txtSoNgay = findViewById(R.id.txtNgayCongTac);

        btnXacNhan = findViewById(R.id.btnXacNhan);
        spThu = findViewById(R.id.spThu);

        lsCongTac = findViewById(R.id.lsCongTac);
        dsThu = new ArrayList<>();
        arrCongViec = new ArrayList<String>();


        dsThu.add("Thứ 2");dsThu.add("Thứ 3");dsThu.add("Thứ 4");dsThu.add("Thứ 5");dsThu.add("Thứ 6");dsThu.add("Thứ 7");dsThu.add("Thứ 8");
        adapterThu = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,dsThu);
        adapterThu.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spThu.setAdapter(adapterThu);

        adapterNhanVien = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arrCongViec);
        lsCongTac.setAdapter(adapterNhanVien);
    }

}
