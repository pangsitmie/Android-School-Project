package com.example.lab_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewClass extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv = (ListView) findViewById(R.id.lv);


        ArrayList<Users> userList = new ArrayList<>();
        for (int i=0;i<500;i++)
        {
            Users user = new Users("User "+i, "desc "+i);
            userList.add(user);
        }
        Log.d("TAG", "onCreate: "+ userList.get(8).getTitle());

        ListAdapter adapter = new ListAdapter(this, R.layout.listview_layout, userList);
        lv.setAdapter(adapter);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Users listItem = lv.getItemAtPosition(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(ListViewClass.this);
                builder.setTitle("Result");
                builder.setIcon(R.drawable.ic_privacy);
                builder.setMessage(""+);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(), String.valueOf(position)+" Selected", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });


//        Array adapter


//        Alertdialog


    }
}