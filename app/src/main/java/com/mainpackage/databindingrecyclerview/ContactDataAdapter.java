package com.mainpackage.databindingrecyclerview;

import static com.mainpackage.databindingrecyclerview.databinding.ContactListItemBinding.bind;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mainpackage.databindingrecyclerview.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class ContactDataAdapter extends RecyclerView.Adapter<ContactDataAdapter.ContactViewHolder> {


    private ArrayList<Contact> contacts;


    public ContactDataAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int i) {
        Contact currentContact = contacts.get(i);
        holder.name.setTextDirection(currentContact.getName());
        holder.email.setTextDirection(currentContact.getEmail());


        holder.contactListItemBinding.setContact(currentContact);

    }

    @Override
    public int getItemCount() {
        if (contacts != null) {
            return contacts.size();
        } else {
            return 0;
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }


    static class ContactViewHolder extends RecyclerView.ViewHolder {

        private final View name;
        private final View email;
        private final ContactListItemBinding contactListItemBinding;

        //private TextView name, email;

        public ContactViewHolder(@NonNull View contactListItemBinding) {
            super(contactListItemBinding.getRootView());

            this.contactListItemBinding =bind(contactListItemBinding);

            this.name = itemView.findViewById(R.id.tvName);
            this.email = itemView.findViewById(R.id.tvEmail);
        }
    }


}
