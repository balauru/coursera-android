package course.labs.activitylab;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityTwo extends VerboseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Button closeButton = (Button) findViewById(R.id.bClose);
		closeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
        finish();
			}
		});
	}

  @Override
  protected int getLayout() {
    return R.layout.activity_two;
  }
}
