package ru.geekbase.ikotov.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private static List<Crime> mCrimes;

    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public static List<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime (UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }


    //test crimes generate

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
        for (int i =0; i < 100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSloved(i % 2 ==0); //for all 2 objects
            mCrimes.add(crime);
        }
    }
}
