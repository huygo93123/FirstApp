package huydk.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    TextView tvMsg;
    GridView gv;
    TextView tvSoloMsg;

    Integer[] mThumbIds;

    MyImageAdapter adapter = null;

    ImageView ivSoloPictrue;
    Button btnBack;

    Bundle myBackupBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Lưu savedInstanceState trước vào myBackupBundle
        myBackupBundle=savedInstanceState;
        setContentView(R.layout.activity_main);
        tvMsg = (TextView) findViewById(R.id.tvMsg);

        mThumbIds = new Integer[]{R.drawable.h1,R.drawable.h3};
        gv = findViewById(R.id.gridView1);
        adapter = new MyImageAdapter(this,mThumbIds);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        showdetail(i);
    }

    private void showdetail(int position) {
        setContentView(R.layout.solo_picture);
        tvSoloMsg = findViewById(R.id.tvSoloMsg);
        tvSoloMsg.setText("Image at " + position);
        ivSoloPictrue = findViewById(R.id.imgSolo);

        ivSoloPictrue.setImageResource(mThumbIds[position]);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

//        btnTiep = (ImageButton) findViewById(R.id.btnTiep);
//        btnTiep.setOnClickListener(new OnClickListener() {
//
//        @Override
//        public void onClick(View arg0) {
//        // TODO Auto-generated method stub
//            if(arg2 0){
//                showdetail(arg2-1);
//            }
//        }
    }
}
