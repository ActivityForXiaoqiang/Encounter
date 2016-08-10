package ecncounter.wilson.com.encounter.EUI.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ecncounter.wilson.com.encounter.R;


/**
 * Created by xiaoqiang on 16/8/1.
 */
public class LeftFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.main_rightview, container, false);


        return view;
    }



}
