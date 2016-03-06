package com.danielcswain.internal_external_storage;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Storage_Activity extends AppCompatActivity implements View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 2;
    private String fileName = "StorageFile.txt";
    private String filePath = "FileStorage";
    File myInternalFile;
    File myExternalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File directory = contextWrapper.getDir(filePath, Context.MODE_PRIVATE);
        myInternalFile = new File(directory, fileName);

        Button saveToInternalStorage = (Button)findViewById(R.id.internalStorageSave);
        Button readFromInternalStorage = (Button)findViewById(R.id.internalStorageGet);
        Button saveToExternalStorage = (Button)findViewById(R.id.externalStorageSave);
        Button readFromExternalStorage = (Button)findViewById(R.id.externalStorageGet);

        saveToInternalStorage.setOnClickListener(this);
        readFromInternalStorage.setOnClickListener(this);
        saveToExternalStorage.setOnClickListener(this);
        readFromExternalStorage.setOnClickListener(this);

        // Check if external storage is available and not read only
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveToExternalStorage.setEnabled(false);
            readFromExternalStorage.setEnabled(false);
        } else {
            myExternalFile = new File(getExternalFilesDir(filePath), fileName);
        }

    }


    private boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        EditText myInputText = (EditText)findViewById(R.id.inputText);
        TextView responseText = (TextView)findViewById(R.id.responseText);
        String myData = "";

        switch (v.getId()) {
            case R.id.internalStorageSave:
                // Try and save the file to the applications storage folder, checking for
                // a Input/Output (aka read write exception)

                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(myInternalFile);
                    fileOutputStream.write(myInputText.getText().toString().getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myInputText.setText("");
                responseText.setText("Saved to Internal Storage. (StorageFile.txt)");
                break;

            case R.id.internalStorageGet:
                // Try and retrive the file myInternalFile
                try{
                    FileInputStream fileInputStream = new FileInputStream(myInternalFile);
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(dataInputStream)
                        );
                    String strLine;
                    while ((strLine = bufferedReader.readLine()) != null) {
                        myData = myData + strLine;
                    }
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myInputText.setText(myData);
                responseText.setText("Data retrieved from Internal Storage. (StorageFile.txt)");
                break;

            case R.id.externalStorageSave:
                // Try and save to external file storage if it exists and is writable
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(myExternalFile);
                    fileOutputStream.write(myInputText.getText().toString().getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myInputText.setText("");
                responseText.setText("Saved to External Storage. (StorageFile.txt)");
                break;

            case R.id.externalStorageGet:
                // Try and read from external file storage if it exists and is readable
                try{
                    FileInputStream fileInputStream = new FileInputStream(myExternalFile);
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(dataInputStream)
                    );
                    String strLine;
                    while ((strLine = bufferedReader.readLine()) != null) {
                        myData = myData + strLine;
                    }
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myInputText.setText(myData);
                responseText.setText("Data retrieved from External Storage. (StorageFile.txt)");
                break;
        }
    }
}
