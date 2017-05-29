package com.example.ian.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;

import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;

import java.lang.reflect.Field;

/**
 * Created by Ian on 28-05-2017.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag);

        final Toolbar toolbar = (Toolbar)findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitle(" ");



    }

}