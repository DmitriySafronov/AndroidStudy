package pw.cyberbrain.androidstudy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BottomNavigationActivity extends AppCompatActivity {

    // Fragments
    Fragment firstFragment;
    Fragment secondFragment;
    Fragment thirdFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            boolean mResult = true;

            // Handle bottom navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.navigation_first) {
                fragmentTransaction.replace(R.id.content2, firstFragment);
            } else if (id == R.id.navigation_second) {
                fragmentTransaction.replace(R.id.content2, secondFragment);
            } else if (id == R.id.navigation_third) {
                fragmentTransaction.replace(R.id.content2, thirdFragment);
            } else {
                mResult = false;
            }

            fragmentTransaction.commit();
            return mResult;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bottom_navigation);

            // new Fragments
            firstFragment = new FirstFragment();
            secondFragment = new SecondFragment();
            thirdFragment = new ThirdFragment();

            // Bottom navigation
            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            navigation.setSelectedItemId(R.id.navigation_first);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
           // Inflate the menu; this adds items to the action bar if it is present.
           getMenuInflater().inflate(R.menu.options, menu);
           return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
           // Handle action bar item clicks here. The action bar will
           // automatically handle clicks on the Home/Up button, so long
           // as you specify a parent activity in AndroidManifest.xml.

           int mColor = Color.TRANSPARENT;

           int id = item.getItemId();

           //noinspection SimplifiableIfStatement
           if (id == R.id.settings_yellow) {
               mColor = Color.YELLOW;
           } else if (id == R.id.settings_cyan) {
               mColor = Color.CYAN;
           } else if (id == R.id.settings_magenta) {
               mColor = Color.MAGENTA;
           }

            FragmentManager fragmentManager = getSupportFragmentManager();
            View mView = fragmentManager.findFragmentById(R.id.content2).getView();
            try {
                mView.setBackgroundColor(mColor);
                return true;
            } catch (Exception e){
                return super.onOptionsItemSelected(item);
            }
    }

}
