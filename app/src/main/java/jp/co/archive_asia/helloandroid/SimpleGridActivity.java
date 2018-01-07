package jp.co.archive_asia.helloandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by jaeeun on 2018/01/07.
 */

public class SimpleGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplegrid);

        setTitle("グリードビューサンプル");


        final GridView gridView = findViewById(R.id.girlgroupGridView);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gridView.setAdapter(gridAdapter);
    }


}


