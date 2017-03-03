package willy.individual.com.todolistapp;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import willy.individual.com.todolistapp.models.Todo;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_TODO_CODE = 100;

    private List<Todo> todos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mockData();
        setupUI();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_TODO_CODE && resultCode == Activity.RESULT_OK) {
            Todo todo = data.getParcelableExtra(TodoEditActivity.KEY_TODO);
            todos.add(todo);
            setupUI();
        }
    }

    private void setupUI() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TodoListAdapter(todos));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TodoEditActivity.class);
                startActivityForResult(intent, REQ_TODO_CODE);
            }
        });
    }

    private void mockData() {
        todos = new ArrayList<>();

    }
}
