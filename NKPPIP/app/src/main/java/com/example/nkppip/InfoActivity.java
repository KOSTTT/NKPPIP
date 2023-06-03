package com.example.nkppip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private ActionBar actionBar;
    private TextView info_content;
    private int chapter = 0;
    private int position = 0;
    private ImageView iImage;
    private Typeface face1;
    private int[] array_eat = {R.string.adjika,R.string.airan,R.string.baget,R.string.BQ,
            R.string.vinigret,R.string.kasha,R.string.okroshka,R.string.sup};
    private int[] array_prod = {R.string.goroh,R.string.kapusta,R.string.kartofel,R.string.kolbasa,
            R.string.milk,R.string.muka,R.string.manka,R.string.carrot,R.string.ogurets,R.string.pomidor,
            R.string.svekla,R.string.chesnok};
    private int[] array_tools = {R.string.avtoklav,R.string.baranchik,R.string.blender,R.string.venchik,
            R.string.knife,R.string.grohot,R.string.kazan,R.string.meet,R.string.slayser,R.string.sotei,
            R.string.fri};
    private int [] array_image_eat = {R.drawable.adjika,R.drawable.airan,R.drawable.baget,R.drawable.bq,
            R.drawable.vinegret,R.drawable.kasha,R.drawable.okroshka,R.drawable.sup};
    private int [] array_image_prod = {R.drawable.goroh,R.drawable.kapusta,R.drawable.kartofel,R.drawable.kolbasa,
            R.drawable.moloko,R.drawable.myka,R.drawable.manka,R.drawable.morkov,R.drawable.ogyresc,
            R.drawable.pomidor,R.drawable.svekla,R.drawable.chesnok};
    private int [] array_image_tools = {R.drawable.avtoklav,R.drawable.baranchik,R.drawable.blender,
            R.drawable.venchik,R.drawable.gastro_nosh,R.drawable.grohot,R.drawable.kazan,R.drawable.misorihl,
            R.drawable.slaiser,R.drawable.soteinik,R.drawable.fritur};
    private String [] array_title_eat = {"Аджика","Айран","Багет",
            "Барбекю","Винегрет","Каши","Окрошка","Щи"};
    private String [] array_title_prod = {"Горох","Капуста","Картофель",
            "Колбаса","Молоко","Мука","Манная крупа","Морковь","Огурец","Помидор","Свекла","Чеснок"};
    private String [] array_title_tools = {"Автоклав","Баранчик","Блендер",
            "Венчик","Гастрономический нож","Грохот","Казан","Мясорыхлитель","Слайсер","Сотейник","Фритюр"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_content);

        init();
        reciveIntent();

    }
    private void reciveIntent() {
        Intent i = getIntent();
        if (i != null) {
            chapter = i.getIntExtra("chapter", 0);
            position = i.getIntExtra("position", 0);
        }
        switch (chapter) {
            case 0:
                iImage.setImageResource(array_image_eat[position]);
                info_content.setText(array_eat[position]);
                actionBar.setTitle(array_title_eat[position]);
                actionBar.setDisplayHomeAsUpEnabled(true);
                break;
            case 1:
                iImage.setImageResource(array_image_prod[position]);
                info_content.setText(array_prod[position]);
                actionBar.setTitle(array_title_prod[position]);
                actionBar.setDisplayHomeAsUpEnabled(true);
                break;
            case 2:
                iImage.setImageResource(array_image_tools[position]);
                info_content.setText(array_tools[position]);
                actionBar.setTitle(array_title_tools[position]);
                actionBar.setDisplayHomeAsUpEnabled(true);
                break;
        }

    }
    private void init(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        info_content = findViewById(R.id.infoMain);
        iImage = findViewById(R.id.infoImage);
        face1 = Typeface.createFromAsset(this.getAssets(),"fonts/Neucha-Regular.ttf");
        info_content.setTypeface(face1);
        actionBar = getSupportActionBar();
        String text = sharedPreferences.getString("main_text_size","Средний");
        if(text != null){

        switch (text){
            case "Маленький":
                info_content.setTextSize(14);
                break;
            case "Средний":
                info_content.setTextSize(18);
                break;
            case "Большой":
                info_content.setTextSize(24);
                break;
        }
        }
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
