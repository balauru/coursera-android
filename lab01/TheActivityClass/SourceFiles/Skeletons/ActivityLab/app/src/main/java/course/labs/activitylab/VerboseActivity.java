package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public abstract class VerboseActivity extends Activity {
  private static final String RESTART_KEY = "restart";
  private static final String RESUME_KEY = "resume";
  private static final String START_KEY = "start";
  private static final String CREATE_KEY = "create";

  private final static String TAG = "Lab-ActivityOne";

  private int mCreate, mRestart, mStart, mResume = 0;
  private TextView mTvCreate, mTvStart, mTvResume, mTvRestart;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayout());

    mTvCreate = (TextView) findViewById(R.id.create);
    mTvStart = (TextView) findViewById(R.id.start);
    mTvResume = (TextView) findViewById(R.id.resume);
    mTvRestart = (TextView) findViewById(R.id.restart);

    // Check for previously saved state
    if (savedInstanceState != null) {
      mStart = savedInstanceState.getInt(START_KEY);
      mRestart = savedInstanceState.getInt(RESTART_KEY);
      mResume = savedInstanceState.getInt(RESUME_KEY);
      mCreate = savedInstanceState.getInt(CREATE_KEY);
    }

    Log.i(TAG, "Entered the onCreate() method");
    mCreate += 1;
    displayCounts();
  }

  @Override
  public void onStart() {
    super.onStart();

    Log.i(TAG, "Entered the onStart() method");
    mStart += 1;
    displayCounts();
  }

  @Override
  public void onResume() {
    super.onResume();

    Log.i(TAG, "Entered the onResume() method");
    mResume += 1;
    displayCounts();
  }

  @Override
  public void onPause() {
    super.onPause();

    Log.i(TAG, "Entered the onPause() method");
  }

  @Override
  public void onStop() {
    super.onStop();

    Log.i(TAG, "Entered the onStop() method");
  }

  @Override
  public void onRestart() {
    super.onRestart();

    Log.i(TAG, "Entered the onRestart() method");
    mRestart += 1;
    displayCounts();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

    Log.i(TAG, "Entered the onRestart()method");
  }

  @Override
  public void onSaveInstanceState(Bundle savedInstanceState) {
    savedInstanceState.putInt(START_KEY, mStart);
    savedInstanceState.putInt(RESTART_KEY, mRestart);
    savedInstanceState.putInt(RESUME_KEY, mResume);
    savedInstanceState.putInt(CREATE_KEY, mCreate);
  }

  protected abstract int getLayout();

  private void displayCounts() {
    mTvCreate.setText(getString(R.string.onCreate, mCreate));
    mTvStart.setText(getString(R.string.onStart, mStart));
    mTvResume.setText(getString(R.string.onResume, mResume));
    mTvRestart.setText(getString(R.string.onRestart, mRestart));
  }
}