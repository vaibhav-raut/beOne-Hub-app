package udaan.beone.mrpoint.activity;
/**
 * Author Vivz
 * Date 15/06/15
 */

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.util.AndroidUtil;


public class HubActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Main Activity Init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        // Toolbar Init
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);

        // Nav Drawer Init
        mDrawer = (NavigationView) findViewById(R.id.hub_menu_drawer);
        mDrawer.setNavigationItemSelectedListener(this);
        // Nav DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        hideDrawer();

        mSelectedId = -1;
        navigate(mSelectedId);
    }

    @Override
    protected void onPostResume () {
        super.onPostResume();
    }

    private void showDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    private void hideDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    private void navigate(int mSelectedId) {

        switch (mSelectedId) {
            case R.id.navigation_generate_for_stock_type: {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                AndroidUtil.launchActivity(this, StockTypeGenStockActivity.class);
                break;
            }
            case  R.id.navigation_generate_for_brand: {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                AndroidUtil.launchActivity(this, BrandGenStockActivity.class);
                break;
            }
            case  R.id.navigation_regenerate_for_stock_type: {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                AndroidUtil.launchActivity(this, RegenerateTagsActivity.class);
                break;
            }
            case  R.id.navigation_print_stock_type_tag: {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                AndroidUtil.launchActivity(this, PrintStockTypeTagActivity.class);
                break;
            }
            case  R.id.navigation_print_brand_tag: {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                AndroidUtil.launchActivity(this, PrintBrandTagActivity.class);
                break;
            }
            case  R.id.navigation_print_all_tag: {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                AndroidUtil.launchActivity(this, PrintAllTagActivity.class);
                break;
            }
            case  R.id.navigation_verify_stock: {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                AndroidUtil.launchActivity(this, VerifyTagActivity.class);
                break;
            }
            case  R.id.navigation_item_info: {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                AndroidUtil.launchActivity(this, ItemInfoActivity.class);
                break;
            }
            case  R.id.navigation_edit_stock_type: {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                AndroidUtil.launchActivity(this, EditStockInfoActivity.class);
                break;
            }
            case  R.id.navigation_logout: {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                AndroidUtil.logout(this);
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        menuItem.setChecked(true);
        mSelectedId = menuItem.getItemId();

        navigate(mSelectedId);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}
