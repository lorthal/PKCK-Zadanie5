package com.example.klusek.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
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
import android.text.Editable;
import android.text.TextWatcher;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.klusek.myapplication.Mapping.Firma;
import com.example.klusek.myapplication.Mapping.Gra;
import com.example.klusek.myapplication.Mapping.Gry;
import com.example.klusek.myapplication.Tools.Tools;
import com.example.klusek.myapplication.Tools.XMLManager;

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
    Spinner spinner;
    String[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gry = XMLManager.readXML(context, "result.xml");
        setContentView(R.layout.activity_main);
        final EditText companyNameEditText = (EditText) findViewById(R.id.companyNameEditText);
        final EditText companyLocalizationEditText = (EditText) findViewById(R.id.companyLocalizationEditText);
        final EditText companyDateEditText = (EditText) findViewById(R.id.companyDateEditText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner = (Spinner) findViewById(R.id.spinner);

        final List<String> list = new ArrayList<>();

        for (Firma f:gry.getListaFirm()
             ) {
            list.add(f.getNazwa());
        }

        array = list.toArray(new String[list.size()]);

        companyNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                for (Firma f:gry.getListaFirm()) {
                    if(spinner.getSelectedItem().toString().matches(f.getNazwa()))
                        f.setNazwa(editable.toString());
                }
            }
        });

        companyLocalizationEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                for (Firma f:gry.getListaFirm()) {
                    if(spinner.getSelectedItem().toString().matches(f.getNazwa()))
                        f.setLokalizacja(editable.toString());
                }
            }
        });

        companyDateEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                for (Firma f:gry.getListaFirm()) {
                    if(spinner.getSelectedItem().toString().matches(f.getNazwa()))
                        f.setDataZalozenia(Integer.valueOf(editable.toString()));
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                companyNameEditText.setText(array[adapterView.getSelectedItemPosition()]);
                companyLocalizationEditText.setText(gry.getListaFirm().get(adapterView.getSelectedItemPosition()).getLokalizacja());
                companyDateEditText.setText(String.valueOf(gry.getListaFirm().get(adapterView.getSelectedItemPosition()).getDataZalozenia()));

                final LinearLayout companyLayout = (LinearLayout) findViewById(R.id.company_layout);

                for(int j = 7; i < companyLayout.getChildCount(); i++) {
                    if(companyLayout.getChildAt(j) != null)
                        companyLayout.removeViewAt(j);
                }

                for (final Gra g: gry.getListaFirm().get(adapterView.getSelectedItemPosition()).getListaGier()) {
                    LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    LinearLayout game = (LinearLayout) vi.inflate(R.layout.game_item, null);

                    EditText gameName = (EditText)game.findViewById(R.id.gameNameEditText);
                    EditText gameDate = (EditText)game.findViewById(R.id.gameDateEditText);
                    EditText gameType = (EditText)game.findViewById(R.id.gameTypeEditText);
                    EditText gamePrice = (EditText)game.findViewById(R.id.gamePriceEditText);
                    EditText gameCount = (EditText)game.findViewById(R.id.gameCountEditText);

                    gameName.addTextChangedListener(new TextWatcher() {
                        String game;
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            game = charSequence.toString();
                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            g.setNazwa(editable.toString());
                        }
                    });

                    gameDate.addTextChangedListener(new TextWatcher() {

                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            g.setRokWydania(editable.toString());
                        }
                    });

                    gameType.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            g.setGatunek(editable.toString());
                        }
                    });

                    gamePrice.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            g.setCena(editable.toString());
                        }
                    });

                    gameCount.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            g.setIloscSztuk(Integer.valueOf(editable.toString()));
                        }
                    });

                    gameName.setText(g.getNazwa());
                    gameDate.setText(g.getRokWydania());
                    gameType.setText(g.getGatunek());
                    gamePrice.setText(g.getCena());
                    gameCount.setText(String.valueOf(g.getIloscSztuk()));
                    companyLayout.addView(game);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        setSupportActionBar(toolbar);

        //String xmlString = getXml("files/result.txt");
        //xmlTextView.setText(xmlString);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Dane Zapisane", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                XMLManager.saveXML(gry,"result.xml");
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
    protected void onResume() {
        super.onResume();

        gry = XMLManager.readXML(context, "result.xml");

        final List<String> list = new ArrayList<>();

        for (Firma f:gry.getListaFirm()
                ) {
            list.add(f.getNazwa());
        }
        array = list.toArray(new String[list.size()]);

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
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.add_company_dialog);
            dialog.setTitle(getString(R.string.action_company));
            Button dialogButtonSave = (Button) dialog.findViewById(R.id.button_save);
            Button dialogButtonCancel = (Button) dialog.findViewById(R.id.button_cancel);

            dialogButtonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText name = (EditText) dialog.findViewById(R.id.companyNameEditText_dialog);
                    EditText localization = (EditText) dialog.findViewById(R.id.companyLocalizationEditText_dialog);
                    EditText date = (EditText) dialog.findViewById(R.id.companyDateEditText_dialog);

                    if(!name.getText().toString().matches("") && !localization.getText().toString().matches("") && !date.getText().toString().matches("")) {

                        Firma firma = new Firma(name.getText().toString(),localization.getText().toString(), Integer.valueOf(date.getText().toString()));
                        firma.setListaGier(new ArrayList<Gra>());
                        gry.getListaFirm().add(firma);
                        XMLManager.saveXML(gry,"result.xml");
                        dialog.dismiss();
                        onResume();
                    }
                    else {
                        dialog.dismiss();
                    }
                }
            });

            dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            dialog.show();
            dialog.getWindow().setLayout(DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.WRAP_CONTENT);
            return true;
        } else if(id == R.id.action_game) {
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.add_game_dialog);
            dialog.setTitle(getString(R.string.action_game));
            Button dialogButtonSave = (Button) dialog.findViewById(R.id.button_save_game);
            Button dialogButtonCancel = (Button) dialog.findViewById(R.id.button_cancel_game);

            dialogButtonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText name = (EditText) dialog.findViewById(R.id.gameNameEditText_dialog);
                    EditText date = (EditText) dialog.findViewById(R.id.gameDateEditText_dialog);
                    EditText type = (EditText) dialog.findViewById(R.id.gameTypeEditText_dialog);
                    EditText price = (EditText) dialog.findViewById(R.id.gamePriceEditText_dialog);
                    EditText count = (EditText) dialog.findViewById(R.id.gameCountEditText_dialog);

                    if(!name.getText().toString().matches("") && !date.getText().toString().matches("") && !type.getText().toString().matches("") && !price.getText().toString().matches("") && !count.getText().toString().matches("")) {

                        Gra gra = new Gra(name.getText().toString(),date.getText().toString(), type.getText().toString(), price.getText().toString(), Integer.valueOf(count.getText().toString()));
                        for (Firma f: gry.getListaFirm()) {
                            if(spinner.getSelectedItem().toString().matches(f.getNazwa())) {
                                f.getListaGier().add(gra);

                            }
                        }
                        XMLManager.saveXML(gry,"result.xml");
                        dialog.dismiss();
                        onResume();
                    }
                    else {
                        dialog.dismiss();
                    }
                }
            });

            dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            dialog.show();
            dialog.getWindow().setLayout(DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.WRAP_CONTENT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_html) {
            Tools.convertToHTML(context, "PGK-gry-xhtml.xslt", "result.xml");
        }else if (id == R.id.nav_summary) {
            SummaryDialog();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void SummaryDialog()
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("Podsumowanie");
        dialog.setMessage(gry.getPodsumowanie().toString());
        dialog.show();
    }

}
