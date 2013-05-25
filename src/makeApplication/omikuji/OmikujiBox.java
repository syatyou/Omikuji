package makeApplication.omikuji;

import java.util.Random;

import android.hardware.SensorEvent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class OmikujiBox implements AnimationListener {
	
	private long beforeTime = System.currentTimeMillis();
	private float beforeValue;
	
	private int number; // Ç≠Ç∂î‘çÜ
	private ImageView imageView;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public OmikujiBox() {
		// TODO Auto-generated constructor stub
		this.number = -1;
	}
	public boolean chkShake(SensorEvent event) {
		
		long now_time = System.currentTimeMillis();
		long diff_time = now_time - this.beforeTime;
		float now_value = event.values[0] + event.values[1];
		
		if (1500 < diff_time) {
			
			
			float speed = Math.abs(now_value - this.beforeValue) / diff_time * 10000;
			
			this.beforeTime = now_time;
			this.beforeValue = now_value;
			
			
			if (50 < speed) {
				return true;
			}
		}
		return false;
	}
	public void shake() {
		TranslateAnimation translate = new TranslateAnimation(0, 0, 0, -100);
		translate.setRepeatMode(Animation.REVERSE);
		translate.setRepeatCount(5);
		translate.setDuration(100);
		
		RotateAnimation rotate = new RotateAnimation(0, -36,
				this.imageView.getWidth() / 2, this.imageView.getHeight() / 2);
		rotate.setDuration(200);
		
		AnimationSet set = new AnimationSet(true);
		set.addAnimation(rotate);
		set.addAnimation(translate);
		
		set.setAnimationListener(this);
		this.imageView.startAnimation(set);
		
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		this.number = rnd.nextInt(20);
		this.imageView.setImageResource(R.drawable.omikuji_result);
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
}
