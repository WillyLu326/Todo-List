package willy.individual.com.todolistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import willy.individual.com.todolistapp.models.Todo;

public class MainActivity extends AppCompatActivity {

    private List<Todo> todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mockData();
        setupUI();
    }

    private void setupUI() {
        LinearLayout todoLayout = (LinearLayout) findViewById(R.id.todo_list_layout);
        todoLayout.removeAllViews();
        for (Todo todo : todos) {
            View view = getTodoItemView(todo);
            todoLayout.addView(view);
        }
    }

    private View getTodoItemView(Todo todo) {
        View view = getLayoutInflater().inflate(R.layout.todo_item, null);
        ((TextView) view.findViewById(R.id.todo_item_text)).setText(todo.text);

        return view;
    }

    private void mockData() {
        todos = new ArrayList<>();
        for (int i = 0; i < 1000; ++i) {
            todos.add(new Todo("Todo " + i));
        }
    }
}
