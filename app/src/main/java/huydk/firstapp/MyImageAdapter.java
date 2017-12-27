package huydk.firstapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Admin on 12/27/2017.
 */

public class MyImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer []mThumbIds;

    public MyImageAdapter(Context mContext, Integer[] mThumbIds) {
        this.mContext = mContext;
        this.mThumbIds = mThumbIds;
    }

    public MyImageAdapter(Context mContext) {

        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imgView ;

        if (view == null)
        {
            imgView = new ImageView(mContext);
            imgView.setLayoutParams(new GridView.LayoutParams(400,400));
//            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(8,8,8,8);

        }else {
            imgView = (ImageView) view;
        }

        imgView.setImageResource(mThumbIds[i]);
        return imgView;
    }
}
