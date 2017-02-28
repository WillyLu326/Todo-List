package willy.individual.com.todolistapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class TodoViewHolder extends RecyclerView.ViewHolder {

    private TextView todoTv;

    public TodoViewHolder(View itemView) {
        super(itemView);

        todoTv = (TextView) itemView.findViewById(R.id.todo_item_text);
    }

}
