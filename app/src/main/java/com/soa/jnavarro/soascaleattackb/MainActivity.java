package com.soa.jnavarro.soascaleattackb;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button testButton;
    private EditText contactName;
    private EditText contactPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactName = (EditText)findViewById(R.id.editTextName);
        contactPhone =  (EditText)findViewById(R.id.editTextPhone);
        testButton= (Button) findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {
                        Intent intent = new Intent("com.soa.jnavarro.soascaleattacka.EditContact");
                        intent.putExtra(ContactsContract.Intents.Insert.PHONE, contactPhone.getText().toString());
                        intent.putExtra(ContactsContract.Intents.Insert.NAME, contactName.getText().toString());
                        getApplicationContext().sendBroadcast(intent);
                        Log.i("Editcontact", " trying to edit email");
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, intent.getAction(), duration);
                        toast.show();
                    }
                    catch (Exception e){
                        Log.i("Error", e.getMessage());
                    }
            }
        });
    }
}
