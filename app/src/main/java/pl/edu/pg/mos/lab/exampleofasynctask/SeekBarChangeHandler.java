package pl.edu.pg.mos.lab.exampleofasynctask;

import android.widget.SeekBar;

/**
 * Created by Kuba on 3/15/2018.
 */

class SeekBarChangeHandler implements android.widget.SeekBar.OnSeekBarChangeListener{
    private final MainActivity parentActivity;;

    public SeekBarChangeHandler(MainActivity mainActivity){
        this.parentActivity = mainActivity;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch(seekBar.getId()) {
            case R.id.seekBarTiedToEditText:
                parentActivity.getEditTextTiedToSeekBar().setText(String.valueOf(progress));    //when seekbar is used, display value of movement on EditText window
                break;
            default:
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

