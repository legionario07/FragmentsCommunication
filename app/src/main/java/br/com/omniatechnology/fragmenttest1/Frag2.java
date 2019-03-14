package br.com.omniatechnology.fragmenttest1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Frag2 extends Fragment implements View.OnClickListener, InterfacesClass.FragmentLifecycle {

    private IFragmentCommunication fragmentCommunication;

    private TextInputEditText inpCity;
    private ImageButton btnSave;

    public Frag2() {
        // Required empty public constructor
    }


    public static Frag2 newInstance(String param1, String param2) {
        Frag2 fragment = new Frag2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onPauseFragment() {
    }

    @Override
    public void onResumeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag2, container, false);

        inpCity = view.findViewById(R.id.inp_city);
        btnSave = view.findViewById(R.id.btn_save);

        btnSave.setOnClickListener(this);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof IFragmentCommunication){
            fragmentCommunication = (IFragmentCommunication) context;
        }

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_save:

                fragmentCommunication.getUser().setCity(inpCity.getText().toString());
                fragmentCommunication.openFragment(2);

                break;

        }
    }
}
