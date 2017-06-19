package com.example.ian.myapplication.CuentaGuia.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ian.myapplication.Busqueda;
import com.example.ian.myapplication.R;

/**
 * Created by Ian on 18-06-2017.
 */
public class MainGuia extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_guias);
        FragmentManager fm = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Actividad reciente");

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);

        ImageView search = (ImageView)findViewById(R.id.searchButton);
        setSupportActionBar(toolbar);


        TabLayout tab = (TabLayout)findViewById(R.id.tab_layout);
        tab.setVisibility(View.GONE);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.nombre);
        TextView nav_esp = (TextView)hView.findViewById(R.id.especialidad);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        Menu menu=navigationView.getMenu();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainGuia.this, Busqueda.class);
                // startActivity(intent);
            }
        });

        fm.beginTransaction().replace(R.id.content_main, new ActividadGuia()).commit();

    }




    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        final NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        menu=navigationView.getMenu();

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      /*  if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // actualizar doctor aqui o en nav_perfil y nav_configuracion


        FragmentManager fm = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tab = (TabLayout)findViewById(R.id.tab_layout);
        tab.setVisibility(View.GONE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);

        if(id == R.id.nav_nuevos){
            fm.beginTransaction().replace(R.id.content_main, new ActividadGuia()).commit();
            toolbar.setTitle("Actividad reciente");
        }else if(id == R.id.nav_stats){
            fm.beginTransaction().replace(R.id.content_main, new dashBoardActivity()).commit();
            toolbar.setTitle("Mis estadísticas");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


}
