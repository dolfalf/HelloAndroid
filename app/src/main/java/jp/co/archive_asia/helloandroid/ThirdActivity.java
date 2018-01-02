package jp.co.archive_asia.helloandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jaeeun on 2018/01/01.
 */

public class ThirdActivity extends AppCompatActivity {

    Button backSecondButton;

    //Dialog controls
    TextView selectTextView;
    Button defaultDlgButton;

    TextView nameTextView;
    TextView mailTextView;
    Button customDlgButton;

    View dialogView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);

        backSecondButton = findViewById(R.id.backSecond);
        backSecondButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        selectTextView = findViewById(R.id.selectTextView);

        defaultDlgButton = findViewById(R.id.dlgButton);
        defaultDlgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(ThirdActivity.this);
                dlg.setTitle("タイトルはです");
                dlg.setIcon(R.mipmap.ic_launcher);

                final String[] girlGroups = new String[] {"TWICE","KARA","少女時代"};

//                //list
//                dlg.setItems(girlGroups, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        selectTextView.setText(girlGroups[which]);
//                    }
//                });

//                //radio
//                dlg.setSingleChoiceItems(girlGroups, 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        selectTextView.setText(girlGroups[which]);
//                    }
//                });

                //checkbox
                final boolean[] checks = new boolean[] {true, false, false};
                dlg.setMultiChoiceItems(girlGroups, checks, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        selectTextView.setText(girlGroups[which] + String.valueOf(isChecked));
                    }
                });

                dlg.setPositiveButton("閉じる", null);


//
//                //defult
//                dlg.setMessage("内容をここに書きます。");
//                dlg.setPositiveButton("確認", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(ThirdActivity.this, "確認ぼたんを押したよ。", Toast.LENGTH_LONG)
//                        .show();
//                    }
//                });
                dlg.show();
            }
        });

        nameTextView = findViewById(R.id.nameTextView);
        mailTextView = findViewById(R.id.mailTextView);
        customDlgButton = findViewById(R.id.customDlgButton);


        customDlgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogView = View.inflate(ThirdActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(ThirdActivity.this);

                dlg.setTitle("ユーザー情報入力する");
                dlg.setIcon(R.drawable.ic_launcher_foreground);
                dlg.setView(dialogView);
                dlg.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText dlgNameEditText = dialogView.findViewById(R.id.nameEditText);
                        EditText dlgMailEditText = dialogView.findViewById(R.id.mailEditText);

                        nameTextView.setText(dlgNameEditText.getText().toString());
                        mailTextView.setText(dlgMailEditText.getText().toString());
                    }
                });
                dlg.setNegativeButton("キャンセル", null);

                dlg.show();

            }
        });

    }
}
