package com.swe.justslidin.network;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.swe.justslidin.constants.Constants;

public class Firebase {

    private static final Constants constants = new Constants();
    private static final String TAG = "Firebase";
    public static FirebaseDatabase database =
            FirebaseDatabase.getInstance("https://justslidin-94ef6-default-rtdb.asia-southeast1.firebasedatabase.app/");

    public static FirebaseDatabase getDatabase() {
        if (database == null) {
            database = FirebaseDatabase
                    .getInstance("https://justslidin-94ef6-default-rtdb.asia-southeast1.firebasedatabase.app/");
        }
        return database;
    }


}