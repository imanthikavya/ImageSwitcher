package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private Button nextbtn, previousbtn;
    private ImageSwitcher imageSwitcher;
    private int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3 , R.drawable.img4};
    private int position =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previousbtn =(Button)findViewById(R.id.btnPreveious);
        nextbtn =(Button)findViewById(R.id.nextButton);
        imageSwitcher =(ImageSwitcher) findViewById(R.id.imageSwitch);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imgvw = new ImageView(MainActivity.this);
                imgvw .setImageResource(images[position]);
                return imgvw;
            }
        });
        imageSwitcher.setInAnimation(this,android.R.anim.slide_in_left);
        imageSwitcher.setOutAnimation(this,android.R.anim.slide_out_right);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position<images.length)
                    position++;
                if (position>=images.length)
                    position= images.length-1;
                imageSwitcher.setImageResource(images[position]);
            }

        });
        previousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position<images.length)
                    position--;
                if (position>=images.length)
                    position= images.length+1;
                imageSwitcher.setImageResource(images[position]);
            }
        });
    }
}