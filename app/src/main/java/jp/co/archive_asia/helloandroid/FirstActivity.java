package jp.co.archive_asia.helloandroid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * Created by jaeeun on 2018/01/01.
 */

public class FirstActivity extends AppCompatActivity {

    private static String TAG = "first";

    Button opneSecondButton;
    Button menuButton;
    LinearLayout menuLayout;

    Button toastButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);

        opneSecondButton = findViewById(R.id.openSecond);
        opneSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("param_string", "hogehoge");
                startActivityForResult(intent, 0);
            }
        });

        //Option Menu
        menuLayout = findViewById(R.id.menuLayout);
        menuButton = findViewById(R.id.menuButton);

        //Toast Button
        toastButton = findViewById(R.id.toastButton);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(FirstActivity.this, "トスと練習", Toast.LENGTH_LONG);

//                Display display = (WindowManager)getSystemService(WINDOW_SERVICE).getDefaultDisplay();
                //toast.setGravity(Gravity.TOP, 100,100);

                toast.show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i(TAG,String.valueOf(data.getIntExtra("param_int" , 0)));
    }


    //Menu Override methods

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu, menu);

        //create menu java code only
        menu.add(0, 1, 0, "背景色（赤）");
        menu.add(0,2,0,"背景色（緑）");
        menu.add (0,3,0,"背景色（青）");

        SubMenu subMenu = menu.addSubMenu("ボタン変更");
        subMenu.add(0,4,0,"ボタン45度");
        subMenu.add(0,5,0,"ボタンを２倍");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case 1://R.id.itemRed:
                menuLayout.setBackgroundColor(Color.RED);
                break;
            case 2://R.id.itemGreen:
                menuLayout.setBackgroundColor(Color.GREEN);
                break;
            case 3://R.id.itemBule:
                menuLayout.setBackgroundColor(Color.BLUE);
                break;
            //sub menu
            case 4://R.id.subRotate:
                menuButton.setRotation(45);
                break;
            case 5://R.id.subSize:
                menuButton.setScaleX(2);
                break;
        }

        return true;
    }
}
