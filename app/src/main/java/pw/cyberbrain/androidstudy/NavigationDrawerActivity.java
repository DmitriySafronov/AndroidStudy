package pw.cyberbrain.androidstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // Fragments
    Fragment redFragment;
    Fragment greenFragment;
    Fragment blueFragment;

    Toolbar toolbar;
    private int title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // new Fragments
        redFragment = new RedFragment();
        greenFragment = new GreenFragment();
        blueFragment = new BlueFragment();

        // Navigation drawer
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) this.onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_fragment_red));
        navigationView.setCheckedItem(R.id.nav_fragment_red);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Handle navigation view item clicks here.
        int id = item.getItemId();
        String title = (String) item.getTitle();

        if (id == R.id.nav_fragment_red) {
            fragmentTransaction.replace(R.id.content, redFragment);
        } else if (id == R.id.nav_fragment_green) {
            fragmentTransaction.replace(R.id.content, greenFragment);
        } else if (id == R.id.nav_fragment_blue) {
            fragmentTransaction.replace(R.id.content, blueFragment);
        } else if (id == R.id.nav_activity_2) {
            //fragmentTransaction.remove(fragmentManager.findFragmentById(R.id.content));
            // Second activity
            startActivity(new Intent(this, BottomNavigationActivity.class));
        }
        toolbar.setTitle(title);
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
