package jp.co.archive_asia.helloandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jaeeun on 2018/01/02.
 */

public class SimpleListActivity extends AppCompatActivity {

    private ListView listView;
    private Button addButton;
    private EditText addEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simplelist);

        setTitle("ListView練習");

        listView = findViewById(R.id.listView1);
/*
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



        //default
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,
//                languages);

        //checkbox
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                languages);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleListActivity.this,languages[position],Toast.LENGTH_SHORT)
                .show();
            }
        });
*/

        final ArrayList<String> items = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,items);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                items.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        addButton = findViewById(R.id.addButton);
        addEditText = findViewById(R.id.addItemEditText);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(addEditText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }


}
