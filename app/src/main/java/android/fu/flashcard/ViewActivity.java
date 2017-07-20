package android.fu.flashcard;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private ListView listView;

    List<FlashCard> list;

    public static final int REQUEST_CODE = 100;
    public static final int RESULT_CODE = 200;

    CustomAdapter adapter;
    private DBHelper helper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.listView);
        helper = new DBHelper(getApplicationContext(), "card", 1);
        db = helper.getReadableDatabase();
        list = new ArrayList<FlashCard>();

        /*
        list.add(new Product(100,"Mouse","BigMouse",R.drawable.product01,"300"));
        list.add(new Product(101,"Mouse","BigMouse",R.drawable.product02,"300"));
        list.add(new Product(102,"Mouse","BigMouse",R.drawable.product03,"300"));
        list.add(new Product(103, "Mouse", "BigMouse", R.drawable.product04, "300"));
        */
        adapter = new CustomAdapter(list,this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FlashCard flashCard = (FlashCard) listView.getItemAtPosition(position);
                Intent intent = new Intent(ViewActivity.this, DisplayActivity.class);

                intent.putExtra("card", flashCard);
                startActivity(intent);
            }
        });

    }

    public void show(View view)
    {
        Intent intent = new Intent(this,DisplayActivity.class);
        //intent.putExtra("product",p);
        startActivity(intent);
    }


    protected void onResume() {
        super.onResume();
        db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM tblFlashCard", null);

        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String question = c.getString(c.getColumnIndex("question"));
            String answer = c.getString(c.getColumnIndex("answer"));
            String title = c.getString(c.getColumnIndex("title"));
            list.add(new FlashCard(answer,question,title,id));
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        if (list.size() == 0) {
            Toast.makeText(ViewActivity.this,
                    "There is nothing to show.", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
