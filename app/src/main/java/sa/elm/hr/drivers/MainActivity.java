package sa.elm.hr.drivers;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private TextView txtName;
    private ImageView imgUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        if (savedInstanceState == null) {
            setTitle(R.string.menu_home);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MapActivity()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }//end if
//
        txtName = navigationView.getHeaderView(0).findViewById(R.id.navName);
//
//
        if (!MySharedPrefence.getString(this, Constants.Keys.USER_FNAME, "").equals("") && !MySharedPrefence.getString(this, Constants.Keys.USER_LNAME, "").equals("")) {
            txtName.setText(MySharedPrefence.getString(this, Constants.Keys.USER_FNAME, "") + " " + MySharedPrefence.getString(this, Constants.Keys.USER_LNAME, ""));
        }//end if


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_home) {
            setTitle(R.string.menu_home);
            //  getSupportFragmentManager().beginTransaction().replace(R.id.container, new map()).commit();
//            startActivity(new Intent(MainActivity.this,MapActivity.class));

            MapActivity mapActivity = new MapActivity();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mapActivity).commit();


        } else if (id == R.id.nav_history) {
            setTitle(R.string.menu_history);
            History history = new History();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, history).commit();

        } else if (id == R.id.nav_Payment) {
            setTitle(R.string.menu_Payment);
            checkIsCreditCardSaved();

        } else if (id == R.id.nav_Offers) {
            setTitle(R.string.menu_Offers);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Offers()).commit();

        } else if (id == R.id.nav_setting) {
            setTitle(R.string.menu_setting);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Settings()).commit();}

//        } else if (id == R.id.nav_Contact_us) {
//            setTitle(R.string.menu_Contactus);
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Contact_us()).commit();
//
//        }
//
else if (id == R.id.nav_driver) {
        setTitle(R.string.menu_driver);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new BecomeDriver()).commit();

    }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    private void checkIsCreditCardSaved() {

        //todo here move to menu drawer
        if (MySharedPrefence.getBoolean(this, Constants.Keys.SAVED_CREDIT_CARD, false) &&
        ( !MySharedPrefence.getString(this, Constants.Keys.CREDIT_CARD_NUMBER,"").equals("")) ){

//            setTitle(R.string.add_credit_card);
//        getSupportFragmentManager().beginTransaction().replace(R.id.container, new AddCreditCardActivity()).commit();
                // getChildFragmentManager().beginTransaction().replace(R.id.container, new AddCreditCardActivity()).commit();

            setTitle(R.string.saved_credit_card);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new SavedCreditCardActivity()).commit();

        }else {
            //  startActivity(new Intent(this, AddCreditCardActivity.class));
//            finish();


            setTitle(R.string.add_credit_card);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new AddCreditCardActivity()).commit();
        }//end else


    }//end checkIsLogin

}

//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.navigation.NavigationView;
//import com.google.android.material.snackbar.Snackbar;
//
//public class MainActivity extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener {
//
//
//    private TextView txtName;
//    private ImageView imgUser;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//
//        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener(this);
//
//
//        if (savedInstanceState == null) {
//            setTitle(R.string.menu_home);
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MapActivity()).commit();
//            navigationView.setCheckedItem(R.id.nav_home);
//        }//end if
////
//        txtName = navigationView.getHeaderView(0).findViewById(R.id.navName);
////
////
//        if (!MySharedPrefence.getString(this, Constants.Keys.USER_FNAME, "").equals("") && !MySharedPrefence.getString(this, Constants.Keys.USER_LNAME, "").equals("")) {
//            txtName.setText(MySharedPrefence.getString(this, Constants.Keys.USER_FNAME, "") + " " + MySharedPrefence.getString(this, Constants.Keys.USER_LNAME, ""));
//        }//end if
//
//
//    }
//
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////
////        getMenuInflater().inflate(R.menu.main, menu);
////        return true;
////    }
//
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////
////        int id = item.getItemId();
////
////
////        if (id == R.id.action_settings) {
////            return true;
////        }
////
////        return super.onOptionsItemSelected(item);
////    }
//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//
//        if (id == R.id.nav_home) {
//            setTitle(R.string.menu_home);
//          //  getSupportFragmentManager().beginTransaction().replace(R.id.container, new map()).commit();
////            startActivity(new Intent(MainActivity.this,MapActivity.class));
//
//            MapActivity mapActivity = new MapActivity();
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, mapActivity).commit();
//
//
//        } else if (id == R.id.nav_history) {
//            setTitle(R.string.menu_history);
//            History history = new History();
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, history).commit();
//
//        } else if (id == R.id.nav_Payment) {
//            setTitle(R.string.menu_Payment);
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Payment()).commit();
//
//        } else if (id == R.id.nav_Offers) {
//            setTitle(R.string.menu_Offers);
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Offers()).commit();
//
//        } else if (id == R.id.nav_setting) {
//            setTitle(R.string.menu_setting);
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Settings()).commit();
//
//        } else if (id == R.id.nav_Contact_us) {
//            setTitle(R.string.menu_Contactus);
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Contact_us()).commit();
//
//
//    } else if (id == R.id.nav_driver) {
//        setTitle(R.string.menu_driver);
//        getSupportFragmentManager().beginTransaction().replace(R.id.container, new BecomeDriver()).commit();
//
//    }
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//
//
//}
