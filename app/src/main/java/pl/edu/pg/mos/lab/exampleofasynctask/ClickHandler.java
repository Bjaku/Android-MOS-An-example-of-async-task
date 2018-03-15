package pl.edu.pg.mos.lab.exampleofasynctask;

import android.view.View;

/**
 * Created by Kuba on 3/15/2018.
 */

class ClickHandler implements View.OnClickListener{
    private MainActivity parentActivity;

    public ClickHandler(MainActivity parentActivity){
        this.parentActivity = parentActivity;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.computeButton:
                Integer timeToSleep;    //how long thread should compute one task
                timeToSleep = Integer.valueOf(parentActivity.getSeekBarTiedToEditText().getProgress());
                parentActivity.setSomeLongCalculations(new Calculations(parentActivity));
                parentActivity.getSomeLongCalculations().execute(timeToSleep);  //execute asynchronously task with a parameter timeToSleep in another thread
                break;
            case R.id.stopButton:
                parentActivity.getSomeLongCalculations().cancel(true);  //stop asynchronous task
                break;
            default:
                break;
        }
    }
}