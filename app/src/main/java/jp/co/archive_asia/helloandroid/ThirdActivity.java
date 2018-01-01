package jp.co.archive_asia.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jaeeun on 2018/01/01.
 */

public class ThirdActivity extends AppCompatActivity {

    Button backSecondButton;

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
    }
}
