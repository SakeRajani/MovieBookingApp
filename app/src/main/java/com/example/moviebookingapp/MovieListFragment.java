package com.example.moviebookingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MovieListFragment extends Fragment  {
View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_movieslist,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        @SuppressLint("ResourceType") ImageView imageview = (ImageView) view.findViewById(R.drawable.adipurush);
       TextView textView= view.findViewById(R.id.textView2);
       textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"Hi",Toast.LENGTH_LONG).show();
               Bundle bundle=new Bundle();
               bundle.putString("message",textView.getText().toString());
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                MovieDescriptionFragment movieDescriptionFragment=new MovieDescriptionFragment();
                movieDescriptionFragment.setArguments(bundle);
                fr.replace(R.id.fragment1,movieDescriptionFragment);
                fr.commit();
            }
        });

    }


}
