package com.sunshine.textutils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageUrlActivity extends AppCompatActivity {
    EditText imageUrlTxt;
    String imgUrl;
    ImageView imgView;
    Button previewBtn;
    ImageButton rotateLeftBtn;
    ImageButton rotateRightBtn;
    Button flipHorizontalBtn;
    Button flipVerticalBtn;
    int angle = 0;
    int scaleX = 1;
    int scaleY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_url);
        getSupportActionBar().setTitle("Image Utils");
        imageUrlTxt = findViewById(R.id.img_url_txt);
        imgView = findViewById(R.id.imgview_img);
        previewBtn = findViewById(R.id.preview_btn);
        rotateLeftBtn = findViewById(R.id.rotate_left_btn);
        rotateRightBtn = findViewById(R.id.rotate_right_btn);
        flipHorizontalBtn = findViewById(R.id.flip_horizontal_btn);
        flipVerticalBtn = findViewById(R.id.flip_vertical_btn);
        handlePreviewBtn();
        handleRotateLeftBtn();
        handleRotateRightBtn();
        handleFlipHorizontalBtn();
        handleFlipVerticalBtn();
    }

    public void handlePreviewBtn() {
        previewBtn.setOnClickListener(view -> {
            angle = 0;
            scaleX = 1;
            scaleY = 1;
            imgView.setScaleX(scaleX);
            imgView.setScaleY(scaleY);
            imgUrl = imageUrlTxt.getText().toString();
            Picasso.get().load(imgUrl).into(imgView);
        });
    }

    public void handleRotateLeftBtn() {
        rotateLeftBtn.setOnClickListener(view -> {
            angle = scaleX * scaleY * -90;
            Picasso.get().load(imgUrl).rotate(angle).into(imgView);
        });
    }

    public void handleRotateRightBtn() {
        rotateRightBtn.setOnClickListener(view -> {
            angle = scaleX * scaleY * 90;
            Picasso.get().load(imgUrl).rotate(angle).into(imgView);
        });
    }

    public void handleFlipHorizontalBtn() {
        flipHorizontalBtn.setOnClickListener(view -> {
            scaleX = scaleX * -1;
            imgView.setScaleX(scaleX);
        });
    }

    public void handleFlipVerticalBtn() {
        flipVerticalBtn.setOnClickListener(view -> {
            scaleY = scaleY * -1;
            imgView.setScaleY(scaleY);
        });
    }
}


