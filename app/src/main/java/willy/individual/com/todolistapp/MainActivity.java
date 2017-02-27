package willy.individual.com.todolistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

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
        ListView listView = (ListView) findViewById(R.id.list_view);
        TodoListAdapter adapter = new TodoListAdapter(this, todos);
        listView.setAdapter(adapter);
    }

    private void mockData() {
        todos = new ArrayList<>();
        for (int i = 0; i < 1000; ++i) {
            todos.add(new Todo("Todo " + i));
        }
    }
}
