package wastengage.valian.com.wastengage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import wastengage.valian.com.wastengage.CollectionRequest.CollectionMainFrag;
import wastengage.valian.com.wastengage.aboutus.AboutUsFrag;
import wastengage.valian.com.wastengage.helper.BottomNavigationBehavior;
import wastengage.valian.com.wastengage.main.Main2Activity;
import wastengage.valian.com.wastengage.product_listing.FragmentProductListing;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView navigation;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

      //  initToolbar();
        initNavigationView();

        /*Intent i = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(i);*/
    }

    /*private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("This is enough");
        toolbar.setTitleTextColor(getResources().getColor(R.color.blue));
        toolbar.setLogo(R.mipmap.ic_launcher);
    }*/

    private void initNavigationView() {
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_garbage_request);
        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_garbage_request:
                fragment = new CollectionMainFrag();
                loadFragment(fragment);
                return true;
            case R.id.navigation_product_listing:
                fragment = new FragmentProductListing();
                loadFragment(fragment);
                return true;
            case R.id.navigation_about:
                fragment = new AboutUsFrag();
                loadFragment(fragment);
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(MainActivity.this,"back press",Toast.LENGTH_SHORT).show();
    }
}