package pl.lehmann.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends Activity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(messageText);
    }

    //Call onSendMessage() when the button is clicked
    public void onSendMessageToSecond(View view) {
        EditText messageView = (EditText) findViewById(R.id.messageOne);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }

    //Call onSendMessage() when the button is clicked
    public void onSendMessageToThird(View view) {
        EditText messageView = (EditText) findViewById(R.id.messageOne);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra(ThirdActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }
}
