package jp.co.archive_asia.helloandroid;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyGridAdapter extends BaseAdapter {

    Context context;

    Integer[] girgroupId = {
            R.drawable.girlgroup01,R.drawable.girlgroup02,R.drawable.girlgroup03,
            R.drawable.girlgroup04,R.drawable.girlgroup05,R.drawable.girlgroup06,
            R.drawable.madonsuk01,R.drawable.madonsuk02,R.drawable.madonsuk03,

            R.drawable.girlgroup01,R.drawable.girlgroup02,R.drawable.girlgroup03,
            R.drawable.girlgroup04,R.drawable.girlgroup05,R.drawable.girlgroup06,
            R.drawable.madonsuk01,R.drawable.madonsuk02,R.drawable.madonsuk03,

            R.drawable.girlgroup01,R.drawable.girlgroup02,R.drawable.girlgroup03,
            R.drawable.girlgroup04,R.drawable.girlgroup05,R.drawable.girlgroup06,
            R.drawable.madonsuk01,R.drawable.madonsuk02,R.drawable.madonsuk03

    };

    public MyGridAdapter(Context c) {
        context = c;
    }

    public int getCount() {
        return girgroupId.length;
    }

    public View getView(final int position, View contentView, ViewGroup parent) {
        ImageView imageview = new ImageView(context);
        imageview.setLayoutParams(new GridView.LayoutParams(300, 300));
        imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageview.setPadding(1,1,1,1);

        imageview.setImageResource(girgroupId[position]);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View dialogView = View.inflate(context, R.layout.dialog_simplegrid,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView imageview = dialogView.findViewById(R.id.girlgroupImageView);
                imageview.setImageResource(girgroupId[position]);

                dlg.setTitle("いいね！");
                dlg.setIcon(R.drawable.ic_launcher_foreground);
                dlg.setView(dialogView);
                dlg.setNegativeButton("閉じる", null);
                dlg.show();
            }
        });
        return imageview;

    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }



}
