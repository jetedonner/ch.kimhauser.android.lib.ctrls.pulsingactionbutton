package ch.kimhauser.android.lib.ctrls.pulsingactionbutton.ctrl;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import ch.kimhauser.android.lib.ctrls.pulsingactionbutton.ctrl.CircleForPulsingActionButton;
import ch.kimhauser.android.lib.ctrls.pulsingactionbutton.Consts;
import ch.kimhauser.android.lib.ctrls.pulsingactionbutton.anim.AlphaOutAnimation;
import ch.kimhauser.android.lib.ctrls.pulsingactionbutton.anim.GrowAnimation;
import ch.kimhauser.android.lib.ctrls.pulsingactionbutton.vibrationNG.VibratorManagerNG;

/**
 * <p>
 *     This is a custom view class for a pulsing (floating) action button widget. The fab
 *     uses an animation to underline the preformed click on the action button.
 * </p>
 *
 * @author kimhauser.ch, dave
 * @version 0.0.1 (12.11.2016)
 * @since 0.0.1
 */
public class PulsingActionButton extends FrameLayout {

    private float elev = 5;
    private FloatingActionButton fab;
    private CircleForPulsingActionButton circle;
    private OnClickListener ocl = null;

    private int width = 32;
    private int height = 32;
    private float grow = 1.0f;

    private VibratorManagerNG vm;

    private boolean vibrate = true;

    public boolean isVibrate() {
        return vibrate;
    }

    public void setVibrate(boolean vibrate) {
        this.vibrate = vibrate;
    }

    public PulsingActionButton(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        if(!isInEditMode())
            vm = new VibratorManagerNG(context);

        int[] set = {
                ch.kimhauser.android.lib.ctrls.pulsingactionbutton.R.attr.elevation,
                ch.kimhauser.android.lib.ctrls.pulsingactionbutton.R.attr.srcCompat,
                android.R.attr.layout_width,
                android.R.attr.layout_height
        };

        TypedArray a = context.obtainStyledAttributes(attrs, set);

        width = a.getDimensionPixelSize(2, ViewGroup.LayoutParams.WRAP_CONTENT);
        height = a.getDimensionPixelSize(3, ViewGroup.LayoutParams.WRAP_CONTENT);

        elev = a.getDimensionPixelSize(0, 5);

        TypedArray a2 = context.obtainStyledAttributes(attrs, ch.kimhauser.android.lib.ctrls.pulsingactionbutton.R.styleable.Circle);
        elev = a2.getDimension(ch.kimhauser.android.lib.ctrls.pulsingactionbutton.R.styleable.Circle_elev, 2.0f);

        int drw = a2.getResourceId(ch.kimhauser.android.lib.ctrls.pulsingactionbutton.R.styleable.Circle_src, -1);

        grow = a2.getFloat(ch.kimhauser.android.lib.ctrls.pulsingactionbutton.R.styleable.Circle_grow, 1.2f);

        fab = new FloatingActionButton(context);
        fab.setCompatElevation(elev);
        fab.setImageResource(drw);

        LayoutParams lpFab = new LayoutParams(width, height);
        lpFab.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;
        addView(fab, lpFab);

        circle = new CircleForPulsingActionButton(context, attrs);
        circle.setFab(fab, grow);

        LayoutParams lpCircle = new LayoutParams(width, height);
        lpCircle.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;
        addView(circle, lpCircle);

        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {

                Animation growAnim = new GrowAnimation(context, attrs, grow, Consts.DURATION_GROW_INITIAL);
                growAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if(vibrate) {

                            if(vm != null && vm.hasVibrator()) {
                                vm.vibrate();
                            }
                        }
                        circle.setVisibility(View.VISIBLE);

                        DisplayMetrics metrics = new DisplayMetrics();
                        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
                        float scaledDensity = metrics.scaledDensity;

                        final ValueAnimator animator = ValueAnimator.ofFloat((width / scaledDensity / 8), 1.0f);
                        animator.setDuration(Consts.DURATION_GROW);
                        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                circle.getPaint().setStrokeWidth((Float)animation.getAnimatedValue());
                                circle.setStrokeWidth((int)(float)animation.getAnimatedValue());
                                circle.invalidate();
                            }
                        });

                        Animation alphaOutAnim = new AlphaOutAnimation(context, attrs, grow, Consts.DURATION_GROW);
                        alphaOutAnim.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                animator.start();
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                circle.setVisibility(View.GONE);
                                if(ocl != null)
                                    ocl.onClick(view);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        circle.startAnimation(alphaOutAnim);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                fab.startAnimation(growAnim);
            }
        });
    }

    @Override
    public boolean performClick() {
        return fab.performClick();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            }
        }

        int widthNew = (int)(width * grow) + (int)(2 * elev);
        int heightNew = (int)(height * grow) + (int)(2 * elev);

        //MUST CALL THIS
        setMeasuredDimension(widthNew, heightNew);
    }


    public void setOnClickListener(@Nullable OnClickListener l) {
        ocl = l;
    }
}
