package jp.co.archive_asia.helloandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by jaeeun on 2018/01/02.
 */

public class SimpleListActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simplelist);

        setTitle("ListView練習");

        final String[] languages = {
                "Objective-C",
                "Java",
                "Swift",
                "Go",
                "PHP" ,
                "Ruby",
                "C#",
                "Kotlin",
                "COBOL",
                "SAP/R3",
                "JavaScript",
                "Visual Basic",
                "HTML/CSS",
                "Aduino"};

        listView = findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                languages);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleListActivity.this,languages[position],Toast.LENGTH_SHORT)
                .show();
            }
        });
    }
}
