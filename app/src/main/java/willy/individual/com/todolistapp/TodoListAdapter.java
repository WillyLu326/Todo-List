package willy.individual.com.todolistapp;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;
import java.util.jar.Manifest;

import willy.individual.com.todolistapp.models.Todo;

public class TodoListAdapter extends RecyclerView.Adapter{

    private List<Todo> todos;

    public TodoListAdapter(List<Todo> todos) {
        this.todos = todos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.todo_item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        Todo todo = todos.get(position);
        ((TodoViewHolder) holder).todoTv.setText(todo.text);
        ((TodoViewHolder) holder).todoTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(((TodoViewHolder) holder).itemView.getContext(), TodoEditActivity.class);
                ((TodoViewHolder) holder).itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }
}
