package com.gmbdesign.main;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class AndroidPeque extends AppCompatActivity {

    private ImageView androidPeque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_peque);

        androidPeque = (ImageView) findViewById(R.id.mipeque);

        androidPeque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AndroidPeque.this, AndroidGrande.class);

                //VAMOS A DISCERNIR SI ESTAMOS EN UNA VERSION INFERIOR A LA 21
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Log.d("TAG", "Estoy en una versión que admite transiciones");
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(AndroidPeque.this, androidPeque, "roboto");
                    startActivity(intent, activityOptions.toBundle());
                } else {
                    Log.d("TAG", "Estoy en una versión que NO admite transiciones");
                    startActivity(intent);
                }
            }
        });
    }
}
