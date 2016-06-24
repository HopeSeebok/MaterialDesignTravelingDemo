package com.cbok.materialdesignwidgetdemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    public static SparseArray<Bitmap> sPhotoCache = new SparseArray<Bitmap>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showPhoto(View view){
        Intent intent = new Intent();
        intent.setClass(this,DetailActivity.class);

        switch (view.getId()) {
            case R.id.show_photo_1:
                intent.putExtra("title", "Thailand");
                intent.putExtra("description", getResources().getText(R.string.thailand_desc));
                intent.putExtra("photo", R.drawable.thailand);
                break;
            case R.id.show_photo_2:
                intent.putExtra("title", "Holland");
                intent.putExtra("description", getResources().getText(R.string.holland_desc));
                intent.putExtra("photo", R.drawable.holland);
                break;
            case R.id.show_photo_3:
                intent.putExtra("title", "HongKong");
                intent.putExtra("description", getResources().getText(R.string.empty_desc));
                intent.putExtra("photo", R.drawable.hongkong);
                break;
            case R.id.show_photo_4:
                intent.putExtra("title", "Alps");
                intent.putExtra("description", getResources().getText(R.string.alps_desc));
                intent.putExtra("photo", R.drawable.alps);
                break;
        }
        ImageView hero = (ImageView) ((View)view.getParent()).findViewById(R.id.photo);
        sPhotoCache.put(intent.getIntExtra("photo",-1),((BitmapDrawable)hero.getDrawable()).getBitmap());
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,hero,"photo_hero");
        startActivity(intent,options.toBundle());
    }
}
