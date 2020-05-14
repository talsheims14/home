
package com.example.home;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.storage.StorageReference;


import java.util.ArrayList;

    public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        private Context c;
        private ArrayList<Card> cards;


        public MyAdapter(Context c, ArrayList<Card> cards) {
            this.c = c;
            this.cards = cards;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, null);
            return new MyHolder(v);
        }


        @Override
        public void onBindViewHolder(@NonNull final MyHolder myHolder, final int i) {
            myHolder.Name.setText(cards.get(i).getName());
            myHolder.Phone.setText(cards.get(i).getNumber());
            myHolder.start.setText(cards.get(i).getStart());
            myHolder.destination.setText(cards.get(i).getDestination());
            myHolder.date.setText(cards.get(i).getDate());


        }

        @Override
        public int getItemCount() {
            return cards.size();
        }
    }

