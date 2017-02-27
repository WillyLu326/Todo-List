package willy.individual.com.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import willy.individual.com.todolistapp.models.Todo;

public class TodoListAdapter extends BaseAdapter{

    private List<Todo> todos;

    private Context context;

    public TodoListAdapter(Context context, List<Todo> todos) {
        this.context = context;
        this.todos = todos;
    }

    @Override
    public int getCount() {
        return todos.size();
    }

    @Override
    public Todo getItem(int i) {
        return todos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.todo_item, viewGroup, false);
        }

        ((TextView) convertView.findViewById(R.id.todo_item_text)).setText(getItem(i).text);

        return convertView;
    }
}
