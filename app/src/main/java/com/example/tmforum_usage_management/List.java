package com.example.tmforum_usage_management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.tmforum_usage_management.models.Usage;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class List extends AppCompatActivity implements OnAdapterItemClickListener {
    private static final String LOG_TAG = List.class.getName();

    private RecyclerView mRecyclerView;

    private ArrayList<Usage> mUsageData;
    private usageAdapter mUsageAdapter;

    private FirebaseFirestore mFirestore;
    private CollectionReference mCollectionReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        mUsageData = new ArrayList<>();

        mUsageAdapter = new usageAdapter(this, mUsageData, this);
        mRecyclerView.setAdapter(mUsageAdapter);

        mFirestore = FirebaseFirestore.getInstance();
        mCollectionReference = mFirestore.collection("usage");

        queryData();
    }

    private void queryData() {
        mUsageData.clear();
        mCollectionReference.orderBy("description").get().addOnSuccessListener(queryDocumentSnapshots -> {
            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                Usage item = document.toObject(Usage.class);
                mUsageData.add(item);
            }

            mUsageAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onAdapterItemClickListener(String btnType, String itemId) {
        if(btnType.equals("delete")) {
            new Delete(mCollectionReference).execute(itemId);

            queryData();
        }

        if(btnType.equals("edit")) {
            Intent intent = new Intent(this, AddNewManagementActivity.class);
            Bundle b = new Bundle();
            b.putString("itemId", itemId);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }

        Log.d(LOG_TAG, itemId);
    }

    public static class Delete extends AsyncTask<String, Void, Void> {
        CollectionReference mCollectionRef;

        public Delete(CollectionReference collectionReference) {
            this.mCollectionRef = collectionReference;
        }

        @Override
        protected Void doInBackground(String... strings) {
            Log.d("asd", strings[0]);
            mCollectionRef.document(strings[0]).delete()
                    .addOnSuccessListener(v -> Log.d("DeleteTask", strings[0] + " successfully deleted"))
                    .addOnFailureListener(v -> Log.d("DeleteTask", strings[0] + " failed to delete"));
            return null;
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
