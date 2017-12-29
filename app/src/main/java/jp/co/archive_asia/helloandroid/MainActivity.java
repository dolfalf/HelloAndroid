package jp.co.archive_asia.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myApp";

    //UI controls.
    EditText    inputEditText;
    Button      displayButton;
    Button      openWebPageButton;
    RadioButton femaleRadioButton;
    RadioButton maleRaidoButton;
    ImageView   humanImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connection UI controls.

        inputEditText = (EditText)findViewById(R.id.inputEditText);
        inputEditText.setText("http://archive-asia.co.jp", TextView.BufferType.NORMAL);
        humanImageView = (ImageView)findViewById(R.id.humanImageView);

        displayButton = (Button)findViewById(R.id.displayButton);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:
                Log.w(TAG, "aaa");
                Toast.makeText(getApplicationContext(), inputEditText.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        openWebPageButton = (Button)findViewById(R.id.openWebPageButton);
        openWebPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:
                Log.w(TAG,"bbb");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(inputEditText.getText().toString()));
                startActivity(intent);
            }
        });

        femaleRadioButton = (RadioButton)findViewById(R.id.jiminRadio);
        femaleRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Log.w(TAG, "ccc");
                humanImageView.setImageResource(R.drawable.jimin);
            }
        });

        maleRaidoButton = (RadioButton)findViewById(R.id.donsukRadio);
        maleRaidoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.w(TAG, "ddd");
                    humanImageView.setImageResource(R.drawable.donsuk);
                }
        });


    }
}
