package android.fu.flashcard;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {

    EditText Title;
    EditText Question;
    EditText Answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void create(View view) {
        Title = (EditText) findViewById(R.id.etTitle);
        Question = (EditText) findViewById(R.id.etQuestion);
        Answer = (EditText) findViewById(R.id.etAnswer);

        DBHelper helper = new DBHelper(getApplicationContext(), "card", 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", Title.getText().toString());
        values.put("question", Question.getText().toString());
        values.put("answer", Answer.getText().toString());
        db.insert("tblFlashCard", null, values);
        Intent intent = new Intent();

        setResult(200, intent);
        finish();
    }

}
