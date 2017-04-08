package com.hmproductions.planetsdrawer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public final static ArrayList<Planet> planets = new ArrayList<Planet>();
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    NavigationView navigationViewLeft, navigationViewRight;
    RecyclerView recyclerView;

    private final static int NUMBER_OF_ITEMS = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        // We need this to add click listeners
        navigationViewLeft = (NavigationView)findViewById(R.id.navigationViewLeft);
        /*navigationViewRight = (NavigationView)findViewById(R.id.navigationViewRight);*/

        // We need this to add toggle button
        mToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, R.string.open, R.string.close);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        PlanetRecyclerAdapter adapter = new PlanetRecyclerAdapter(NUMBER_OF_ITEMS);


        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationViewClickListener();

        planets.add(new Planet("Mercury",91));
        planets.add(new Planet("Venus",41));
        planets.add(new Planet("Earth",0));
        planets.add(new Planet("Mars",78));
        planets.add(new Planet("Jupiter",628));
        planets.add(new Planet("Saturn",1275));

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    void NavigationViewClickListener()
    {
        navigationViewLeft.setNavigationItemSelectedListener(this);
        //navigationViewRight.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(mToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mercury_item :
                startActivity(new Intent(MainActivity.this,MercuryActivity.class));
                return true;

            default:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Restricted Access")
                        .setMessage("You do not have permission to access this page.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setCancelable(false)
                        .show();
        }

        return false;
    }
}
