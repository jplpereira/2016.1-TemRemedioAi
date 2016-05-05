package com.gppmds.tra.temremdioa.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.model.UBS;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

/**
 * Created by carolina on 01/05/16.
 */
public class CardListAdapterUBS extends RecyclerView.Adapter<CardListAdapterUBS.ViewHolder>{
    private List<UBS> dataUBS;
    private Context contextOpen;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;

        public ViewHolder(CardView card) {
            super(card);
            this.title = (TextView) card.findViewById(R.id.title);
            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(contextOpen, UBSMapsActivity.class);
            UBS selectItem = dataUBS.get(this.getAdapterPosition());

//            intent.putExtra("UBS", selectItem);
            intent.putExtra("latitude", selectItem.getLatitude());
            intent.putExtra("longitude", selectItem.getLongitude());
            intent.putExtra("nomeUBS", selectItem.getNomEstab());
            intent.putExtra("descEnderecoUBS", selectItem.getDscEndereco());
            intent.putExtra("descBairroUBS", selectItem.getDscBairro());
            intent.putExtra("telefoneUBS", selectItem.getDscTelefone());

            contextOpen.startActivity(intent);
        }
    }

    public CardListAdapterUBS(Context context, List<UBS> dataUBS) {
        this.contextOpen = context;
        this.dataUBS = dataUBS;
    }

    @Override
    public CardListAdapterUBS.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView view = (CardView) inflater.inflate(R.layout.card_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UBS rowData = this.dataUBS.get(position);
        holder.title.setText(rowData.getNomEstab());
    }

    @Override
    public int getItemCount() {
        return 150;
    }

}
