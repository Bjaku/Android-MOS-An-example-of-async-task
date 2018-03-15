package pl.edu.pg.mos.lab.exampleofasynctask;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Kuba on 3/15/2018.
 */

class TextChangedHandler implements TextWatcher {
    private MainActivity parentActivity;

    public TextChangedHandler(MainActivity parentActivity){
        this.parentActivity = parentActivity;
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        if (charSequence.length() != 0) {
            parentActivity.getSeekBarTiedToEditText().setProgress(Integer.parseInt(charSequence.toString()));   //when new value appears in EditText window change progress on seekbar
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }
}


