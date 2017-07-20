package android.fu.flashcard;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Samuel on 3/29/2016.
 */
public class CustomAdapter extends BaseAdapter {
    private List<FlashCard> list;
    private Activity activity;

    public List<FlashCard> getList() {
        return list;
    }

    public void setList(List<FlashCard> list) {
        this.list = list;
    }

    public CustomAdapter() {
    }

    public CustomAdapter(List<FlashCard> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder=null;
        if(view ==null)
        {
            view = activity.getLayoutInflater().inflate(R.layout.layout_flashcard,null);
            holder = new Holder();

            holder.title = (TextView)view.findViewById(R.id.txtTitle);
            holder.question = (TextView)view.findViewById(R.id.txtQuestion);
            view.setTag(holder);
        }
        else
        {
            holder = (Holder)view.getTag();
        }

        FlashCard f = list.get(position);
        holder.title.setText(f.getTitle());
        holder.question.setText(f.getQuestion());
        return view;
    }

    class Holder
    {
        public TextView title;
        public TextView question;
    }
}
