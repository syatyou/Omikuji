package makeApplication.omikuji;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OmikujiActivity extends Activity {
	
	private OmikujiBox omikujibox = new OmikujiBox();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.omikuji);
        
        this.omikujibox.setImageView((ImageView)findViewById(R.id.imageView1));
		
	/*	
		TextView tv = (TextView) findViewById(R.id.hello_view);
		
		// ‚­‚¶”Ô†‚Ìæ“¾
		Random rnd = new Random();
		int number = rnd.nextInt(3);
		
		// ‚¨‚İ‚­‚¶’I‚Ì€”õ
		String[] omikujiShelf = new String[20];
		for (int i = 0; i < 20; i++) {
			omikujiShelf[i] = "‹g";
		}
		omikujiShelf[0] = "‘å‹g";
		omikujiShelf[19] = "‹¥";
		
		// ‚¨‚İ‚­‚¶’I‚©‚çæ“¾
		String str = omikujiShelf[number];
		
		tv.setText(str);
	*/	
	}
	
	public void onButtonClick(View v) {
		
		this.omikujibox.shake();
	
	/*
		TranslateAnimation translate = new TranslateAnimation(0, 0, 0, -100);
		translate.setRepeatMode(Animation.REVERSE);
		translate.setRepeatCount(5);
		translate.setDuration(100);
		
		ImageView imageview = (ImageView)findViewById(R.id.imageView1);
		
		RotateAnimation rotate = new RotateAnimation(0, -36,
				imageview.getWidth() / 2, imageview.getHeight() / 2);
		rotate.setDuration(200);
		
		AnimationSet set = new AnimationSet(true);
		set.addAnimation(rotate);
		set.addAnimation(translate);
		
		imageview.startAnimation(set);
	*/	
	/*
		ImageView image = new ImageView(this);
		image.setImageResource(R.drawable.result1);
		setContentView(image);
	*/	
	}

}
