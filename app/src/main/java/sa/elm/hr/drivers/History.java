package sa.elm.hr.drivers;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class History extends Fragment {
    private View view;
    private List<Trip> TList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TripAdapter mAdapter;
    public TextView src, des , tripDate , price ;
    public ImageView tripScreen;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.history, container, false);


        src =  view.findViewById(R.id.src);
        des = view.findViewById(R.id.des);
        tripDate=view.findViewById(R.id.date);
        price=view.findViewById(R.id.price);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new TripAdapter(TList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareTripData();
        return view;}

    private void prepareTripData() {

        int[] screens = new int[]{
                R.drawable.path1,R.drawable.path2,R.drawable.path3,R.drawable.path4
        };

        MySharedPrefence.getString(getContext(), Constants.Keys.SOURCE, "");

        TList.add( new Trip(MySharedPrefence.getString(getContext(), Constants.Keys.SOURCE, ""),  MySharedPrefence.getString(getContext(), Constants.Keys.DESTINATION, "")
                ,"6 Aug 10:40 AM","22 SAR ",screens[0]));

        TList.add(new Trip("Royeal Mall","Al-Shamlan medical Center","20 jun  11:55 AM","34 SAR",screens[3]));

        TList.add(new Trip("Princess Noura University","Al-Yarmok Riyadh","17 May  08:05 AM","51 SAR",screens[1]));


        TList.add(new Trip("Caffe Bene","Salam Park","01 May  12:49 AM","18 SAR",screens[2]));


        TList.add(new Trip("King Salman Science Oasis","The Ritz-Carlton,Riyadh","13 Apr  03:09 AM","26 SAR",screens[3]));

        mAdapter.notifyDataSetChanged();


    }

}

