package jp.co.archive_asia.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


/**
 * Created by jaeeun on 2018/01/01.
 */

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "second";

    Button openThirdButton;
    Button backFirstButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent paramIntent = getIntent();
        Log.i(TAG, paramIntent.getStringExtra("param_string"));

        setContentView(R.layout.activity_second);

        openThirdButton = findViewById(R.id.openThird);
        openThirdButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        backFirstButton = findViewById(R.id.backFirst);
        backFirstButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
                intent.putExtra("param_int", 123);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //TODO: ここでデータを取得できる
    }
}
