package ch.kimhauser.android.lib.ctrls.pulsingactionbutton.anim;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * <p>
 * </p>
 *
 * @author kimhauser.ch, Dave
 * @version 0.0.1 (12.11.2016)
 * @since 0.0.1
 */
public class GrowAnimation extends ScaleAnimation {

    public GrowAnimation(Context context, AttributeSet attrs) {
        this(context, attrs, 1.15f, 3380);
    }

    public GrowAnimation(Context context, AttributeSet attrs, float grow, int duration) {
        super(1, grow, 1, grow, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        setDuration(duration);
    }
}
