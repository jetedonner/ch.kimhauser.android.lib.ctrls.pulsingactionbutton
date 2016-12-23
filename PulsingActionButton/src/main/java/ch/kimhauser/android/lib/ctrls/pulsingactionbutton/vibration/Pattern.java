package ch.kimhauser.android.lib.ctrls.pulsingactionbutton.vibration;

import java.io.Serializable;

/**
 * <p>
 *     The DTO class for a vibration {@link Pattern}. It defines the "nice" name, the pattern itself.
 *     This class is {@link Serializable}
 * </p>
 *
 * @author kimhauser.ch, Dave
 * @version 0.0.1 (09.11.2016)
 * @since 0.0.1
 */

public class Pattern implements Serializable
{
    private static final long serialVersionUID = 6142753683479050039L;
    private String name;
    private long[] pattern;
    private boolean permanent;

    /**
     * Constructor for a vibration pattern DTO object
     * @param permanent Whether the pattern is permanent or not (OBSOLETE and will be removed soon)
     * @param name The name of the pattern
     * @param pattern The vibration pattern itself as {@link long[]}
     */
    public Pattern(final boolean permanent, final String name, final long[] pattern) {
        this.permanent = permanent;
        this.name = name;
        this.pattern = pattern;
    }

    /**
     * Getter method for accessing the pattern name
     * @return Pattern name as {@link String}
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for accessing the vibration pattern itself as {@link long[]}
     * @return The pattern as {@link long[]}
     */
    public long[] getPattern() {
        return this.pattern;
    }

//    public boolean isPermanent() {
//        return this.permanent;
//    }
}
