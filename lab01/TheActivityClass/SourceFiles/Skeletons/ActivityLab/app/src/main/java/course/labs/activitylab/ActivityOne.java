package course.labs.activitylab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityOne extends VerboseActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
    launchActivityTwoButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(v.getContext(), ActivityTwo.class));
      }
    });
  }

  @Override
  protected int getLayout() {
    return R.layout.activity_one;
  }
}
