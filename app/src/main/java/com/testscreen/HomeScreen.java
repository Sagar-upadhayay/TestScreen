package com.testscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.testscreen.Model.HeadLine;
import com.testscreen.Model.NesApiResponse;

import java.util.List;

public class HomeScreen extends AppCompatActivity {


    FirebaseAuth firebaseAuth;
    RecyclerView recyclerView;
    CustomAdapter adapter;
    private final FetchListener<NesApiResponse> listener = new FetchListener<NesApiResponse>() {
        @Override
        public void onFetch(List<HeadLine> list, String message) {

            showNews(list);
        }

        @Override
        public void onError(String Message) {

        }
    };

    private void showNews(List<HeadLine> list) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        adapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        recyclerView = findViewById(R.id.rec);
        firebaseAuth = FirebaseAuth.getInstance();
        RequestManager manager = new RequestManager(getApplicationContext());
        manager.getHeadlines(listener, "general", null);

        getSupportActionBar();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.signOut) {
            firebaseAuth.signOut();
            startActivity(new Intent(HomeScreen.this,MainActivity.class));
            finish();
        }


        return super.onOptionsItemSelected(item);
    }

}