package com.michaelwijaya.todolistappworkshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{
    private ArrayList<Task> taskList;
    private Context context;

    public TaskAdapter(ArrayList<Task> taskList, Context context){
        this.taskList = taskList;
        this.context = context;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View taskView = inflater.inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(taskView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        holder.etTaskTitle.setText(taskList.get(position).getTitle());
        holder.cbCheckTask.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    taskList.get(position).setChecked(true);
                    notifyItemChanged(position);
                }else{
                    taskList.get(position).setChecked(false);
                    notifyItemChanged(position);
                }
            }
        });
        holder.btnEditTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = holder.etTaskTitle.getEditableText().toString();
                taskList.get(position).setTitle(title);
                notifyItemChanged(position);
            }
        });

        holder.btnRemoveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, taskList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder{
        private CheckBox cbCheckTask;
        private EditText etTaskTitle;
        private ImageButton btnEditTask;
        private ImageButton btnRemoveTask;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            cbCheckTask = itemView.findViewById(R.id.cb_check_task);
            etTaskTitle = itemView.findViewById(R.id.et_task_title);
            btnEditTask = itemView.findViewById(R.id.btn_edit_task);
            btnRemoveTask = itemView.findViewById(R.id.btn_remove_task);
        }
    }
}
