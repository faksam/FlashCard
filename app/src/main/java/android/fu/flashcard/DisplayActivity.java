package android.fu.flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView Title;
    TextView Question;
    TextView Answer;
    FlashCard flashCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Title = (TextView) findViewById(R.id.txtTitle);
        Question = (TextView) findViewById(R.id.txtQuestion);
        Answer = (TextView) findViewById(R.id.txtAnswer);
        Intent intent = getIntent();
        flashCard = (FlashCard)intent.getSerializableExtra("card");
        String s = flashCard.getTitle();
        Title.setText(flashCard.getTitle());
        Question.setText(flashCard.getQuestion());
        Answer.setText(flashCard.getAnswer());
    }

}
