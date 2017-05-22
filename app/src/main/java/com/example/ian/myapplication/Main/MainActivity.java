package com.example.ian.myapplication.Main;
import android.app.AlertDialog;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SwitchCompat;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ian.myapplication.Adapter.MainPagerAdapter;
import com.example.ian.myapplication.Busqueda;
import com.example.ian.myapplication.Guias.EditarPerfil;
import com.example.ian.myapplication.Guias.MejoresGuias;
import com.example.ian.myapplication.R;
import com.example.ian.myapplication.Tours.UltimosTours;
import com.example.ian.myapplication.test;

import junit.framework.Test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        //FragmentManager fm = getFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Solicitudes");

        ImageView search = (ImageView)findViewById(R.id.searchButton);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.nombre);
        TextView nav_esp = (TextView)hView.findViewById(R.id.especialidad);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        Menu menu=navigationView.getMenu();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Busqueda.class);
               // startActivity(intent);
            }
        });


        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.updatres));

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.star));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {

            Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
            switch (tab.getPosition()){
                case 0:
                    toolbar.setTitle("Conozca lo últimos tours");
                    tab.setIcon(R.drawable.updatres);
                    break;
                case 1:
                    toolbar.setTitle("Los mejores guías del mes");
                    tab.setIcon(R.drawable.stared);
                    break;
            }
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            switch (tab.getPosition()){
                case 0:
                    tab.setIcon(R.drawable.update);
                    break;
                case 1:
                    tab.setIcon(R.drawable.star);
                    break;
            }
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });

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
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if(id == R.id.nav_home){
            tabLayout.setVisibility(View.VISIBLE);
            fab.setVisibility(View.VISIBLE);
            fm.beginTransaction().replace(R.id.content_main, new test()).commit();
            toolbar.setTitle("Conozca los últimos tours");
        }else if(id == R.id.nav_perfil){
            tabLayout.setVisibility(View.GONE);
            fab.setVisibility(View.GONE);
            fm.beginTransaction().replace(R.id.content_main, new EditarPerfil()).commit();
            toolbar.setTitle("Editar perfil");
        }
     /*   if(id == R.id.nav_aceptados){
            fm.beginTransaction().replace(R.id.content_main, new AceptadosActivity()).commit();
            toolbar.setTitle("Atenciones aceptadas");
        }else if (id == R.id.nav_solicitud) {
            fm.beginTransaction().replace(R.id.content_main, new SolicitudActivity()).commit();
            toolbar.setTitle("Solicitudes");
        } else if (id == R.id.nav_realizados) {
            fm.beginTransaction().replace(R.id.content_main,new RealizadosActivity()).commit();
            toolbar.setTitle("Atenciones realizadas");
        } else if (id == R.id.nav_rechazados) {
            fm.beginTransaction().replace(R.id.content_main, new RechazadosActivity()).commit();
            toolbar.setTitle("Atenciones rechazadas");
        } else if (id == R.id.nav_historial) {
            fm.beginTransaction().replace(R.id.content_main,new HistorialActivity()).commit();
            toolbar.setTitle("Historial de atenciones");
        } else if (id == R.id.nav_cancelados) {
            fm.beginTransaction().replace(R.id.content_main,new CanceladosActivity()).commit();
            toolbar.setTitle("Atenciones canceladas");
        } else if (id == R.id.nav_anulados) {
            fm.beginTransaction().replace(R.id.content_main,new AnuladosActivity()).commit();
            toolbar.setTitle("Atenciones anuladas");
        } else if (id == R.id.nav_perfil) {
            Intent intent = new Intent(MainActivity.this, EditarPerfil.class);
            intent.putExtra("doctor",doctor);
            startActivity(intent);
        } else if (id == R.id.nav_configuracion) {
            Intent intent = new Intent(MainActivity.this, EditarConfiguracion.class);
            intent.putExtra("doctor",doctor);
            startActivity(intent);
        }else if (id == R.id.nav_proceso){
            fm.beginTransaction().replace(R.id.content_main,new ActivadosActivity()).commit();
            toolbar.setTitle("Atención en curso");
        }
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
