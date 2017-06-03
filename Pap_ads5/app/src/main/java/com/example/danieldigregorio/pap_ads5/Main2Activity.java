package com.example.danieldigregorio.pap_ads5;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends Activity {
    private DatabaseHelper helper;
    private EditText nome,email,cpf,dataNasc,tel,rua,bairro,cidade,estado;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cadastro);

        nome = (EditText) findViewById(R.id.eNome);
        email = (EditText) findViewById(R.id.eEmail);
        cpf = (EditText) findViewById(R.id.eCpf);
        dataNasc = (EditText) findViewById(R.id.eData);
        tel = (EditText) findViewById(R.id.eTelefone);
        rua = (EditText) findViewById(R.id.eRua);
        bairro = (EditText) findViewById(R.id.eBairro);
        cidade = (EditText) findViewById(R.id.eCidade);
        estado = (EditText) findViewById(R.id.eEstado);

        helper = new DatabaseHelper(this);
    }

    public void SalvarUsuario (View view){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nome", nome.getText().toString());
        values.put("email", email.getText().toString());
        values.put("cpf", cpf.getText().toString());
        values.put("data_nascimento", dataNasc.getText().toString());
        values.put("telefone", tel.getText().toString());
        values.put("rua", rua.getText().toString());
        values.put("bairro", bairro.getText().toString());
        values.put("cidade", cidade.getText().toString());
        values.put("estado", estado.getText().toString());

        long resultado = db.insert("usuario", null, values);
        if(resultado == -1 ) {
            Toast.makeText(this, getString(R.string.registro_salvo),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
