package pw.cyberbrain.androidstudy;


import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class BaseFragment extends Fragment {


    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

        String mTitle = "";

        View mView = getView();
        AppCompatActivity mActivity = (AppCompatActivity) getActivity();
        ActionBar mToolbar = mActivity.getSupportActionBar();

        try {
            TextView mText = mView.findViewById(R.id.content);
            mTitle = mText.getText().toString();
            mToolbar.setTitle(mTitle);
        } catch (Exception e) {
            Log.e("Title", e.toString());
        }
    }

}
