package com.example.home;
import android.view.View;

import android.widget.TextView;

import androidx.annotation.NonNull;




import static androidx.recyclerview.widget.RecyclerView.*;


    public class MyHolder extends ViewHolder  {

        public TextView Name, Phone, start,destination ,date;


        MyHolder(@NonNull View itemView) {
            super(itemView);

            this.Name = itemView.findViewById(R.id.textnameSearchone);
            this.Phone = itemView.findViewById(R.id.textnumberSearchone);
            this.start = itemView.findViewById(R.id.textstartSearchone);
            this.destination = itemView.findViewById(R.id.textdestinationSearchone);
            this.date=itemView.findViewById(R.id.textdateSearchone);

        }


    }

