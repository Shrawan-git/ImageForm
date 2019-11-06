package com.digitalorder.imageform.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalorder.imageform.model.Contacts;
import com.digitalorder.imageform.R;
import com.digitalorder.imageform.model.Contacts;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactsViewHolder> {
    Context context;
    List<Contacts> detailsList;

    //Constructor for data from activity
    public ContactAdapter(Context context, List<Contacts> detailsList) {
        this.context = context;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    //To create new RecycleView.ContactsViewHolder and initialize to be used by RecycleView
    public ContactAdapter.ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewdetail, parent, false);
        //LayoutInflator is for taking the xml layout and create view
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactsViewHolder holder, int position) {
        final Contacts detailclass = detailsList.get(position);
        //To hold data in detailclass
        holder.imgview.setImageResource(detailclass.getImagenumber());
        holder.txnames.setText(detailclass.getName());
        holder.txgenders.setText(detailclass.getGender());
        holder.txages.setText(detailclass.getAge());
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    //Inner Class
    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgview;
        TextView txnames, txages, txgenders;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.imgview);
            txnames = itemView.findViewById(R.id.name);
            txages = itemView.findViewById(R.id.age);
            txgenders = itemView.findViewById(R.id.gender);

        }
    }
}
