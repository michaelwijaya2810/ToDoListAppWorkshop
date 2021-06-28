package com.michaelwijaya.todolistappworkshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etTaskTitle;
    private Button btnAddTask;
    private RecyclerView rvTaskList;

    private ArrayList<Task> taskList;
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTaskTitle = findViewById(R.id.et_task_title);
        btnAddTask = findViewById(R.id.btn_add_task);
        rvTaskList = findViewById(R.id.rv_task_list);

        taskList = new ArrayList<>();

        adapter = new TaskAdapter(taskList, getApplicationContext());
        rvTaskList.setAdapter(adapter);
        rvTaskList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTaskTitle.getEditableText().toString();
                if(title.isEmpty()){
                    etTaskTitle.setError("Your task is empty!");
                }else{
                    Task task = new Task();
                    task.setTitle(title);
                    task.setChecked(false);
                    taskList.add(task);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}