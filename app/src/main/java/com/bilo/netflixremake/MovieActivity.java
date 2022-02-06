package com.bilo.netflixremake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //Compatibilidade com outros dispositivos mais antigos

        //Verifica se a toolbar foi adicionada com sucesso
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Exibir o icone de Home na toolbar
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        }

        //Para mudar a imagem que aparece juntamente com as Shadows
        LayerDrawable drawable =  (LayerDrawable) ContextCompat.getDrawable(this, R.drawable.shadows); //Para conseguir modificar um elemento drawable

        if(drawable != null){

            //Acessa o Item da Layer List e troca a propridade drawable
            Drawable movieCover = ContextCompat.getDrawable(this, R.drawable.movie);
            drawable.setDrawableByLayerId(R.id.cover_drawble, movieCover);
            ((ImageView) findViewById(R.id.image_view_cover)).setImageDrawable(drawable); //Efetua a troca de imagem
        }
    }
}