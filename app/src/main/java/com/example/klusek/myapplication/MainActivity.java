package com.example.klusek.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.klusek.myapplication.Mapping.Firma;
import com.example.klusek.myapplication.Mapping.Gra;
import com.example.klusek.myapplication.Mapping.Gry;
import com.example.klusek.myapplication.Tools.Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Gry gry;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gry = Tools.readXML(context, "result.xml");
        setContentView(R.layout.activity_main);
        final EditText companyNameEditText = (EditText) findViewById(R.id.companyNameEditText);
        final EditText companyLocalizationEditText = (EditText) findViewById(R.id.companyLocalizationEditText);
        final EditText companyDateEditText = (EditText) findViewById(R.id.companyDateEditText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        final List<String> list = new ArrayList<>();

        for (Firma f:gry.getListaFirm()
             ) {
            list.add(f.getNazwa());
        }
        final String[] array = list.toArray(new String[list.size()]);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                companyNameEditText.setText(array[adapterView.getSelectedItemPosition()]);
                companyLocalizationEditText.setText(gry.getListaFirm().get(adapterView.getSelectedItemPosition()).getLokalizacja());
                companyDateEditText.setText(String.valueOf(gry.getListaFirm().get(adapterView.getSelectedItemPosition()).getDataZalozenia()));

                LinearLayout companyLayout = (LinearLayout) findViewById(R.id.company_layout);

                for(int j = 7; i < companyLayout.getChildCount(); i++) {
                    if(companyLayout.getChildAt(j) != null)
                        companyLayout.removeViewAt(j);
                }

                for (Gra g: gry.getListaFirm().get(adapterView.getSelectedItemPosition()).getListaGier()) {
                    LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    LinearLayout game = (LinearLayout) vi.inflate(R.layout.game_item, null);

                    ((EditText)game.findViewById(R.id.gameNameEditText)).setText(g.getNazwa());
                    ((EditText)game.findViewById(R.id.gameDateEditText)).setText(g.getRokWydania());
                    ((EditText)game.findViewById(R.id.gameTypeEditText)).setText(g.getGatunek());
                    ((EditText)game.findViewById(R.id.gamePriceEditText)).setText(g.getCena());
                    ((EditText)game.findViewById(R.id.gameCountEditText)).setText(String.valueOf(g.getIloscSztuk()));
                    companyLayout.addView(game);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter adapter = new ArrayAdapter<String>(context, R.layout.spinner_item, array) {

            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                if(convertView == null)
                {
                    convertView = inflater.inflate(R.layout.spinner_item, null);
                }

                TextView companyName = (TextView) convertView.findViewById(R.id.spinner_item_name);
                companyName.setText(array[position]);

                return convertView;
            }
        };

        spinner.setAdapter(adapter);

        setSupportActionBar(toolbar);

        //String xmlString = getXml("files/result.txt");
        //xmlTextView.setText(xmlString);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView navTextView = (TextView) navigationView.getHeaderView(0).findViewById(R.id.navTextView);

        if(navTextView != null) {
            navTextView.setText(gry.getOgolneInformacje().toString());
        }

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
        if (id == R.id.action_company) {
            return true;
        } else if(id == R.id.action_game) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pdf) {
            // Handle the camera action
        } else if (id == R.id.nav_html) {

        } else if (id == R.id.nav_svg) {

        } else if (id == R.id.nav_summary) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
