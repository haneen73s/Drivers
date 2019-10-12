package sa.elm.hr.drivers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class TripAdapter extends  RecyclerView.Adapter<TripAdapter.MyViewHolder>{



    private List<Trip> TripsList;
    private  Context mContext;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView src, des , tripDate , price ;
        public ImageView tripScreen;
        private  Context mContext;

        public MyViewHolder(View view) {
            super(view);
            src = (TextView) view.findViewById(R.id.src);
            des = (TextView) view.findViewById(R.id.des);
            tripDate=view.findViewById(R.id.date);
            price=view.findViewById(R.id.price);
            tripScreen=view.findViewById(R.id.tripScreen);
        }
    }


    public TripAdapter(List<Trip> moviesList , Context mContext) {
        this.TripsList = moviesList;
        this.mContext=mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trip_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Trip trip = TripsList.get(position);
        holder.src.setText(trip.getSource());
        holder.des.setText(trip.getDestination());
        holder.tripDate.setText(trip.getRideDate());
        holder.price.setText(trip.getPrice());

        Glide.with(mContext).load(trip.getImg()).into(holder.tripScreen);

    }

    @Override
    public int getItemCount() {
        return TripsList.size();
    }
}