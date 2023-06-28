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
    private ImageView iImage,iImage2,iImage3;
    private Typeface face1;
    private int[] array_eat = {R.string.adjika,R.string.airan,R.string.baget,R.string.BQ,
            R.string.vinigret,R.string.doma,R.string.jambo,R.string.kasha,R.string.okroshka,R.string.raf,R.string.tiramisu,R.string.fondan,R.string.shkmirul,R.string.sup};
    private int[] array_prod = {R.string.goroh,R.string.kapusta,R.string.kartofel,R.string.kolbasa,
            R.string.milk,R.string.muka,R.string.manka,R.string.carrot,R.string.ogurets,R.string.pomidor,
            R.string.svekla,R.string.chesnok};
    private int[] array_tools = {R.string.avtoklav,R.string.baranchik,R.string.blender,R.string.venchik,
            R.string.knife,R.string.grohot,R.string.kazan,R.string.meet,R.string.slayser,R.string.sotei,
            R.string.fri};
    private int [] array_image_eat = {R.drawable.adjika,R.drawable.airan,R.drawable.baget,R.drawable.barbeq,
            R.drawable.vinegret,R.drawable.dolma,R.drawable.jambo,R.drawable.kasha,R.drawable.okroshka,R.drawable.raf,
            R.drawable.tiramisu,R.drawable.fondan,R.drawable.shkmerul,R.drawable.sup};
    private int [] array_image_eat2 = {R.drawable.adjika2,R.drawable.airan2,R.drawable.baget2,R.drawable.barbeq2,
            R.drawable.vinegret2,R.drawable.dolma2,R.string.vinigret,R.drawable.jambo2,R.drawable.kasha2,R.drawable.okroshka2,R.drawable.raf2,
            R.drawable.tiramisu2,R.drawable.fondan2,R.drawable.shkmerul2,R.drawable.sup2};
    private int [] array_image_eat3 = {R.drawable.adjika3,R.drawable.airan3,R.drawable.baget3,R.drawable.barbeq3,
            R.drawable.vinegret3,R.drawable.dolma3,R.drawable.jambo3,R.drawable.kasha3,R.drawable.okroshka3,R.drawable.raf3,
            R.drawable.tiramisu3,R.drawable.fondan3,R.drawable.shkmerul3,R.drawable.sup3};
    private int [] array_image_prod = {R.drawable.goroh,R.drawable.kapusta,R.drawable.kartofel,R.drawable.kolbasa,
            R.drawable.moloko,R.drawable.myka,R.drawable.manka,R.drawable.morkov,R.drawable.ogyresc,
            R.drawable.pomidor,R.drawable.svekla,R.drawable.chesnok};
    private int [] array_image_prod2 = {R.drawable.goroh2,R.drawable.kapusta2,R.drawable.kartofel2,R.drawable.kolbasa2,
            R.drawable.moloko2,R.drawable.myka2,R.drawable.manka2,R.drawable.morkov2,R.drawable.ogyresc2,
            R.drawable.pomidor2,R.drawable.svekla2,R.drawable.chesnok2};
    private int [] array_image_prod3 = {R.drawable.goroh3,R.drawable.kapusta3,R.drawable.kartofel3,R.drawable.kolbasa3,
            R.drawable.moloko3,R.drawable.myka3,R.drawable.manka3,R.drawable.morkov3,R.drawable.ogyresc3,
            R.drawable.pomidor3,R.drawable.svekla3,R.drawable.chesnok3};
    private int [] array_image_tools = {R.drawable.avtoklav,R.drawable.baranchik,R.drawable.blender,
            R.drawable.venchik,R.drawable.gastro_nosh,R.drawable.grohot,R.drawable.kazan,R.drawable.misorihl,
            R.drawable.slaiser,R.drawable.soteinik,R.drawable.fritur};
    private int [] array_image_tools2 = {R.drawable.avtoklav2,R.drawable.baranchik2,R.drawable.blender2,
            R.drawable.venchik2,R.drawable.gastro_nosh2,R.drawable.grohot2,R.drawable.kazan2,R.drawable.misorihl2,
            R.drawable.slaiser2,R.drawable.soteinik2,R.drawable.fritur2};
    private int [] array_image_tools3 = {R.drawable.avtoklav3,R.drawable.baranchik3,R.drawable.blender3,
            R.drawable.venchik3,R.drawable.gastro_nosh3,R.drawable.grohot3,R.drawable.kazan3,R.drawable.misorihl3,
            R.drawable.slaiser3,R.drawable.soteinik3,R.drawable.fritur3};
    private String [] array_title_eat = {"Аджика","Айран","Багет",
            "Барбекю","Винегрет","Джамбалайя","Каши","Окрошка","Рафаэлло","Торт Тирамису","Фондан","Шкмерули","Щи"};
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
                iImage2.setImageResource(array_image_eat2[position]);
                iImage3.setImageResource(array_image_eat3[position]);
                info_content.setText(array_eat[position]);
                actionBar.setTitle(array_title_eat[position]);
                actionBar.setDisplayHomeAsUpEnabled(true);
                break;
            case 1:
                iImage.setImageResource(array_image_prod[position]);
                iImage2.setImageResource(array_image_prod2[position]);
                iImage3.setImageResource(array_image_prod3[position]);
                info_content.setText(array_prod[position]);
                actionBar.setTitle(array_title_prod[position]);
                actionBar.setDisplayHomeAsUpEnabled(true);
                break;
            case 2:
                iImage.setImageResource(array_image_tools[position]);
                iImage2.setImageResource(array_image_tools2[position]);
                iImage3.setImageResource(array_image_tools3[position]);
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
        iImage2 = findViewById(R.id.infoImage2);
        iImage3 = findViewById(R.id.infoImage3);
//        face1 = Typeface.createFromAsset(this.getAssets(),"fonts/Neucha-Regular.ttf");
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
