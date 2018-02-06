package pw.cyberbrain.androidstudy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    List<Fragment> mTabs = new ArrayList<>();
    TabsAdapter mTabsAdapter;
    ViewPager mViewPager;


    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mTabs.add(new BlueFragment());
        mTabs.add(new RedFragment());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_third, container, false);

        mTabsAdapter = new TabsAdapter(getFragmentManager());
        mViewPager = mView.findViewById(R.id.my_pager);
        mViewPager.setAdapter(mTabsAdapter);

        return mView;
    }

    public class TabsAdapter extends FragmentStatePagerAdapter{

        public TabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mTabs.get(position);
        }

        @Override
        public int getCount() {
            return mTabs.size();
        }
    }
}
