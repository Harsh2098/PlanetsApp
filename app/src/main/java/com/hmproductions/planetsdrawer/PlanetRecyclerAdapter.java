package com.hmproductions.planetsdrawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Harsh Mahajan on 8/4/2017.
 */

class PlanetRecyclerAdapter extends RecyclerView.Adapter<PlanetRecyclerAdapter.PlanetViewHolder> {

    private static int mNumberOfItems;

    PlanetRecyclerAdapter(int numberOfItems)
    {
        mNumberOfItems = numberOfItems;
    }

    @Override
    public PlanetRecyclerAdapter.PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new PlanetViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(PlanetRecyclerAdapter.PlanetViewHolder holder, int position)
    {
        holder.planetTV.setText(MainActivity.planets.get(position).getName());
        holder.distanceTV.setText(String.valueOf(MainActivity.planets.get(position).getDistance()));
    }

    @Override
    public int getItemCount() {
        return mNumberOfItems;
    }

    class PlanetViewHolder extends RecyclerView.ViewHolder {

        TextView planetTV, distanceTV;

        PlanetViewHolder(final View itemView)
        {
            super(itemView);

            planetTV = (TextView)itemView.findViewById(R.id.planet_TV);
            distanceTV = (TextView)itemView.findViewById(R.id.distance_TV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),planetTV.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
