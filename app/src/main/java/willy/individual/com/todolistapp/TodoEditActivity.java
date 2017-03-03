package willy.individual.com.todolistapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import willy.individual.com.todolistapp.models.Todo;


public class TodoEditActivity extends AppCompatActivity {

    public static final String KEY_TODO = "todo";

    private Todo todo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_edit);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        todo = getTodoFromIntent();

        if (todo == null) {
            setupTodoInitUI();
        } else {
            setupTodoEditUI();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupTodoEditUI() {
        findViewById(R.id.todo_edit_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndExit();
            }
        });
    }

    private void setupTodoInitUI() {
        findViewById(R.id.todo_edit_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndExit();
            }
        });
    }

    private Todo getTodoFromIntent() {
        return getIntent().getParcelableExtra(KEY_TODO);
    }

    private void saveAndExit() {
        if (todo == null) {
            todo = new Todo();
        }

        todo.text = ((EditText)findViewById(R.id.todo_edit)).getText().toString();

        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_TODO, todo);
        setResult(Activity.RESULT_OK, resultIntent);

        finish();
    }

}
