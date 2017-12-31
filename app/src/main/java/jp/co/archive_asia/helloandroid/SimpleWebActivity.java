package jp.co.archive_asia.helloandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jaeeun on 2017/12/31.
 */

public final class SimpleWebActivity extends AppCompatActivity {

    private EditText urlEditText;
    private Button goButton;
    private Button backButton;
    private WebView mainWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleweb);

        //Setup UI controls
        urlEditText = (EditText) findViewById(R.id.urlEditText);
        goButton = (Button) findViewById(R.id.goButton);
        backButton = (Button) findViewById(R.id.backButton);
        mainWebView = (WebView) findViewById(R.id.mainWebview);

        mainWebView.setWebViewClient(new SimpleWebViewClient());

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainWebView.loadUrl(urlEditText.getText().toString());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainWebView.goBack();
            }
        });
    }
}
