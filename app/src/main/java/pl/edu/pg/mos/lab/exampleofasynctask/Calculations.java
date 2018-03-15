package pl.edu.pg.mos.lab.exampleofasynctask;

import android.os.AsyncTask;
import java.util.Random;

/**
 * Created by Kuba on 3/14/2018.
 */

class Calculations extends AsyncTask<Integer, String, Void> {
    private final MainActivity parentActivity;
    private static final int millisecondsFactor = 1000;
    private static final int delayInDisplay = 1000;
    private static final int maximumNumberOfTasks = 10;
    private static final int minimumNumberOfTasks = 1;

    public Calculations(MainActivity mainActivity){
        this.parentActivity = mainActivity;
    }

    @Override
    protected Void doInBackground(Integer... timeToSleep) {
        int time = timeToSleep[0].intValue();   //how long thread should compute one task
        Random numberGenerator = new Random();
        int numberOfTasks = numberGenerator.nextInt((maximumNumberOfTasks - minimumNumberOfTasks) + 1) + minimumNumberOfTasks;  //generate pseudo-random number in range of [minimumNumberOfTasks, maximumNumberOfTasks]
        try {
            Thread.sleep(delayInDisplay);
            for(int i = 0; i < numberOfTasks; ++i) {    //theta(1) because numberOfTasks is bounded between maximumNumberOfTasks and minimumNumberOfTasks (theta(n) e.g. when numberOfTasks would be passed by parameter)
                publishProgress(String.valueOf((i/(double)numberOfTasks) * 100));   //number of finished tasks in %
                Thread.sleep(time * millisecondsFactor);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        parentActivity.getMainTextView().setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPreExecute() {
        parentActivity.getMainTextView().setText("Task has been just started");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        parentActivity.getMainTextView().setText("Task has been just finished");
    }

    @Override
    protected void onCancelled() {
        parentActivity.getMainTextView().setText("Task has been just cancelled");
    }
}
