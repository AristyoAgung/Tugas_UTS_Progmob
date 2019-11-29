package com.e.tugasprogmob.Adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.tugasprogmob.Model.Dosen;
import com.e.tugasprogmob.R;

import java.util.ArrayList;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.ViewHolder> {

    private ArrayList<Dosen> dataList;
    //private Context context;

    public DosenAdapter(ArrayList<Dosen> dataList){
        this.dataList=dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_dosen,parent,false);
        //context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNIDN.setText(dataList.get(position).getNidn());
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtGelar.setText(dataList.get(position).getGelar());
        holder.txtEmail.setText(dataList.get(position).getEmail());
        holder.txtAlamat.setText(dataList.get(position).getAlamat());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    implements View.OnCreateContextMenuListener{
        private TextView txtNIDN,txtNama, txtGelar, txtEmail, txtAlamat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNIDN = itemView.findViewById(R.id.txtNIDN);
            txtNama = itemView.findViewById(R.id.txtNama);
            txtGelar = itemView.findViewById(R.id.txtGelar);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtAlamat = itemView.findViewById(R.id.txtAlamat);
            itemView.setOnCreateContextMenuListener(this);

        }
        @Override
        public void onCreateContextMenu(ContextMenu Menu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            Menu.setHeaderTitle("Update atau Delete?");
            Menu.add(this.getAdapterPosition(),view.getId(),0,"Update");
            Menu.add(this.getAdapterPosition(),view.getId(),0,"Delete");
        }

    }

}
