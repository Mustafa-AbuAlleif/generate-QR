package com.example.generateqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
    EditText edQrCode;
    Button btnGenerateQR;
    ImageView imageView_QRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edQrCode = findViewById(R.id.edQrCode);
        btnGenerateQR = findViewById(R.id.btnGenerateQR);
        imageView_QRCode = findViewById(R.id.imageView_QRCode);

        btnGenerateQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Here Insert Data or text
                String data = edQrCode.getText().toString();
                // Initializing the QR Encoder with your value to be encoded, type you required and Dimension
                QRGEncoder qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT,1000);
                qrgEncoder.setColorBlack(Color.BLACK);
                qrgEncoder.setColorWhite(Color.WHITE);
                try {
                    // Getting QR-Code as Bitmap
                    Bitmap bitmap = qrgEncoder.getBitmap();
                    // Setting Bitmap to ImageView
                    imageView_QRCode.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
