package com.farhan.thinkder;

import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class FirstThinker extends Activity {

    /*
        Change this to 5 when there are 5 thinkers ready.
     */
    private static final int NUM_PAGES = 11;
    /**
     * The {@link ViewPager} is the container which holds each thinker's card and allows us
     * to swipe between each one..
     */
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;


    /*
        These strings are used to send information about next level from each thinker.
     */
    public static final String NXT1 = "com.example.farhan.thinkers2";
    public static final String NXT2 = "com.example.farhan.thinkers2";


    /*
     * Don't change this method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_thinker);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mPagerAdapter = new ScreenSlidePagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mPagerAdapter);

        /* Comment back in when we are ready to push.
         */
        Tracker tracker = GoogleAnalytics.getInstance(this).newTracker("UA-56793101-1");
        tracker.setScreenName("First Level");
        tracker.send(new HitBuilders.AppViewBuilder().build());

        getActionBar().setTitle("Think'der");
    }

    /*
     * Don't change this method
     */
    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }


    /*
     * Don't change this method
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_thinker, menu);
        return true;
    }

    /*
     * Don't change this method
     */
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

    public void nextLevel(View view) {
        Intent intent = new Intent(view.getContext(), HesseNextLevel.class);
        Bundle bundle = new Bundle();
        int id = Integer.parseInt(view.getTag().toString());
        String more = "Failed to get tag!";
        String most = "Failed to get tag!";
        switch (id) {
            case 1:
                more = getResources().getString(R.string.hesse_more);
                most = getResources().getString(R.string.hesse_most);
                break;
            case 2:
                more = getResources().getString(R.string.nietzsche_more);
                most = getResources().getString(R.string.nietzsche_most);
                break;
            case 3:
                more = getResources().getString(R.string.butler_more);
                most = getResources().getString(R.string.butler_most);
                break;
            case 4:
                more = getResources().getString(R.string.rand_more);
                most = getResources().getString(R.string.rand_most);
                break;            
            case 5:
                more = getResources().getString(R.string.wilde_more);
                most = getResources().getString(R.string.wilde_most);
                break;
            case 6:
                more = getResources().getString(R.string.zhuangzi_more);
                most = getResources().getString(R.string.zhuangzi_most);
                break;
            case 7:
                more = getResources().getString(R.string.aurelius_more);
                most = getResources().getString(R.string.aurelius_most);
                break;
            case 8:
                more = getResources().getString(R.string.socrates_more);
                most = getResources().getString(R.string.socrates_most);
                break;
            case 9:
                more = getResources().getString(R.string.spinoza_more);
                most = getResources().getString(R.string.spinoza_most);
                break;            
            case 10:
                more = getResources().getString(R.string.angelou_more);
                most = getResources().getString(R.string.angelou_most);
                break;
            /*
            Replace "thinker4" and "thinker5" with the new thinkers
            case 4:
                more = getResources().getString(R.string.thinker4_more);
                most = getResources().getString(R.string.thinker4_most);
                break;
            case 5:
                more = getResources().getString(R.string.thinker5_more);
                most = getResources().getString(R.string.thinker5_most);
                break;
             */
        }
        bundle.putString("NXT1", more);
        bundle.putString("NXT2", most);
        intent.putExtras(bundle);
        startActivity(intent);
    }

/**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            switch (position) {
                case 0:
                    return new HesseFragment();
                case 1:
                    return new NietzscheFragment();
                case 2:
                    return new ButlerFragment();
                case 3:
                    return new RandFragment();
                case 4:
                    return new WildeFragment();
                case 5:
                    return new ZhuangziFragment();
                case 6:
                    return new AureliusFragment();
                case 7:
                    return new SocratesFragment();
                case 8:
                    return new SpinozaFragment();
                case 9:
                    return new AngelouFragment();
                case 10:
                    return new FeedbackFragment();
                /*
                Replace "Thinker4" and "Thinker5" with new thinkers
                case 3:
                    return new Thinker4Fragment();
                case 4:
                    return new Thinker5Fragment();
                 */
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        /*
            Not sure if this should be changed when adding thinkers. My guess is it should be.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_activity_first_thinker).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * Each thinker has a fragment identical to this.
     */
    public static class HesseFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static HesseFragment newInstance(int sectionNumber) {
            HesseFragment fragment = new HesseFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public HesseFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_first_thinker, container, false);
            return rootView;
        }

    }

    public static class NietzscheFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static NietzscheFragment newInstance(int sectionNumber) {
            NietzscheFragment fragment = new NietzscheFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public NietzscheFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_nietzsche, container, false);
            return rootView;
        }

    }

    public static class ButlerFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static ButlerFragment newInstance(int sectionNumber) {
            ButlerFragment fragment = new ButlerFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public ButlerFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_butler, container, false);
            return rootView;
        }

    }

    public static class RandFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static RandFragment newInstance(int sectionNumber) {
            RandFragment fragment = new RandFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public RandFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_rand, container, false);
            return rootView;
        }

    }

    public static class WildeFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static WildeFragment newInstance(int sectionNumber) {
            WildeFragment fragment = new WildeFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public WildeFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_wilde, container, false);
            return rootView;
        }
    }

    public static class ZhuangziFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static ZhuangziFragment newInstance(int sectionNumber) {
            ZhuangziFragment fragment = new ZhuangziFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public ZhuangziFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_zhuangzi, container, false);
            return rootView;
        }
    }

    public static class AureliusFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static AureliusFragment newInstance(int sectionNumber) {
            AureliusFragment fragment = new AureliusFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public AureliusFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_aurelius, container, false);
            return rootView;
        }
    }
    public static class SocratesFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static SocratesFragment newInstance(int sectionNumber) {
            SocratesFragment fragment = new SocratesFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public SocratesFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_socrates, container, false);
            return rootView;
        }
    }
    public static class SpinozaFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static SpinozaFragment newInstance(int sectionNumber) {
            SpinozaFragment fragment = new SpinozaFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public SpinozaFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_spinoza, container, false);
            return rootView;
        }
    }

    public static class AngelouFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static AngelouFragment newInstance(int sectionNumber) {
            AngelouFragment fragment = new AngelouFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public AngelouFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_angelou, container, false);
            return rootView;
        }
    }

    public static class FeedbackFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FeedbackFragment newInstance(int sectionNumber) {
            FeedbackFragment fragment = new FeedbackFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public FeedbackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_feedback, container, false);
            TextView t = (TextView) rootView.findViewById(R.id.link);
            Linkify.addLinks(t, Linkify.WEB_URLS);
            return rootView;
        }

    }

/*  
    public static class Thinker5Fragment extends Fragment {

            private static final String ARG_SECTION_NUMBER = "section_number";

            public static Thinker5Fragment newInstance(int sectionNumber) {
                Thinker5Fragment fragment = new Thinker5Fragment();
                Bundle args = new Bundle();
                args.putInt(ARG_SECTION_NUMBER, sectionNumber);
                fragment.setArguments(args);
                return fragment;
            }

            public Thinker5Fragment() {
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.fragment_thinker5, container, false);
                return rootView;
            }

    }  */

}
