package julio.salazar.guevara.imc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaginaWebFragment extends Fragment {
    WebView web;

    public PaginaWebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_pagina_web, container, false);

        web = vista.findViewById(R.id.wvWeb);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://www.reddit.com/r/Freegamestuff/");



        return vista;
    }
}

















