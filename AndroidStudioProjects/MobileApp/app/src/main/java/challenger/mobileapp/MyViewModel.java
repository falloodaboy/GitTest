package challenger.mobileapp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MyViewModel extends ViewModel {
     FirebaseDatabase database = FirebaseDatabase.getInstance();
     DatabaseReference ref = database.getReference("New_Message");
     DatabaseReference ref2 = database.getReference("message");

    private final String TAG = "ModelView: ";
    private MutableLiveData<String> livehold = new MutableLiveData<>();

    public void method(){
        ref.setValue("Hello Again World!");
        ref2.setValue("Hello World");
        ref.child("texts").setValue("Text In a Message");
        ref.child("users").setValue("This is the User's Message").addOnFailureListener(new OnFailureListener(){
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure: This has failed");
            }
        });
    }
}
