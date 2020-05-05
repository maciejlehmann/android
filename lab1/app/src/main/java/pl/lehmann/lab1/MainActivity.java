package pl.lehmann.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAdd(View view) {
        TextView result = (TextView) findViewById(R.id.result);
        Spinner numberOne = (Spinner) findViewById(R.id.number1);
        Spinner numberTwo = (Spinner) findViewById(R.id.number2);

        int myNumberOne = Integer.parseInt(String.valueOf(numberOne.getSelectedItem()));
        int myNumberTwo = Integer.parseInt(String.valueOf(numberTwo.getSelectedItem()));

        double value = myNumberOne + myNumberTwo;
        result.setText(String.valueOf(value));

    }

    public void onClickSubstract(View view) {
        TextView result = (TextView) findViewById(R.id.result);
        Spinner numberOne = (Spinner) findViewById(R.id.number1);
        Spinner numberTwo = (Spinner) findViewById(R.id.number2);

        int myNumberOne = Integer.parseInt(String.valueOf(numberOne.getSelectedItem()));
        int myNumberTwo = Integer.parseInt(String.valueOf(numberTwo.getSelectedItem()));

        double value = myNumberOne - myNumberTwo;
        result.setText(String.valueOf(value));

    }

    public void onClickMultiply(View view) {
        TextView result = (TextView) findViewById(R.id.result);
        Spinner numberOne = (Spinner) findViewById(R.id.number1);
        Spinner numberTwo = (Spinner) findViewById(R.id.number2);

        int myNumberOne = Integer.parseInt(String.valueOf(numberOne.getSelectedItem()));
        int myNumberTwo = Integer.parseInt(String.valueOf(numberTwo.getSelectedItem()));

        double value = myNumberOne * myNumberTwo;
        result.setText(String.valueOf(value));

    }

    public void onClickDivide(View view) {
        TextView result = (TextView) findViewById(R.id.result);
        Spinner numberOne = (Spinner) findViewById(R.id.number1);
        Spinner numberTwo = (Spinner) findViewById(R.id.number2);

        double myNumberOne = Integer.parseInt(String.valueOf(numberOne.getSelectedItem()));
        double myNumberTwo = Integer.parseInt(String.valueOf(numberTwo.getSelectedItem()));

        if (myNumberTwo == 0) {
            result.setText("Nie można dzielić przez zero!");
        } else {
            double value = myNumberOne / myNumberTwo;
            result.setText(String.format("%.3f", value));
        }

    }
}
