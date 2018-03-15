package pl.edu.pg.mos.lab.exampleofasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import lombok.Getter;
import lombok.Setter;

public class MainActivity extends AppCompatActivity {
    @Getter @Setter
    private Button computeButton;
    @Getter @Setter
    private Button stopButton;
    @Getter @Setter
    private SeekBar seekBarTiedToEditText;
    @Getter @Setter
    private TextView mainTextView;
    @Getter @Setter
    private EditText editTextTiedToSeekBar;
    @Getter @Setter
    private Calculations someLongCalculations;
    private ClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickHandler = new ClickHandler(this);  //instead of creating new instance of ClickHandler for each button, we will later pass reference of already created instance
        computeButton = (Button) findViewById(R.id.computeButton);
        computeButton.setOnClickListener(clickHandler);
        stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(clickHandler);
        seekBarTiedToEditText = (SeekBar) findViewById(R.id.seekBarTiedToEditText);
        seekBarTiedToEditText.setOnSeekBarChangeListener(new SeekBarChangeHandler(this));
        mainTextView = (TextView) findViewById(R.id.mainTextView);
        editTextTiedToSeekBar = (EditText) findViewById(R.id.editTextTiedToSeekBar);
        editTextTiedToSeekBar.addTextChangedListener(new TextChangedHandler(this));
    }
}






