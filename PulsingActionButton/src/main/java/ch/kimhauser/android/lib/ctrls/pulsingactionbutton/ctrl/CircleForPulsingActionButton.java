package ch.kimhauser.android.lib.ctrls.pulsingactionbutton.ctrl;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import ch.kimhauser.android.lib.ctrls.pulsingactionbutton.R;

/**
 * <p>
 * </p>
 *
 * @author kimhauser.ch, Dave
 * @version 0.0.1 (11.11.16)
 * @since 0.0.1
 */
public class CircleForPulsingActionButton extends View {

    private final Paint paint;
    private final int sizeAdd = 18;
    private int strokeWidth = 2;
    private int rad = 45;
    private FloatingActionButton fab;

    private int width = 32;
    private int height = 32;
    private float grow = 2.0f;

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setFab(FloatingActionButton fab, float grow){
        this.fab = fab;
        this.grow = grow;
    }

    public void setParams(int rad){
        this.rad = rad;
        this.invalidate();
    }

    @SuppressWarnings("ResourceType")
    public CircleForPulsingActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        int[] set = {
                ch.kimhauser.android.lib.ctrls.pulsingactionbutton.R.attr.srcCompat,
                android.R.attr.layout_width,
                android.R.attr.layout_height
        };

        TypedArray a = context.obtainStyledAttributes(attrs, set);

        width = a.getDimensionPixelSize(1, ViewGroup.LayoutParams.WRAP_CONTENT);
        height = a.getDimensionPixelSize(2, ViewGroup.LayoutParams.WRAP_CONTENT);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        //Circle color
        paint.setColor(ContextCompat.getColor(context, R.color.colorAccent));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(
                (((int)(width * grow)) / 2), // + (strokeWidth / 2) + 12,
                (((int)(height * grow)) / 2), // + (strokeWidth / 2) + 12,
                height / 2, paint);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

//        FrameLayout fl  = (FrameLayout)fab.getParent();

        int widthNew = (int)(width * grow);// + (2 * strokeWidth) + sizeAdd + 4;
        int heightNew = (int)(height * grow); //+ (2 * strokeWidth) + sizeAdd + 4;

        //MUST CALL THIS
        setMeasuredDimension(widthNew, heightNew);
    }
}