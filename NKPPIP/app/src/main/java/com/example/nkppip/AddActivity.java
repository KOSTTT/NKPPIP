package com.example.nkppip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nkppip.adapter.ListItem;
import com.example.nkppip.db.Constants;
import com.example.nkppip.db.DbManager;

public class AddActivity extends AppCompatActivity {
    private DbManager dbManager;
    private EditText edTitle, edDesc;
    private boolean isEdit = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt_add);
        init();
        getIntent();
    }
    protected void onResume(){
        super.onResume();
        dbManager.openDb();
    }
    private void init(){
        edTitle.findViewById(R.id.edTitle);
        edDesc.findViewById(R.id.edDesc);
        dbManager = new DbManager(this);
    }
    public Intent getIntent(){
        Intent i = getIntent();
        if(i != null){
            ListItem item = (ListItem)i.getSerializableExtra(Constants.LIST_ITEM);
            isEdit = i.getBooleanExtra(Constants.EDIT,true);

            if (!isEdit){
                edTitle.setText((item.getTitle()));
                edDesc.setText(item.getDesc());
            }
        }
        return i;
    }
    public void onClickSave(View view){
        String title = edTitle.getText().toString();
        String desc = edDesc.getText().toString();
        if(title.equals("") || desc.equals("")){
            Toast.makeText(this,R.string.add_error,Toast.LENGTH_LONG).show();
        }
        else {
            dbManager.insertDb(title, desc);
            Toast.makeText(this,R.string.save,Toast.LENGTH_LONG).show();
            finish();
            dbManager.closeDb();
        }
    }
}
