package com.kesteli.filip.fragmentrecycler;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.kesteli.filip.fragmentrecycler.posloviFragment.AutomobilFragment;
import com.kesteli.filip.fragmentrecycler.posloviFragment.FizikaFragment;
import com.kesteli.filip.fragmentrecycler.posloviFragment.GradevinaFragment;
import com.kesteli.filip.fragmentrecycler.posloviFragment.KemijaFragment;
import com.kesteli.filip.fragmentrecycler.posloviFragment.KompjutorFragment;
import com.kesteli.filip.fragmentrecycler.posloviFragment.MatematikaFragment;
import com.kesteli.filip.fragmentrecycler.posloviFragment.PaziteljFragment;
import com.kesteli.filip.fragmentrecycler.posloviFragment.PoljoprivredaFragment;
import com.kesteli.filip.fragmentrecycler.posloviFragment.VesMasinaFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private POJO pojo = new POJO();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setupViewPager();
        setupTabLayout();
        setupTabIcons();

//        setupSharedPreferences();
//        handleIntents();
        setupFragments();
    }

    /**
     * Kad stisnem recimo chemistry, jedini nacin da znam da je to chemistry je da posaljem intentExtra!
     * Recimo kod ostalih activityja to nije toliko bitno (Education, RealityCheck, Motivator, itd.)
     */

    private void setupFragments() {
        adapter.addFrag(new AutomobilFragment(), pojo.getPoslovi()[0]);
        adapter.addFrag(new KompjutorFragment(), pojo.getPoslovi()[1]);
        adapter.addFrag(new VesMasinaFragment(), pojo.getPoslovi()[1]);
        adapter.addFrag(new FizikaFragment(), pojo.getPoslovi()[2]);
        adapter.addFrag(new MatematikaFragment(), pojo.getPoslovi()[3]);
        adapter.addFrag(new KemijaFragment(), pojo.getPoslovi()[4]);
        adapter.addFrag(new PoljoprivredaFragment(), pojo.getPoslovi()[5]);
        adapter.addFrag(new PaziteljFragment(), pojo.getPoslovi()[6]);
        adapter.addFrag(new GradevinaFragment(), pojo.getPoslovi()[7]);

        viewPager.setAdapter(adapter);
        for (int i = 0; i < pojo.getPoslovi().length; i++) {
            tabLayout.getTabAt(i).setIcon(pojo.getImages()[i]);
        }
        /*Intent intent = getIntent();
        if (intent.hasExtra(POJO.getFizika_clanci())) {
            adapter.addFrag(new Frag1(), POJO.getFizika()[0]);
            adapter.addFrag(new Frag2(), POJO.getFizika()[1]);
            adapter.addFrag(new Frag3(), POJO.getFizika()[2]);
            adapter.addFrag(new Frag4(), POJO.getFizika()[3]);
            adapter.addFrag(new Frag5(), POJO.getFizika()[4]);
            adapter.addFrag(new Frag6(), POJO.getFizika()[5]);
            adapter.addFrag(new Frag7(), POJO.getFizika()[6]);
            adapter.addFrag(new Frag8(), POJO.getFizika()[7]);
            adapter.addFrag(new Frag9(), POJO.getFizika()[8]);
            adapter.addFrag(new Frag10(), POJO.getFizika()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < POJO.getFizika().length; i++) {
                tabLayout.getTabAt(i).setIcon(POJO.getImages()[0]);
            }
        } else if (intent.hasExtra(POJO.getKemija_clanci())) {
            adapter.addFrag(new Frag1(), POJO.getKemija()[0]);
            adapter.addFrag(new Frag2(), POJO.getKemija()[1]);
            adapter.addFrag(new Frag3(), POJO.getKemija()[2]);
            adapter.addFrag(new Frag4(), POJO.getKemija()[3]);
            adapter.addFrag(new Frag5(), POJO.getKemija()[4]);
            adapter.addFrag(new Frag6(), POJO.getKemija()[5]);
            adapter.addFrag(new Frag7(), POJO.getKemija()[6]);
            adapter.addFrag(new Frag8(), POJO.getKemija()[7]);
            adapter.addFrag(new Frag9(), POJO.getKemija()[8]);
            adapter.addFrag(new Frag10(), POJO.getKemija()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < POJO.getKemija().length; i++) {
                tabLayout.getTabAt(i).setIcon(POJO.getImages()[1]);
            }
        } else if (intent.hasExtra(POJO.getMatematika_clanci())) {
            adapter.addFrag(new Frag1(), POJO.getMatematika()[0]);
            adapter.addFrag(new Frag2(), POJO.getMatematika()[1]);
            adapter.addFrag(new Frag3(), POJO.getMatematika()[2]);
            adapter.addFrag(new Frag4(), POJO.getMatematika()[3]);
            adapter.addFrag(new Frag5(), POJO.getMatematika()[4]);
            adapter.addFrag(new Frag6(), POJO.getMatematika()[5]);
            adapter.addFrag(new Frag7(), POJO.getMatematika()[6]);
            adapter.addFrag(new Frag8(), POJO.getMatematika()[7]);
            adapter.addFrag(new Frag9(), POJO.getMatematika()[8]);
            adapter.addFrag(new Frag10(), POJO.getMatematika()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < POJO.getMatematika().length; i++) {
                tabLayout.getTabAt(i).setIcon(POJO.getImages()[2]);
            }
        } else if (intent.hasExtra(POJO.getTehnika_clanci())) {
            adapter.addFrag(new Frag1(), POJO.getTehnika()[0]);
            adapter.addFrag(new Frag2(), POJO.getTehnika()[1]);
            adapter.addFrag(new Frag3(), POJO.getTehnika()[2]);
            adapter.addFrag(new Frag4(), POJO.getTehnika()[3]);
            adapter.addFrag(new Frag5(), POJO.getTehnika()[4]);
            adapter.addFrag(new Frag6(), POJO.getTehnika()[5]);
            adapter.addFrag(new Frag7(), POJO.getTehnika()[6]);
            adapter.addFrag(new Frag8(), POJO.getTehnika()[7]);
            adapter.addFrag(new Frag9(), POJO.getTehnika()[8]);
            adapter.addFrag(new Frag10(), POJO.getTehnika()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < POJO.getTehnika().length; i++) {
                tabLayout.getTabAt(i).setIcon(POJO.getImages()[3]);
            }
        } else if (intent.hasExtra(POJO.getMedicina_clanci())) {
            adapter.addFrag(new Frag1(), POJO.getMedicina()[0]);
            adapter.addFrag(new Frag2(), POJO.getMedicina()[1]);
            adapter.addFrag(new Frag3(), POJO.getMedicina()[2]);
            adapter.addFrag(new Frag4(), POJO.getMedicina()[3]);
            adapter.addFrag(new Frag5(), POJO.getMedicina()[4]);
            adapter.addFrag(new Frag6(), POJO.getMedicina()[5]);
            adapter.addFrag(new Frag7(), POJO.getMedicina()[6]);
            adapter.addFrag(new Frag8(), POJO.getMedicina()[7]);
            adapter.addFrag(new Frag9(), POJO.getMedicina()[8]);
            adapter.addFrag(new Frag10(), POJO.getMedicina()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < POJO.getMedicina().length; i++) {
                tabLayout.getTabAt(i).setIcon(POJO.getImages()[4]);
            }
        } else if (intent.hasExtra(POJO.getBiologija_clanci())) {
            adapter.addFrag(new Frag1(), POJO.getBiologija()[0]);
            adapter.addFrag(new Frag2(), POJO.getBiologija()[1]);
            adapter.addFrag(new Frag3(), POJO.getBiologija()[2]);
            adapter.addFrag(new Frag4(), POJO.getBiologija()[3]);
            adapter.addFrag(new Frag5(), POJO.getBiologija()[4]);
            adapter.addFrag(new Frag6(), POJO.getBiologija()[5]);
            adapter.addFrag(new Frag7(), POJO.getBiologija()[6]);
            adapter.addFrag(new Frag8(), POJO.getBiologija()[7]);
            adapter.addFrag(new Frag9(), POJO.getBiologija()[8]);
            adapter.addFrag(new Frag10(), POJO.getBiologija()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < POJO.getBiologija().length; i++) {
                tabLayout.getTabAt(i).setIcon(POJO.getImages()[5]);
            }
        } else if (intent.hasExtra(POJO.getAstronomija_clanci())) {
            adapter.addFrag(new Frag1(), POJO.getAstronomija()[0]);
            adapter.addFrag(new Frag2(), POJO.getAstronomija()[1]);
            adapter.addFrag(new Frag3(), POJO.getAstronomija()[2]);
            adapter.addFrag(new Frag4(), POJO.getAstronomija()[3]);
            adapter.addFrag(new Frag5(), POJO.getAstronomija()[4]);
            adapter.addFrag(new Frag6(), POJO.getAstronomija()[5]);
            adapter.addFrag(new Frag7(), POJO.getAstronomija()[6]);
            adapter.addFrag(new Frag8(), POJO.getAstronomija()[7]);
            adapter.addFrag(new Frag9(), POJO.getAstronomija()[8]);
            adapter.addFrag(new Frag10(), POJO.getAstronomija()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < POJO.getAstronomija().length; i++) {
                tabLayout.getTabAt(i).setIcon(POJO.getImages()[6]);
            }
        } else if (intent.hasExtra(POJO.getGeologija_clanci())) {
            adapter.addFrag(new Frag1(), POJO.getGeologija()[0]);
            adapter.addFrag(new Frag2(), POJO.getGeologija()[1]);
            adapter.addFrag(new Frag3(), POJO.getGeologija()[2]);
            adapter.addFrag(new Frag4(), POJO.getGeologija()[3]);
            adapter.addFrag(new Frag5(), POJO.getGeologija()[4]);
            adapter.addFrag(new Frag6(), POJO.getGeologija()[5]);
            adapter.addFrag(new Frag7(), POJO.getGeologija()[6]);
            adapter.addFrag(new Frag8(), POJO.getGeologija()[7]);
            adapter.addFrag(new Frag9(), POJO.getGeologija()[8]);
            adapter.addFrag(new Frag10(), POJO.getGeologija()[9]);
            viewPager.setAdapter(adapter);
            for (int i = 0; i < POJO.getGeologija().length; i++) {
                tabLayout.getTabAt(i).setIcon(POJO.getImages()[7]);
            }
        }*/
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupTabLayout() {
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

/*
        for (int i = 0; i < clanci.length; i++) {
            adapter.addFrag(new WebFragment(), clanci[i]);
        }
        viewPager.setAdapter(adapter);
*/
    }

    private void setupTabIcons() {
/*
        for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
//            tabLayout.getTabAt(i).setIcon(images[1]);
            tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[4]);
        }
*/
    }

    /*private void setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        *//*editor.putString(Name, n);
        editor.putString(Phone, ph);
        editor.putString(Email, e);
        editor.commit();*//*
    }*/

    /*private void handleIntents() {
        Intent intent = getIntent();
        if (intent.hasExtra(ClanciHelperPOJO.getFizika_clanci())) {
            editor.putString(ClanciHelperPOJO.getMyPREFERENCES(), ClanciHelperPOJO.getFizika_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                WebFragment webFragment = new WebFragment();
                editor.putString(ClanciHelperPOJO.getMyClanakPREFERENCE(), clanciHelperPOJO.getClanci_fizika()[i]);
//                Set<String> stringSet = {"da"};
                editor.commit();
                adapter.addFrag(webFragment, clanciHelperPOJO.getFizika()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[0]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getKemija_clanci())) {
            editor.putString(ClanciHelperPOJO.getKemija_clanci(), ClanciHelperPOJO.getKemija_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getKemija()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[1]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getMatematika_clanci())) {
            editor.putString(ClanciHelperPOJO.getMatematika_clanci(), ClanciHelperPOJO.getMatematika_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getMatematika()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[2]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getTehnika_clanci())) {
            editor.putString(ClanciHelperPOJO.getTehnika_clanci(), ClanciHelperPOJO.getTehnika_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getTehnika()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[3]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getMedicina_clanci())) {
            editor.putString(ClanciHelperPOJO.getMedicina_clanci(), ClanciHelperPOJO.getMedicina_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getMedicina()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[4]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getBiologija_clanci())) {
            editor.putString(ClanciHelperPOJO.getBiologija_clanci(), ClanciHelperPOJO.getBiologija_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getBiologija()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[5]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getAstronomija_clanci())) {
            editor.putString(ClanciHelperPOJO.getAstronomija_clanci(), ClanciHelperPOJO.getAstronomija_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getAstronomija()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[6]);
            }
        } else if (intent.hasExtra(ClanciHelperPOJO.getGeologija_clanci())) {
            editor.putString(ClanciHelperPOJO.getGeologija_clanci(), ClanciHelperPOJO.getGeologija_clanci());
            editor.commit();
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                adapter.addFrag(new WebFragment(), clanciHelperPOJO.getGeologija()[i]);
            }
            viewPager.setAdapter(adapter);
            for (int i = 0; i < clanciHelperPOJO.getImages().length; i++) {
                tabLayout.getTabAt(i).setIcon(clanciHelperPOJO.getImages()[7]);
            }
        }
    }*/

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.moj_vlastiti_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        }
        return true;
    }

}



