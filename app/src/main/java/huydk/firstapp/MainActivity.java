package huydk.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import huydk.adapter.CustomListAdapter;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String[] itemname = {
        "Safari",
        "Camera",
        "Global",
        "FireFox",
        "UC Browser",
        "Android Folder",
        "VLC Player",
        "Cold War",
    };

    Integer[] imgid = {
      R.drawable.h1,
      R.drawable.h2,
      R.drawable.h4,
      R.drawable.h5,
      R.drawable.h6,
      R.drawable.h7,
      R.drawable.h8,
      R.drawable.h8,
      R.drawable.h10,
      R.drawable.h11,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter adapter = new CustomListAdapter(MainActivity.this,itemname,imgid);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Selecteditem = itemname[+i];
                Toast.makeText(MainActivity.this,Selecteditem,Toast.LENGTH_SHORT).show();
            }
        });

    }

}
