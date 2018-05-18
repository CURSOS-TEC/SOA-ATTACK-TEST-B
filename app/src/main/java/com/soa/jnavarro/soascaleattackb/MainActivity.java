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
    private Button mTestButton;
    private EditText mContactName;
    private EditText mContactPhone;

    /**
     * This method sends a general intent.
     * @param pIntentName the indentifier of the intent.
     * @param pContactName the name of tha contact to edit
     * @param pContactPhone the new phone to set
     */
    public void sendIntent(String pIntentName, String pContactName, String pContactPhone){
        try {
            Intent intent = new Intent(pIntentName);
            intent.putExtra(ContactsContract.Intents.Insert.PHONE,pContactPhone );
            intent.putExtra(ContactsContract.Intents.Insert.NAME,pContactName);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContactName = (EditText)findViewById(R.id.editTextName);
        mContactPhone =  (EditText)findViewById(R.id.editTextPhone);
        mTestButton= (Button) findViewById(R.id.test_button);
        mTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            sendIntent("com.soa.jnavarro.soascaleattacka.EditContact",
                    mContactName.getText().toString(),mContactPhone.getText().toString());


            }
        });
    }
}
