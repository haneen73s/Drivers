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

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.MyViewHolder>  {

    private Context mContext;
    private List<Offer> OffersList;

    public void deleteItem(int position) {
        OffersList.remove(position);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }

    public OffersAdapter(Context mContext, List<Offer> OffersList) {
        this.mContext = mContext;
        this.OffersList = OffersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offer_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Offer offer = OffersList.get(position);
        holder.title.setText(offer.getName());


        // loading album cover using Glide library
        Glide.with(mContext).load(offer.getThumbnail()).into(holder.thumbnail);


    }



    public Offer getOfferAT(int position){
        return OffersList.get(position);
    }

    /**
     * Click listener for popup menu items
     */




    @Override
    public int getItemCount() {
        return OffersList.size();
    }

}