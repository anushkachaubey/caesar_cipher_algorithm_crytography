package com.example.caesar_cipher_algorithm_crytography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private Button encrypt,decrypt,reset;
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
                try {
                    encryptAlgo(message.getText().toString(), Integer.parseInt(key.getText().toString()));
                }catch(Exception e){
                    e.printStackTrace();
                    encryptAlgo(message.getText().toString(), 0);
                }
            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    decryptAlgo(cipher.getText().toString(),Integer.parseInt(key.getText().toString()));
                }catch(Exception e){
                    e.printStackTrace();
                    decryptAlgo(cipher.getText().toString(),0);
                }
            }
        });

//        reset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                reset();
//            }
//        });
    }

    public String decryptAlgo(String msg, int shiftkey)
    {
        for(int j=0;j<msg.length();j++){

            if(!( ((int)msg.charAt(j)>=65 && (int)msg.charAt(j)<=90) || ((int)msg.charAt(j)>=97 && (int)msg.charAt(j)<=122) || (int)msg.charAt(j)==32 ) ){
                Toast.makeText(MainActivity.this, "Numbers not allowed", Toast.LENGTH_SHORT).show();
                screen_output.setText("*Only letters allowed*");
                return "";
            }        //CHANGES
        }
        msg=msg.toLowerCase();  //CHANGES

        String cipherText="";
        for(int i=0;i<msg.length();i++)
        {
            if(msg.charAt(i)!=' ') {
                int charPosition = alphabetString.indexOf(msg.charAt(i));
                int keyval = (-shiftkey + charPosition) % 26;
                char replaceVAL = alphabetString.charAt(keyval);
                cipherText += replaceVAL;

            }
            else
                cipherText+=" ";
        }
        screen_output.setText(cipherText.toUpperCase());
        message.setText(cipherText);  //CHANGES
        return cipherText;
    }


    public void reset() {
        screen_output.setText("");
        cipher.setText("");
        message.setText("");
        key.setText("");
    }  //CHANGES


    public String encryptAlgo(String message, int shiftkey)
    {
        for(int j=0;j<message.length();j++){
            if(!( ((int)message.charAt(j)>=65 && (int)message.charAt(j)<=90) || ((int)message.charAt(j)>=97 && (int)message.charAt(j)<=122) || (int)message.charAt(j)==32) ){
                Toast.makeText(MainActivity.this, "Numbers not allowed", Toast.LENGTH_SHORT).show();
                screen_output.setText("*Only letters allowed*");
                return "";
            }        //CHANGES
        }

        message=message.toLowerCase();  //CHANGES
        String cipherText="";
        for(int i=0;i<message.length();i++)
        {
            if(message.charAt(i)!=' ') {
                int charPosition = alphabetString.indexOf(message.charAt(i));
                int keyval = (shiftkey + charPosition) % 26;
                char replaceVAL = alphabetString.charAt(keyval);
                cipherText += replaceVAL;
            }
            else
                cipherText+=" ";
        }
        screen_output.setText(cipherText.toUpperCase());
        cipher.setText(cipherText);
        return cipherText ;
    }
}