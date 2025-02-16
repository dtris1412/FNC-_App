package com.example.fnc_app.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fnc_app.ItemStorage;
import com.example.fnc_app.R;
import com.example.fnc_app.StorageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StorageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StorageFragment extends Fragment {

    private RecyclerView recyclerView;
    private StorageAdapter adapter;
    private List<ItemStorage> itemList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public StorageFragment() {
        // Required empty public constructor
    }

    public static StorageFragment newInstance(String param1, String param2) {
        StorageFragment fragment = new StorageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storage, container, false);

        // Ánh xạ RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Tạo danh sách item
        itemList = new ArrayList<>();
        itemList.add(new ItemStorage("T-Shirt", R.drawable.tshirt));
        itemList.add(new ItemStorage("Hoodie", R.drawable.hoodie));
        itemList.add(new ItemStorage("Jacket", R.drawable.jacket));

        // Cấu hình Adapter
        adapter = new StorageAdapter(itemList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
