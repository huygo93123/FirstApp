package huydk.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ListViewExample";

    private ListView listView;
    private Button btnPrint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        btnPrint = findViewById(R.id.btvPrint);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i(TAG,"onItemClick: " + i);
                CheckedTextView v = (CheckedTextView) view;
                boolean currentCheck = v.isChecked();

                UserAccount user = (UserAccount)listView.getItemAtPosition(i);
                user.setActive(!currentCheck);
            }
        });

        UserAccount tom = new UserAccount("Tom","admin");
        UserAccount jerry = new UserAccount("Jerry","user");
        UserAccount donald = new UserAccount("Donald","guest", false);

        UserAccount[] users = new UserAccount[]{tom,jerry, donald};

        // android.R.layout.simple_list_item_checked: Là một hằng số Layout định nghĩa sẵn của Android
        // ý nghĩa của nó là ListView với ListItem đơn giản (Duy nhất một CheckedTextView).

        ArrayAdapter<UserAccount> arrayAdapter
                = new ArrayAdapter<UserAccount>(this, android.R.layout.simple_list_item_checked , users);


        listView.setAdapter(arrayAdapter);

        for(int i=0;i< users.length; i++ )  {
            listView.setItemChecked(i,users[i].isActive());
        }

        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printSelectedItems(view);
            }
        });


    }

    public void printSelectedItems(View view)  {

        SparseBooleanArray sp = listView.getCheckedItemPositions();

        StringBuilder sb= new StringBuilder();

        for(int i=0;i<sp.size();i++){
            if(sp.valueAt(i)==true){
                UserAccount user= (UserAccount) listView.getItemAtPosition(i);
                // Or:
                // String s = ((CheckedTextView) listView.getChildAt(i)).getText().toString();
                String s= user.getUserName();
                sb = sb.append(" "+s);
            }
        }
        Toast.makeText(this, "Selected items are: "+sb.toString(), Toast.LENGTH_LONG).show();

    }

}
