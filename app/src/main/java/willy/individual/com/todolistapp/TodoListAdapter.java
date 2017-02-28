package willy.individual.com.todolistapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Todo todo = todos.get(position);
        ((TodoViewHolder) holder).todoTv.setText(todo.text);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }
}
