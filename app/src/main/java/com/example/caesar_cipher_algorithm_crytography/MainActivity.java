package com.example.caesar_cipher_algorithm_crytography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private Button encrypt,decrypt;
    private EditText message,cipher,key;
    private TextView screen_output;
    private static  final String alphabetString="abcdefghijklmnopqrstuvwxyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encrypt=findViewById(R.id.btnencrypt);
        decrypt=findViewById(R.id.btndecrypt);
        screen_output=findViewById(R.id.tV1);
        message=findViewById(R.id.inputMessage);
        cipher=findViewById(R.id.ciphEdt);
        key=findViewById(R.id.key_dt);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encrypt12(message.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrypt12(cipher.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });
    }
    public  void decrypt12(String cipher, int key)
    {
        screen_output.setText((utility.decrypt1(cipher, key).toLowerCase()));
    }

    public String encrypt12(String message, int shiftkey)
    {
        message=message.toLowerCase();
        String cipherText="";
        for(int i=0;i<message.length();i++)
        {
            int charPosition=alphabetString.indexOf(message.charAt(i));
            int keyval=(shiftkey+charPosition)%26;
            char replaceVAL=alphabetString.charAt(keyval);
            cipherText+=replaceVAL;
            screen_output.setText(cipherText);
            cipher.setText(cipherText);
        }
        return cipherText;
    }
}