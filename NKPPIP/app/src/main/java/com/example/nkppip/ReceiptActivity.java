package com.example.nkppip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nkppip.adapter.MainAdapter;
import com.example.nkppip.db.DbManager;

public class ReceiptActivity extends AppCompatActivity {
    private DbManager dbManager;
    private EditText editTitle, editDesc;
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt);
        DbInit();
    }
    private void DbInit(){
    dbManager = new DbManager(this);
    editTitle = findViewById(R.id.edTitle);
    editDesc = findViewById(R.id.edDesc);
    recyclerView = findViewById(R.id.rcView);
    mainAdapter = new MainAdapter(this);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(mainAdapter);
}
        protected void onResume(){
        super.onResume();
        dbManager.openDb();
        mainAdapter.updateAdapter(dbManager.getFromDb());
    }
    public void onClickAdd (View view){
        Intent i = new Intent(ReceiptActivity.this,AddActivity.class);
        startActivity(i);
    }
}
