package huydk.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import huydk.firstapp.R;
import huydk.models.Employee;

/**
 * Created by Admin on 12/26/2017.
 */

public class MyArrayAdapter extends ArrayAdapter<Employee>{
    Activity context;
    ArrayList<Employee>myArray;
    int layoutId;

    public MyArrayAdapter(@NonNull Activity context, int layoutId, @NonNull ArrayList<Employee> objects) {
        super(context, layoutId, objects);
        this.context = context;
        this.myArray = objects;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);

        if (myArray.size()>0 && position>0)
        {
            final TextView txtdisplay=(TextView)
                    convertView.findViewById(R.id.txtitem);
            //lấy ra nhân viên thứ position
            final Employee emp=myArray.get(position);
            //đưa thông tin lên TextView
            //emp.toString() sẽ trả về Id và Name
            txtdisplay.setText(emp.toString());
            //lấy ImageView ra để thiết lập hình ảnh cho đúng
            final ImageView imgitem=(ImageView)
                    convertView.findViewById(R.id.imgitem);

            if(emp.isGender())
                imgitem.setImageResource(R.drawable.grilicon);
            else//nếu là Nam thì lấy hình con trai
                imgitem.setImageResource(R.drawable.boyicon );
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox chk=(CheckBox) view.findViewById(R.id.chkitem);
                if (chk.isChecked()){
                    chk.toggle();
                    Toast.makeText(context,"Đã bỏ tích xóa",Toast.LENGTH_LONG).show();
                }else {
                    chk.toggle();
                    Toast.makeText(context,"Đã tích xóa",Toast.LENGTH_LONG).show();
                }
            }
        });
        //Vì View là Object là dạng tham chiếu đối tượng, nên
        //mọi sự thay đổi của các object bên trong convertView
        //thì nó cũng biết sự thay đổi đó
        return convertView;//trả về View này, tức là trả luôn
        //về các thông số mới mà ta vừa thay đổi

    }
}
