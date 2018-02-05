package pw.cyberbrain.androidstudy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class BottomNavigationActivity extends AppCompatActivity {

    // Fragments
    Fragment redFragment;
    Fragment greenFragment;
    Fragment blueFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            boolean mResult = true;

            // Handle bottom navigation view item clicks here.
            int id = item.getItemId();
            String title = (String) item.getTitle();

            if (id == R.id.navigation_home) {
                fragmentTransaction.replace(R.id.content2, redFragment);
            } else if (id == R.id.navigation_dashboard) {
                fragmentTransaction.replace(R.id.content2, greenFragment);
            } else if (id == R.id.navigation_notifications) {
                fragmentTransaction.replace(R.id.content2, blueFragment);
            } else {
                mResult = false;
            }
            //toolbar.setTitle(title);
            fragmentTransaction.commit();
            return mResult;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bottom_navigation);

            // new Fragments
            redFragment = new RedFragment();
            greenFragment = new GreenFragment();
            blueFragment = new BlueFragment();


            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            navigation.setSelectedItemId(R.id.navigation_home);
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
           int id = item.getItemId();

           //noinspection SimplifiableIfStatement
           if (id == R.id.action_settings) {
               return true;
           }

           return super.onOptionsItemSelected(item);
    }

}
