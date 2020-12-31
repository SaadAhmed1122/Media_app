package com.example.media_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.media_app.model.model_rec_one;

import java.util.ArrayList;

class adaptor_recyler_one extends RecyclerView.Adapter<adaptor_recyler_one.MyViewHolder> {
    private ArrayList<model_rec_one> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.txtView);
            //this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (getPosition()==0)
                    {
                        Toast.makeText(v.getContext(), " On CLick one", Toast.LENGTH_SHORT).show();

                    } if (getPosition()==1)
                {
                    Toast.makeText(v.getContext(), " On CLick Two", Toast.LENGTH_SHORT).show();

                } if (getPosition()==2)
                {
                    Toast.makeText(v.getContext(), " On CLick Three", Toast.LENGTH_SHORT).show();

                } if (getPosition()==3)
                {
                    Toast.makeText(v.getContext(), " On CLick Fore", Toast.LENGTH_SHORT).show();

                }

                }
            });
        }
    }

    public adaptor_recyler_one(ArrayList<model_rec_one> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recy_item, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        // TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        //textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

