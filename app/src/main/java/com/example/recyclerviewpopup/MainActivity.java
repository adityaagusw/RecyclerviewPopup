package com.example.recyclerviewpopup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewpopup.Adapter.AnggotaAdapter;
import com.example.recyclerviewpopup.Model.Anggota;
import com.example.recyclerviewpopup.backend.ApiClient;
import com.example.recyclerviewpopup.backend.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview_id);

        mLayoutManager = new GridLayoutManager(this,3);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(false);

        viewAll();

    }

    private void viewAll() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Anggota> call = apiInterface.viewAnggota();

        call.enqueue(new Callback<Anggota>() {
            @Override
            public void onResponse(Call<Anggota> call, Response<Anggota> response) {
                List<Anggota> viewAnggota = response.body().getDataAnggota();
                mAdapter = new AnggotaAdapter(viewAnggota);
                mAdapter.notifyDataSetChanged();
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<Anggota> call, Throwable t) {

            }
        });


    }
}
