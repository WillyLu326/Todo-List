package willy.individual.com.todolistapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class TodoViewHolder extends RecyclerView.ViewHolder {

    public View itemView;

    public TextView todoTv;

    public TodoViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;

        todoTv = (TextView) itemView.findViewById(R.id.todo_item_text);
    }

}
