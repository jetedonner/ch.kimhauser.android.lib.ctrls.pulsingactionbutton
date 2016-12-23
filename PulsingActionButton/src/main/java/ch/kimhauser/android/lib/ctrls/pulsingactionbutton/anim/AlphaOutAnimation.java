package ch.kimhauser.android.lib.ctrls.pulsingactionbutton.anim;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;

/**
 * <p>
 *
 * </p>
 *
 * @author kimhauser.ch, Dave
 * @version 0.0.1 (12.11.2016)
 * @since 0.0.1
 */
public class AlphaOutAnimation extends AnimationSet {

    public AlphaOutAnimation(Context context, AttributeSet attrs, float grow, int duration) {
        super(context, attrs);

        ScaleAnimation growAnim = new ScaleAnimation(1, grow, 1, grow,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        growAnim.setDuration(duration);

        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(duration);

        setInterpolator(new LinearInterpolator());
        addAnimation(growAnim);
        addAnimation(alpha);
    }
}
