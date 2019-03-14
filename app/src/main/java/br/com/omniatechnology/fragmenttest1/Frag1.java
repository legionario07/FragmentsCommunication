package br.com.omniatechnology.fragmenttest1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Frag1 extends Fragment implements View.OnClickListener, InterfacesClass.FragmentLifecycle  {
    // TODO: Rename parameter arguments, choose names that match

    private IFragmentCommunication fragmentCommunication;
    private TextInputEditText inpName;
    private TextInputEditText inpEmail;
    private ImageButton btnNext;

    public Frag1() {
        // Required empty public constructor
    }


    public static Frag1 newInstance(String param1, String param2) {
        Frag1 fragment = new Frag1();
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

        View view =  inflater.inflate(R.layout.fragment_frag1, container, false);

        inpName = view.findViewById(R.id.inp_name);
        inpEmail = view.findViewById(R.id.inp_email);
        btnNext = view.findViewById(R.id.btn_next);

        btnNext.setOnClickListener(this);

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
            case R.id.btn_next:

                fragmentCommunication.getUser().setName(inpName.getText().toString());
                fragmentCommunication.getUser().setEmail(inpEmail.getText().toString());

                fragmentCommunication.openFragment(1);

                break;
        }

    }


    @Override
    public void onPauseFragment() {
    }

    @Override
    public void onResumeFragment() {
    }
}
