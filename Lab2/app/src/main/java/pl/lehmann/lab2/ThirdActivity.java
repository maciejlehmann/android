package pl.lehmann.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends Activity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(messageText);
    }

    //Call onSendMessage() when the button is clicked
    public void onSendMessageToFirst(View view) {
        EditText messageView = (EditText) findViewById(R.id.messageThree);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra(FirstActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }

    //Call onSendMessage() when the button is clicked
    public void onSendMessageToSecond(View view) {
        EditText messageView = (EditText) findViewById(R.id.messageThree);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }
}
