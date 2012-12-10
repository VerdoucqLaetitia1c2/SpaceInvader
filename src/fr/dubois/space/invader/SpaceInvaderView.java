package fr.dubois.space.invader;






import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

public class SpaceInvaderView extends View {
	
	// Dimensions souhaitées
	private static final int TARGET_HEIGHT = 800;
	private static final int TARGET_WIDTH = 600;

	private Paint paint; // Style pour le texte	
	private String text; // texte à afficher
	private Bitmap alien;
	


	public SpaceInvaderView(Context context) {
		super(context);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public Bitmap loadImage(int key){
		
		Resources r = this.getResources();
		Drawable drawable =r.getDrawable(key);
		int x = drawable.getIntrinsicHeight();
		int y = drawable.getIntrinsicWidth();
		Bitmap bitmap = Bitmap.createBitmap(x,y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0,x,y);
        drawable.draw(canvas);
        
		return bitmap;
	}

	

	void init(){
		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.YELLOW);
		paint.setTypeface(Typeface.SANS_SERIF);
		paint.setTextSize(36);
		paint.setTextAlign(Paint.Align.CENTER);
		text = "Texte";

		alien=loadImage(R.drawable.alien1);

	}

	 

public Bitmap Loadimage(int key){
	
	  Resources r = this.getContext().getResources();
	  r.getDrawable(R.drawable.alien1); r.getDrawable(R.drawable.ic_launcher);
	  r.getDrawable(R.drawable.missile); r.getDrawable(R.drawable.missile2);
	  r.getDrawable(R.drawable.ship);
	
	return null; 
}

private RefreshHandler mRedrawHandler = new RefreshHandler();
private Object update;

class RefreshHandler extends Handler {

    @Override
    public void handleMessage(Message msg) {
        SpaceInvaderView.this.update();
        SpaceInvaderView.this.invalidate();
    }

    public void sleep(long delayMillis) {
    	this.removeMessages(0);
        sendMessageDelayed(obtainMessage(0), delayMillis);
    }
};

public void update() {
	// TODO Auto-generated method stub
 long mMoveDelay;
mRedrawHandler.sleep(40 );
 }

@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(0, 0, TARGET_WIDTH-1, TARGET_HEIGHT-1, paint);
		if (text != null){
		canvas.drawText(text, canvas.getWidth()/2,canvas.getHeight()/2, paint);
		}
		
	}

protected void onSizeChanged (int w, int h, int oldw, int oldh)
{
        if ((w == oldw) && (h == oldh))
        {
                /* Nothing to do */
                return;
                }
         /* Save the new view dimensions */
        int widthMeasureSpec = w;
        int heightMeasureSpec=h;
        int StackSpacing = widthMeasureSpec/100;
}


	private int computeSize(int spec,int def){
		int mode = View.MeasureSpec.getMode(spec);
		if (mode == View.MeasureSpec.UNSPECIFIED) return def;
		int size = View.MeasureSpec.getSize(spec);
		if (mode == View.MeasureSpec.EXACTLY) {
			return size;
		}
		//		MeasureSpec.AT_MOST
		if (size < def ) return size;
		return def;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int x = computeSize(widthMeasureSpec,TARGET_WIDTH);
		int y = computeSize(heightMeasureSpec,TARGET_HEIGHT);
		this.setMeasuredDimension(x,y);
	}
		
}
