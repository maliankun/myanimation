package com.iweigame.animation;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
/**
 * 属性动画
 * @author liyakun
 *
 */
public class AnimationActivity extends Activity implements OnClickListener{
    
    LinearLayout cameraImage , musicImage ,placeImage,sleepImage,thoughtImage,withImage,seven;
	
    ImageView  plusImage;
    
	boolean sign = false;
	
	static final int anicatinoTime = 400;
	
	FrameLayout buimg;
	
	private static final String TAG="degree";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.round);
		 cameraImage = (LinearLayout)findViewById(R.id.picture_tiankong);
		 cameraImage.setOnClickListener(this);
	     musicImage = (LinearLayout)findViewById(R.id.music);
	     musicImage.setOnClickListener(this);   
	     placeImage = (LinearLayout)findViewById(R.id.place);
	     placeImage.setOnClickListener(this);   
	     sleepImage = (LinearLayout)findViewById(R.id.sleep);
	     sleepImage.setOnClickListener(this);   
	     thoughtImage = (LinearLayout)findViewById(R.id.thought);
	     thoughtImage.setOnClickListener(this);   
	     withImage = (LinearLayout)findViewById(R.id.with);
	     withImage.setOnClickListener(this);   
	     plusImage = (ImageView)findViewById(R.id.myplus);
	     plusImage.setOnClickListener(this);
	     seven=(LinearLayout) findViewById(R.id.seven);
	     seven.setOnClickListener(this);
	     buimg=(FrameLayout) findViewById(R.id.buimg);
	     buimg.setOnClickListener(this);
	     startanimation();
	}
	
	public void startanimation(){
		final int r=getradius();
		final int degree=360/7;
		TranslateAnimation translateAnimation = new TranslateAnimation(0,r, 0, 0);	
		translateAnimation.setInterpolator(new OvershootInterpolator());
 	    translateAnimation.setDuration(anicatinoTime * 2); 
 	    translateAnimation.setStartOffset(40);
 	    translateAnimation.setFillEnabled(true);
 	    translateAnimation.setAnimationListener(new AnimationListener(){

		@Override
		public void onAnimationEnd(Animation arg0) {
			/**由于在执行后view的位置不变，如需要写点击事件就得加上这些重新布置view**/
			FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) cameraImage.getLayoutParams();
			params.bottomMargin += 0;
			params.leftMargin += r;
			cameraImage.setLayoutParams(params);
		}

		@Override
		public void onAnimationRepeat(Animation arg0) {
			
		}

		@Override
		public void onAnimationStart(Animation arg0) {
		}
 		   
 	   });
 	   RotateAnimation rotateAnimation0 = null; 
 	   final float centerX0 = cameraImage.getWidth() / 2.0f; 
       final float centerY0 = cameraImage.getHeight() / 2.0f;
 	   rotateAnimation0 = new RotateAnimation(0, 360,centerX0,centerY0);
       rotateAnimation0.setFillAfter(false); 
       rotateAnimation0.setStartOffset(40);
       rotateAnimation0.setDuration(800);
       rotateAnimation0.setInterpolator(new LinearInterpolator());//不停顿  
       AnimationSet set0 = new AnimationSet(true);
       set0.addAnimation(rotateAnimation0);
       set0.addAnimation(translateAnimation);
       //set0.setFillAfter(true);   //在动画结束后，view留在动画最后的位置
       cameraImage.setAnimation(set0);
       set0.startNow();
 	   // cameraImage.startAnimation(translateAnimation);
 	    
 	   TranslateAnimation translateAnimation1 = new TranslateAnimation(0,Math.round((r*Math.cos(Math.toRadians(degree)))), 0, -Math.round((r*Math.sin(Math.toRadians(degree)))));
	    translateAnimation1.setInterpolator(new OvershootInterpolator());
	    translateAnimation1.setDuration(anicatinoTime * 2); 
	    translateAnimation1.setStartOffset(40);
	    translateAnimation1.setFillEnabled(true); 
	    translateAnimation1.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) musicImage.getLayoutParams();
				params.bottomMargin += Math.round((r*Math.sin(Math.toRadians(degree))));
				params.leftMargin += Math.round((r*Math.cos(Math.toRadians(degree))));
				musicImage.setLayoutParams(params);				
			}
		});
	    RotateAnimation rotateAnimation1 = null; 
	    final float centerX1 = musicImage.getWidth() / 2.0f; 
	    final float centerY1 = musicImage.getHeight() / 2.0f;
	 	   rotateAnimation1 = new RotateAnimation(0, 360,centerX1,centerY1);
	       rotateAnimation1.setFillAfter(false); 
	       rotateAnimation1.setStartOffset(40);
	       rotateAnimation1.setDuration(800); 
	       rotateAnimation1.setInterpolator(new LinearInterpolator());//不停顿  
	       AnimationSet set1 = new AnimationSet(true);
	       set1.addAnimation(rotateAnimation1);
	       set1.addAnimation(translateAnimation1);   
	       //set1.setFillAfter(true);
	       musicImage.setAnimation(set1);
	       set1.startNow();
	   //  musicImage.startAnimation(translateAnimation1);
	    
	    TranslateAnimation translateAnimation2 = new TranslateAnimation(0,Math.round((r*Math.cos(Math.toRadians(degree*2)))), 0, -Math.round((r*Math.sin(Math.toRadians(degree*2)))));
 	    translateAnimation2.setInterpolator(new OvershootInterpolator());
 	    translateAnimation2.setDuration(anicatinoTime * 2); 
 	    translateAnimation2.setStartOffset(40);
 	    translateAnimation2.setFillEnabled(true);
 	    translateAnimation2.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) placeImage.getLayoutParams();
				params.bottomMargin += Math.round((r*Math.sin(Math.toRadians(degree*2))));
				params.leftMargin += Math.round((r*Math.cos(Math.toRadians(degree*2))));
				placeImage.setLayoutParams(params);	
			}
		});
 	   RotateAnimation rotateAnimation2 = null; 
 	  final float centerX2 = placeImage.getWidth() / 2.0f; 
	  final float centerY2 = placeImage.getHeight() / 2.0f;
 	   rotateAnimation2 = new RotateAnimation(0, 360,centerX2,centerY2);
       rotateAnimation2.setFillAfter(false); 
       rotateAnimation2.setStartOffset(40);
       rotateAnimation2.setDuration(800); 
       rotateAnimation2.setInterpolator(new LinearInterpolator());//不停顿  
       AnimationSet set2 = new AnimationSet(true);
       set2.addAnimation(rotateAnimation2);
       set2.addAnimation(translateAnimation2);
       
       //set2.setFillAfter(true);
       placeImage.setAnimation(set2);
       set2.startNow();
 	 //   placeImage.startAnimation(translateAnimation2);
 	    
 	    
 	    TranslateAnimation translateAnimation3 = new TranslateAnimation(0,Math.round((r*Math.cos(Math.toRadians(degree*3)))), 0, -Math.round((r*Math.sin(Math.toRadians(degree*3)))));
	    translateAnimation3.setInterpolator(new OvershootInterpolator());
	    translateAnimation3.setDuration(anicatinoTime * 2); 
	    translateAnimation3.setStartOffset(40);
	    translateAnimation3.setFillEnabled(true); 
	    translateAnimation3.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {

				FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) sleepImage.getLayoutParams();
				params.bottomMargin += Math.round((r*Math.sin(Math.toRadians(degree*3))));
				params.leftMargin += Math.round((r*Math.cos(Math.toRadians(degree*3))));
				sleepImage.setLayoutParams(params);	
				
			}
		});
	    RotateAnimation rotateAnimation3 = null; 
	    final float centerX3 = sleepImage.getWidth() / 2.0f; 
		final float centerY3 = sleepImage.getHeight() / 2.0f;
	 	   rotateAnimation3 = new RotateAnimation(0, 360,centerX3,centerY3);
	       rotateAnimation3.setFillAfter(false); 
	       rotateAnimation3.setStartOffset(40);
	       rotateAnimation3.setDuration(800); 
	       rotateAnimation3.setInterpolator(new LinearInterpolator());//不停顿  
	      AnimationSet set3 = new AnimationSet(true);
	      sleepImage.startAnimation(translateAnimation3);
	      //set3.setFillAfter(true);
	      set3.addAnimation(rotateAnimation3);
	      set3.addAnimation(translateAnimation3);
	      sleepImage.setAnimation(set3);
	      set3.startNow();
	      
	    
	    TranslateAnimation translateAnimation4 = new TranslateAnimation(0,Math.round((r*Math.cos(Math.toRadians(degree*4)))), 0, -Math.round((r*Math.sin(Math.toRadians(degree*4)))));
 	    translateAnimation4.setInterpolator(new OvershootInterpolator());
 	    translateAnimation4.setDuration(anicatinoTime * 2); 
 	    translateAnimation4.setStartOffset(40);
 	    translateAnimation4.setFillEnabled(true); 
 	   translateAnimation4.setAnimationListener(new AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation arg0) {
			
		}
		
		@Override
		public void onAnimationRepeat(Animation arg0) {
			
		}
		
		@Override
		public void onAnimationEnd(Animation arg0) {
			FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) thoughtImage.getLayoutParams();
			params.bottomMargin += Math.round((r*Math.sin(Math.toRadians(degree*4))));
			params.leftMargin += Math.round((r*Math.cos(Math.toRadians(degree*4))));
			thoughtImage.setLayoutParams(params);	
		}
	});
 	    final float centerX = thoughtImage.getWidth() / 2.0f; 
        final float centerY = thoughtImage.getHeight() / 2.0f;
        RotateAnimation rotateAnimation = null; 
       	rotateAnimation = new RotateAnimation(0, 360,centerX,centerY);
       	rotateAnimation.setFillAfter(false); 
        rotateAnimation.setStartOffset(40);
        rotateAnimation.setDuration(800); 
        rotateAnimation.setInterpolator(new LinearInterpolator());//不停顿  
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(rotateAnimation);       
        set.addAnimation(translateAnimation4);
        //set.setFillAfter(true);
        thoughtImage.setAnimation(set);
        
        set.startNow();
        
       // thoughtImage.startAnimation(rotateAnimation); 
 	  //  thoughtImage.startAnimation(translateAnimation4);
 	  
 	    
 	    TranslateAnimation translateAnimation5 = new TranslateAnimation(0,Math.round((r*Math.cos(Math.toRadians(degree*5)))), 0, -Math.round((r*Math.sin(Math.toRadians(degree*5)))));
 	    translateAnimation5.setInterpolator(new OvershootInterpolator());
 	    translateAnimation5.setDuration(anicatinoTime * 2); 
 	    translateAnimation5.setStartOffset(40);
 	    translateAnimation5.setFillEnabled(true); 
 	   translateAnimation5.setAnimationListener(new AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation arg0) {
			
		}
		
		@Override
		public void onAnimationRepeat(Animation arg0) {
			
		}
		
		@Override
		public void onAnimationEnd(Animation arg0) {
			FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) withImage.getLayoutParams();
			params.bottomMargin += Math.round((r*Math.sin(Math.toRadians(degree*5))));
			params.leftMargin += Math.round((r*Math.cos(Math.toRadians(degree*5))));
			withImage.setLayoutParams(params); 			
		}
	});
 	   final float centerX5 = withImage.getWidth() / 2.0f; 
       final float centerY5 = withImage.getHeight() / 2.0f;
 	   RotateAnimation rotateAnimation5 = null; 
 	   rotateAnimation5 = new RotateAnimation(0, 360,centerX5,centerY5);
       rotateAnimation5.setFillAfter(false); 
       rotateAnimation5.setStartOffset(40);
       rotateAnimation5.setDuration(800); 
       rotateAnimation5.setInterpolator(new LinearInterpolator());//不停顿  
       AnimationSet set5 = new AnimationSet(true);
       set5.addAnimation(rotateAnimation5);
       set5.addAnimation(translateAnimation5);
      // set5.setFillAfter(true);
       withImage.setAnimation(set5);
       set5.startNow();
 	    //withImage.startAnimation(translateAnimation5);
       
       
       TranslateAnimation translateAnimation6 = new TranslateAnimation(0,Math.round((r*Math.cos(Math.toRadians(degree*6)))), 0, -Math.round((r*Math.sin(Math.toRadians(degree*6)))));
	    translateAnimation6.setInterpolator(new OvershootInterpolator());
	    translateAnimation6.setDuration(anicatinoTime * 2); 
	    translateAnimation6.setStartOffset(40);
	    translateAnimation6.setFillEnabled(true); 
	   translateAnimation6.setAnimationListener(new AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation arg0) {
			
		}
		
		@Override
		public void onAnimationRepeat(Animation arg0) {
			
		}
		
		@Override
		public void onAnimationEnd(Animation arg0) {
			FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) seven.getLayoutParams();
			params.bottomMargin += Math.round((r*Math.sin(Math.toRadians(degree*6))));
			params.leftMargin += Math.round((r*Math.cos(Math.toRadians(degree*6))));
			seven.setLayoutParams(params); 			
		}
	});
	   final float centerX6 = seven.getWidth() / 2.0f; 
      final float centerY6 = seven.getHeight() / 2.0f;
	   RotateAnimation rotateAnimation6 = null; 
	   rotateAnimation6 = new RotateAnimation(0, 360,centerX6,centerY6);
      rotateAnimation6.setFillAfter(false); 
      rotateAnimation6.setStartOffset(40);
      rotateAnimation5.setDuration(800); 
      rotateAnimation5.setInterpolator(new LinearInterpolator());//不停顿  
      AnimationSet set6 = new AnimationSet(true);
      set6.addAnimation(rotateAnimation6);
      set6.addAnimation(translateAnimation6);
     // set5.setFillAfter(true);
      seven.setAnimation(set6);
      set6.startNow();
 	    
 	    
	}
	
	
	
	/**获得圆的半径**/
	public int getradius(){	
		 DisplayMetrics dm = new DisplayMetrics();
         getWindowManager().getDefaultDisplay().getMetrics(dm);
         int mScreenWidth = dm.widthPixels;
         int mScreenHeight = dm.heightPixels;
         int length = mScreenHeight>mScreenWidth?mScreenWidth:mScreenHeight;
         int radius=0;
         radius=(length-400)/2;
         return radius;
		
	}

	@Override
	public void onClick(View arg0) {
         switch (arg0.getId()) {
		case R.id.buimg:
			
			break;
		case R.id.place:
			Toast.makeText(AnimationActivity.this, "place", Toast.LENGTH_SHORT).show();
			break;
		case R.id.sleep:
			Toast.makeText(AnimationActivity.this, "sleeping", Toast.LENGTH_SHORT).show();
			break;
		case R.id.music:
			Toast.makeText(AnimationActivity.this, "music", Toast.LENGTH_SHORT).show();
			break;
		case R.id.friends:
			Toast.makeText(AnimationActivity.this, "friends", Toast.LENGTH_SHORT).show();
			break;
		case R.id.myplus:
			Toast.makeText(AnimationActivity.this, "myplus", Toast.LENGTH_SHORT).show();
			break;
		case R.id.picture_tiankong:
			Toast.makeText(AnimationActivity.this, "picture_tiankong", Toast.LENGTH_SHORT).show();
			break;
		case R.id.thought:
			Toast.makeText(AnimationActivity.this, "thout", Toast.LENGTH_SHORT).show();
			break;
		case R.id.with:
			Toast.makeText(AnimationActivity.this, "with", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}		
	}
   
	
	
}
