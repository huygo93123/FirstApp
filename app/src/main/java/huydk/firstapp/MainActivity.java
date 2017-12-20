package huydk.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.DanhBaAdapter;
import model.DanhBa;

public class MainActivity extends AppCompatActivity {

    ListView lvDanhBa;
    ArrayList<DanhBa>dsDanhBa;
    DanhBaAdapter danhBaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        lvDanhBa = findViewById(R.id.lvContact);
        dsDanhBa = new ArrayList<>();
        dsDanhBa.add(new DanhBa(1,"Nguyen Van Teo", "12234234"));
        dsDanhBa.add(new DanhBa(2,"Nguyen Mat Giac", "12234234"));
        dsDanhBa.add(new DanhBa(3,"Ho Chi Minh", "1221234"));

        danhBaAdapter = new DanhBaAdapter(MainActivity.this,R.layout.item,dsDanhBa);

        lvDanhBa.setAdapter(danhBaAdapter);
    }

}
