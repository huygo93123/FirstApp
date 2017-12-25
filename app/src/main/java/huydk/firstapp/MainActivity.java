package huydk.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lstView);
        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this,R.layout.mylist,R.id.Itemname,itemname));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, itemname[i], Toast.LENGTH_SHORT).show();
            }
        });
    }

}
