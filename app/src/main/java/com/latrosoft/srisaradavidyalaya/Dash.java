package com.latrosoft.srisaradavidyalaya;

import android.content.res.TypedArray;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.latrosoft.srisaradavidyalaya.adapter.DashListAdapter;
import com.latrosoft.srisaradavidyalaya.base.BaseActivity;
import com.latrosoft.srisaradavidyalaya.databinding.ActivityDashBinding;

public class Dash extends BaseActivity<ActivityDashBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_dash;
    }

    @Override
    protected void initViews() {
        addSupportActionBar(binding.mToolbar);
        ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.mToolbar, R.string.app_name, R.string.app_name);
        binding.drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        binding.mToolbar.setNavigationIcon(R.drawable.ic_nav);
        setUpListView();
    }

    private void setUpListView() {
        binding.mListItemsView.setLayoutManager(new LinearLayoutManager(this) {
            /*For disabling recyclerview scroll as it is inside nested scrollview */
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        /** Required list items from resource folder
         * every list should be having same count of items */
        TypedArray bgDrawableList = getResources().obtainTypedArray(R.array.listItemBgDrawables);
        TypedArray iconDrawableList = getResources().obtainTypedArray(R.array.listItemIconDrawables);
        String[] headerList = getResources().getStringArray(R.array.listItemHeaders);
        String[] titleList = getResources().getStringArray(R.array.listItemTitles);
        DashListAdapter mAdapter = new DashListAdapter(bgDrawableList, iconDrawableList, headerList, titleList, position -> {
            /*Every click will be reflecting here for the list*/
            if (position == 0) {
                /*do what u want to do*/

            }
        });
        binding.mListItemsView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dash, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_notification: {

            }
            break;
            case android.R.id.home: {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                } else binding.drawerLayout.openDrawer(GravityCompat.START);
            }
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
