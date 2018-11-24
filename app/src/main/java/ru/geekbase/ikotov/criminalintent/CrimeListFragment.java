package ru.geekbase.ikotov.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private  CrimeAdapter mAdapter;
    private  Crime mCrime;
    private TextView mTitleTextView;
    private TextView mDateTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false
        );
        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.crimr_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private class CrimeHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        public CrimeHolder(LayoutInflater inflater, ViewGroup paren){
            super(inflater.inflate(R.layout.list_item_crime, paren, false));
            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);

            itemView.setOnClickListener(this);
        }
        public void bind (Crime crime){
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            mTitleTextView.setText(mCrime.getDate().toString());
        }
        @Override
        public void onClick(View view) {

            Toast.makeText(getActivity(), mCrime.getTitle()+ " clicked!", Toast.LENGTH_SHORT)
                    .show();

        }
    }





    //bind


    //adapter 193

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes){
            mCrimes = crimes;
        }


        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
           holder.bind(crime);

        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

    private void updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = CrimeLab.getCrimes();
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }
}
