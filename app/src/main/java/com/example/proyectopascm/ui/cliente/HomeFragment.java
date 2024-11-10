package com.example.proyectopascm.ui.cliente;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proyectopascm.R;
import com.example.proyectopascm.databinding.FragmentHome3Binding;
import com.example.proyectopascm.ui.cliente.HomeViewModel;

public class HomeFragment extends Fragment {

    private FragmentHome3Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHome3Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHomeCliente;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}