package com.example.danieldigregorio.pap_ads5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


/**
 * Created by danieldigregorio on 19/05/2017.
 */

public class MainActivity extends Activity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
    }

    public void activityCriarConta(View view){
        Intent criarConta = new Intent(this, Main2Activity.class);
        startActivity(criarConta);
    }
}
