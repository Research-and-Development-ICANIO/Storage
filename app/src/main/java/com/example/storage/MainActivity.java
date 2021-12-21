package com.example.storage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String data="Hello";
                    File file = new File(getSdcardLocation()+File.separator+"jello.txt");

                    Toast.makeText(getApplicationContext(),file.getAbsolutePath(),Toast.LENGTH_LONG).show();

                    file.createNewFile();

                    FileOutputStream fout = new FileOutputStream(file, true);
                    fout.write(data.getBytes());
                    fout.close();

                    Toast.makeText(getApplicationContext(), "DATA IS WRITTEN", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG);
            }
        });
    }

    private String getSdcardLocation() {
        String location = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            File[] dirs = getApplicationContext().getExternalCacheDirs();
            if (dirs.length > 1) {
                location = dirs[1].getAbsolutePath().substring(dirs[1].getAbsolutePath().indexOf("/"), dirs[1].getAbsolutePath().lastIndexOf("/Android"));
            }
        }
        return location;
    }

}