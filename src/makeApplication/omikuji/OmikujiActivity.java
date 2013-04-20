package makeApplication.omikuji;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OmikujiActivity extends Activity {
	
	// Ç®Ç›Ç≠Ç∂íIÇÃîzóÒ
	private OmikujiParts[] omikujiShelf = new OmikujiParts[20];
	
	private OmikujiBox omikujibox = new OmikujiBox();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.omikuji);
        
        SharedPreferences pref =
        		PreferenceManager.getDefaultSharedPreferences(this);
        boolean value = pref.getBoolean("button", false);
        
        Button btn = (Button)findViewById(R.id.button1);
        btn.setVisibility(value ? View.VISIBLE : View.INVISIBLE);
        
        this.omikujibox.setImageView((ImageView)findViewById(R.id.imageView1));
        
        // Ç®Ç›Ç≠Ç∂íIÇÃèÄîı
        for (int i = 0; i < 20; i++) {
        	
        	omikujiShelf[i] = new OmikujiParts(R.drawable.result2,
        			                            R.string.contents1);
        }
        omikujiShelf[0].drawID = R.drawable.result1;
        omikujiShelf[0].fortuneID = R.string.contents2;
        
        omikujiShelf[1].drawID = R.drawable.result3;
        omikujiShelf[1].fortuneID = R.string.contents9;
        
        omikujiShelf[2].fortuneID = R.string.contents3;
        omikujiShelf[3].fortuneID = R.string.contents4;
        omikujiShelf[4].fortuneID = R.string.contents5;
        omikujiShelf[5].fortuneID = R.string.contents6;
		
	/*	
		TextView tv = (TextView) findViewById(R.id.hello_view);
		
		// Ç≠Ç∂î‘çÜÇÃéÊìæ
		Random rnd = new Random();
		int number = rnd.nextInt(3);
		
		// Ç®Ç›Ç≠Ç∂íIÇÃèÄîı
		String[] omikujiShelf = new String[20];
		for (int i = 0; i < 20; i++) {
			omikujiShelf[i] = "ãg";
		}
		omikujiShelf[0] = "ëÂãg";
		omikujiShelf[19] = "ã•";
		
		// Ç®Ç›Ç≠Ç∂íIÇ©ÇÁéÊìæ
		String str = omikujiShelf[number];
		
		tv.setText(str);
	*/	
	}
	
	public void drawResult(){
		
		// Ç®Ç›Ç≠Ç∂íIÇ©ÇÁéÊìæ
		OmikujiParts op = omikujiShelf[omikujibox.getNumber()];
		
		// ÉåÉCÉAÉEÉgÇâ^ê®ï\é¶Ç…ïœçX
		setContentView(R.layout.fortune);
		
		// âÊëúÇ∆ÉeÉLÉXÉgÇïœçX
		ImageView imageView = (ImageView)findViewById(R.id.imageView1);
		imageView.setImageResource(op.drawID);
		TextView textView = (TextView)findViewById(R.id.textView1);
		textView.setTextColor(Color.BLACK);
		textView.setText(op.fortuneID);
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

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			if (0 < this.omikujibox.getNumber()) {
				this.drawResult();
			}
		}
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
	/*
		
		Toast toast = Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG);
		toast.show();
	*/
		
		if (item.getItemId() == R.id.item1) {
			Intent intent = new Intent(this, OmikujiPreferenceActivity.class);
			startActivity(intent);
		}
		else {
			Intent intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

}
