package ru.geekbase.ikotov.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSloved;
    private boolean mRequestPolice;
    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSloved() {
        return mSloved;
    }

    public void setSloved(boolean sloved) {
        mSloved = sloved;
    }

    public boolean ismRequestPolice() {return  mRequestPolice;}
    public void setRequestPolice (boolean RequestPolice) {mRequestPolice = RequestPolice;}

}
