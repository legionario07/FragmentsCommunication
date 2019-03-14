package br.com.omniatechnology.fragmenttest1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Frag3 extends Fragment implements InterfacesClass.FragmentLifecycle{

    private IFragmentCommunication fragmentCommunication;

    private TextView txtName, txtEmail, txtCity;

    public Frag3() {
        // Required empty public constructor
    }


    public static Frag3 newInstance(String param1, String param2) {
        Frag3 fragment = new Frag3();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_frag3, container, false);

        txtName = view.findViewById(R.id.txt_name);
        txtEmail = view.findViewById(R.id.txt_email);
        txtCity = view.findViewById(R.id.txt_city);


        return view;
    }

    @Override
    public void onPauseFragment() {
    }

    @Override
    public void onResumeFragment() {
        txtName.setText(fragmentCommunication.getUser().getName());
        txtEmail.setText(fragmentCommunication.getUser().getEmail());
        txtCity.setText(fragmentCommunication.getUser().getCity());

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof IFragmentCommunication){
            fragmentCommunication = (IFragmentCommunication) context;
        }

    }

}
