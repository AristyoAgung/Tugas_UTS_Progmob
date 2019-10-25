package com.e.tugasprogmob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.tugasprogmob.Model.Dosen;
import com.e.tugasprogmob.R;

import java.util.ArrayList;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.ViewHolder> {

    private ArrayList<Dosen> dataList;

    public DosenAdapter(ArrayList<Dosen> dataList){
        this.dataList=dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_dosen,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNIDN.setText(dataList.get(position).getNIDN());
        holder.txtGelar.setText(dataList.get(position).getGelar());
        holder.txtEmail.setText(dataList.get(position).getEmail());
        holder.txtAlamat.setText(dataList.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNIDN, txtGelar, txtEmail, txtAlamat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNIDN = itemView.findViewById(R.id.txtNIDN);
            txtGelar = itemView.findViewById(R.id.txtGelar);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtAlamat = itemView.findViewById(R.id.txtAlamat);

        }
    }
}
