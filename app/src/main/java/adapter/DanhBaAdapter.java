package adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import huydk.firstapp.R;
import model.DanhBa;

/**
 * Created by Admin on 12/20/2017.
 */

public class DanhBaAdapter extends ArrayAdapter<DanhBa>{

    //đối số 1:màn hình sử dụng layout này
    Activity context ;
    //layout cho từng dòng muốn hiển thị
    int resource;
    //Danh sách nguồn dữ liệu muốn hiển thị
    List<DanhBa> objects;

    public DanhBaAdapter(Activity context, int resource, List<DanhBa> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        TextView txtTen = row.findViewById(R.id.txtName);
        TextView txtPhone = row.findViewById(R.id.txtPhone);
        ImageButton btnCall = row.findViewById(R.id.btnPhone);
        ImageButton btnSMS = row.findViewById(R.id.btnSMS);
        ImageButton btnDetail = row.findViewById(R.id.btnDetail);

        final DanhBa danhBa = this.objects.get(position);
        txtTen.setText(danhBa.getName());
        txtPhone.setText(danhBa.getPhone());

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionDetail(danhBa);
            }
        });
        return row;
    }

    private void actionDetail(DanhBa danhBa) {
        Toast.makeText(this.context,"You choose : " + danhBa.getName(), Toast.LENGTH_SHORT).show();
    }
}
