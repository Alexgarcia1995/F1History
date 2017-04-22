package com.example.alejandro.demo_mockups;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Contact extends AppCompatActivity {
    String[] TO = {"jorge.sempere.perez@gmail.com"}; //aquí pon tu correo
    String[] CC = {"Mensaje_Usuario"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obtenemos los datos para el envío del correo
              //  EditText etEmail = (EditText) findViewById(R.id.etEmail);
            //    EditText etSubject = (EditText) findViewById(R.id.etSubject);

                CheckBox chkAttachment = (CheckBox) findViewById(R.id.chkAttachment);
                 EditText etBody = (EditText) findViewById(R.id.etBody);
                //es necesario un intent que levante la actividad deseada
                Intent itSend = new Intent(Intent.ACTION_SEND);

                //vamos a enviar texto plano a menos que el checkbox esté marcado
                itSend.setType("plain/text");
                //colocamos los datos para el envío
                itSend.putExtra(Intent.EXTRA_EMAIL,TO);
                itSend.putExtra(Intent.EXTRA_SUBJECT,CC);
                itSend.putExtra(Intent.EXTRA_TEXT, etBody.getText());
                //revisamos si el checkbox está marcado enviamos el ícono de la aplicación como adjunto
                if (chkAttachment.isChecked()) {
                    //colocamos el adjunto en el stream
                    itSend.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.hola));

                    //indicamos el tipo de dato
                    itSend.setType("image/png");
                }
                //iniciamos la actividad
                startActivity(itSend);
            }
        });

        setSupportActionBar(toolbar);
        setupActionBar();

    }
    private void setupActionBar(){

        ActionBar actionBar =getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getText(R.string.Contacto));
        }
    }


}
