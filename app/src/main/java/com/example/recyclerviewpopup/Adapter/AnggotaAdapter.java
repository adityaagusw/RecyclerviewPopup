package com.example.recyclerviewpopup.Adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewpopup.Model.Anggota;
import com.example.recyclerviewpopup.R;

import java.util.List;

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.MyViewHolder> {

    private List<Anggota> anggotaList;
    Dialog myDialog;

    public AnggotaAdapter(List<Anggota> anggotaList) {
        this.anggotaList = anggotaList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.foto_item, parent, false);
        MyViewHolder holder = new MyViewHolder(mView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        final String urlGambar = "https://himtif.org/admin/" + anggotaList.get(position).getImage();

        Glide.with(holder.itemView.getContext()).load(urlGambar).into(holder.imgAnggota);

        holder.imgAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDialog = new Dialog(holder.itemView.getContext());
                myDialog.setContentView(R.layout.popup);
                ImageView imageView = myDialog.findViewById(R.id.imgAnggotaPopUp);
                TextView txtAnggota = myDialog.findViewById(R.id.txtNamaAnggota);

                Glide.with(holder.itemView.getContext()).load(urlGambar).into(imageView);
                txtAnggota.setText(anggotaList.get(holder.getAdapterPosition()).getNama());
                myDialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return anggotaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgAnggota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAnggota = itemView.findViewById(R.id.img_anggota);

        }
    }
}
