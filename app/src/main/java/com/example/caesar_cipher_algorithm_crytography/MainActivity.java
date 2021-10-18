package com.example.caesar_cipher_algorithm_crytography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button encrypt,decrypt;
    private EditText message,cipher,key;
    private TextView screen_output;
    private static  final String alphabetString="abcdefghijklmnopqrstuvwxyz";
    private static String finalTxt;

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
                try {
                    encrypt12(message.getText().toString(), Integer.parseInt(key.getText().toString()));
                }catch(Exception e){
                    e.printStackTrace();
                    encrypt12(message.getText().toString(), 0);
                }
            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    decrypt12(cipher.getText().toString(),Integer.parseInt(key.getText().toString()));
                }catch(Exception e){
                    e.printStackTrace();
                    decrypt12(cipher.getText().toString(),0);
                }
            }
        });
    }
    public  void decrypt12(String cipher, int key)
    {
        screen_output.setText((decrypt1(cipher, key).toLowerCase()));
    }

    public String decrypt1(String message, int shiftkey)
    {
        reset();
        for(int j=0;j<message.length();j++){
            if(message.charAt(j)=='0' || message.charAt(j)== '1' || message.charAt(j)== '2' || message.charAt(j)== '3'|| message.charAt(j)== '4'|| message.charAt(j)== '5'|| message.charAt(j)== '6'|| message.charAt(j)== '7'|| message.charAt(j)== '8'|| message.charAt(j)== '9')
            {
                Toast.makeText(MainActivity.this, "Numbers not allowed", Toast.LENGTH_SHORT).show();
                return "NumberError";
            }
        }

        message=message.toLowerCase();
        String cipherText="";
        for(int i=0;i<message.length();i++)
        {
            if(message.charAt(i)!=' ') {
                int charPosition = alphabetString.indexOf(message.charAt(i));
                int keyval = (-shiftkey + charPosition) % 26;
                char replaceVAL = alphabetString.charAt(keyval);
                cipherText += replaceVAL;
                screen_output.setText(cipherText);
                cipher.setText(cipherText);
            }
        }
        return cipherText;
    }

    private static void reset() {
        finalTxt="";
    }

    public String encrypt12(String message, int shiftkey)
    {
        for(int j=0;j<message.length();j++){
            if(message.charAt(j)=='0' || message.charAt(j)== '1' || message.charAt(j)== '2' || message.charAt(j)== '3'|| message.charAt(j)== '4'|| message.charAt(j)== '5'|| message.charAt(j)== '6'|| message.charAt(j)== '7'|| message.charAt(j)== '8'|| message.charAt(j)== '9')
            {
                Toast.makeText(MainActivity.this, "Numbers not allowed", Toast.LENGTH_SHORT).show();
                return "NumberError";
            }
        }

        message=message.toLowerCase();
        String cipherText="";
        for(int i=0;i<message.length();i++)
        {
            if(message.charAt(i)!=' ') {
                int charPosition = alphabetString.indexOf(message.charAt(i));
                int keyval = (shiftkey + charPosition) % 26;
                char replaceVAL = alphabetString.charAt(keyval);
                cipherText += replaceVAL;
                screen_output.setText(cipherText);
                cipher.setText(cipherText);
            }
        }
        return cipherText;
    }
}