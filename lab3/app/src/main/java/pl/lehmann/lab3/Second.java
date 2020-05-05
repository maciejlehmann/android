package pl.lehmann.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    private ImageButton imgBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showToast();
        findViews();
        setListeners();
    }

    private void findViews() {
        imgBut = findViewById(R.id.imgbut);
    }

    private void setListeners() {
        imgBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
            }
        });
    }

    private void showToast() {
        Toast.makeText(this, "Witaj w drugiej aktywności!", Toast.LENGTH_LONG)
                .show();
    }
}
