package makeApplication.omikuji;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OmikujiActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// •¶Žš‚ð•\Ž¦‚·‚é
		TextView tv = (TextView) findViewById(R.id.hello_view);
		
		String str = "‘å‹g";
		Random rnd = new Random();
		int number = rnd.nextInt(3);
		if (number == 0) {
			str = "‹g";
		}
		else if (number == 1){
			str = "‹¥";
		}
		tv.setText(str);
		
	}

}
