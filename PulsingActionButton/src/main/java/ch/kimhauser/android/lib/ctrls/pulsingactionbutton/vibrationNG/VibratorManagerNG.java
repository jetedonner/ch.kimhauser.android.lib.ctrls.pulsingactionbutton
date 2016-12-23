package ch.kimhauser.android.lib.ctrls.pulsingactionbutton.vibrationNG;

import android.content.Context;
import android.os.Vibrator;


/**
 * <p>
 *     Manager class for vibrator functions. Also lets you manage different vibration patterns
 * </p>
 *
 * @author kimhauser.ch, Dave
 * @version 0.0.1 (16.12.2016)
 * @since 0.0.1
 */
public class VibratorManagerNG {

//    private final ArrayList<Pattern> arlPatterns = new ArrayList<>();
    private final Context mContext;
    private final Vibrator vibrator;

//    /**
//     * Getter method for returning all loaded vibration patterns ({@link Pattern})
//     * @return An {@link ArrayList} with all predefined {@link Pattern}
//     */
//    public ArrayList<Pattern> getPatterns() {
//        return arlPatterns;
//    }

    public VibratorManagerNG(Context context) {
        mContext = context;
        vibrator = (Vibrator)mContext.getSystemService(Context.VIBRATOR_SERVICE);
//        loadPatterns();
    }

    public boolean hasVibrator(){
        if(vibrator != null)
            return vibrator.hasVibrator();
        return false;
    }

    public void vibrate(){
        if(hasVibrator())
            vibrator.vibrate(new long[] { 0L, 100L, 100L } , -1);
    }

//    /**
//     * Load all predefined (yet hardcoded) vibration {@link Pattern} to the manager
//     */
//    private void loadPatterns(){
//
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        // Recompiled from Cerbroid Vibrate Ringer_v1.1_apkpure.com.apk (https://play.google.com/store/apps/details?id=com.cerbroid.vibrateringer)
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
////        arlPatterns.add(new Pattern(true, VibratorConsts.Android_default, new long[] { 0L, 100L, 100L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Android_default_error, new long[] { 0, 50, 100, 50}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Beethovens_5th, new long[] { 0L, 100L, 80L, 100L, 80L, 100L, 80L, 1000L, 500L, 100L, 90L, 100L, 90L, 100L, 90L, 1000L, 500L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Bingo, new long[] { 0L, 200L, 300L, 200L, 300L, 100L, 150L, 100L, 150L, 200L, 300L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Constant, new long[] { 0L, 2000L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Dance_of_the_Sugar_Plum_Fairy, new long[] { 0L, 50L, 200L, 50L, 200L, 100L, 400L, 100L, 400L, 100L, 400L, 100L, 400L, 75L, 175L, 75L, 175L, 75L, 425L, 75L, 175L, 75L, 175L, 75L, 425L, 75L, 175L, 75L, 175L, 75L, 425L, 75L, 175L, 75L, 175L, 75L, 175L, 75L, 175L, 100L, 1400L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Dixie, new long[] { 0L, 75L, 75L, 75L, 75L, 200L, 100L, 200L, 100L, 75L, 75L, 75L, 75L, 75L, 75L, 75L, 75L, 200L, 100L, 200L, 100L, 200L, 100L, 300L, 450L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Fast, new long[] { 0L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L, 100L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Gallop, new long[] { 0L, 60L, 60L, 60L, 60L, 60L, 60L, 60L, 200L, 60L, 60L, 60L, 60L, 60L, 60L, 60L, 200L, 60L, 60L, 60L, 60L, 60L, 60L, 60L, 200L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.La_Cucaracha, new long[] { 0L, 100L, 115L, 100L, 115L, 100L, 115L, 500L, 142L, 120L, 308L, 100L, 115L, 100L, 115L, 100L, 115L, 500L, 142L, 120L, 308L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Mars_Gustav_Holst, new long[] { 0L, 125L, 42L, 125L, 42L, 125L, 42L, 450L, 50L, 450L, 50L, 100L, 150L, 100L, 150L, 150L, 100L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Morse_code_SOS, new long[] { 0L, 100L, 100L, 100L, 100L, 100L, 300L, 300L, 100L, 300L, 100L, 300L, 300L, 100L, 100L, 100L, 100L, 100L, 700L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Ring_Around_the_Rosy, new long[] { 0L, 300L, 150L, 100L, 100L, 250L, 150L, 100L, 100L, 450L, 100L, 500L, 100L, 300L, 150L, 100L, 50L, 300L, 150L, 100L, 50L, 500L, 100L, 500L, 100L, 550L, 50L, 200L, 400L, 550L, 50L, 200L, 250L, 100L, 50L, 500L, 100L, 500L, 100L, 350L, 850L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Shave_and_a_Haircut, new long[] { 0L, 200L, 300L, 200L, 175L, 100L, 25L, 200L, 300L, 200L, 800L, 300L, 200L, 300L, 3000L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Skip, new long[] { 0L, 500L, 100L, 100L, 100L, 500L, 100L, 100L, 100L, 500L, 100L, 100L, 100L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Star_Spangled_Banner, new long[] { 0L, 300L, 150L, 50L, 100L, 500L, 100L, 500L, 100L, 500L, 100L, 800L, 400L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Vivaldis_Spring, new long[] { 0L, 150L, 37L, 125L, 62L, 200L, 175L, 200L, 175L, 200L, 175L, 150L, 37L, 125L, 62L, 750L, 375L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.When_Johnny_Comes_Marching_Home, new long[] { 0L, 100L, 67L, 100L, 67L, 100L, 67L, 100L, 67L, 250L, 84L, 100L, 67L, 250L, 84L, 100L, 67L, 250L, 84L, 100L, 67L, 500L, 375L, 100L, 75L, 500L, 375L }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.William_Tell, new long[] { 0L, 50L, 75L, 50L, 75L, 100L, 150L, 50L, 75L, 50L, 75L, 100L, 150L, 50L, 75L, 50L, 75L, 100L, 150L, 100L, 150L, 100L, 150L }));
////
////        //////////////////////////////////////////////////////////////////////
////        // From https://gearside.com/custom-vibration-patterns-mobile-devices/
////        //////////////////////////////////////////////////////////////////////
////        arlPatterns.add(new Pattern(true, VibratorConsts.Super_Mario_Theme, new long[] { 125,75,125,275,200,275,125,75,125,275,200,600,200,600 }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Teenage_Mutant_Ninja_Turtles, new long[] { 75,75,75,75,75,75,75,75,150,150,150,450,75,75,75,75,75,525}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Voltron_Theme, new long[] { 250,200,150,150,100,50,450,450,150,150,100,50,900,2250}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Final_Fantasy_Victory_Fanfare, new long[] { 50,100,50,100,50,100,400,100,300,100,350,50,200,100,100,50,600}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Star_Wars_Imperial_March_Darth_Vader_Theme, new long[] { 500,110,500,110,450,110,200,110,170,40,450,110,200,110,170,40,500}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Go_Go_Power_Rangers, new long[] { 150,150,150,150,75,75,150,150,150,150,450}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Shave_and_a_Haircut_2, new long[] { 100,200,100,100,75,25,100,200,100,500,100,200,100,500 }));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Morse_Code_SOS_2, new long[] { 100,30,100,30,100,200,200,30,200,30,200,200,100,30,100,30,100}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.James_Bond_007, new long[] { 200,100,200,275,425,100,200,100,200,275,425,100,75,25,75,125,75,25,75,125,100,100}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Mortal_Kombat_Theme, new long[] { 100,200,100,200,100,200,100,200,100,100,100,100,100,200,100,200,100,200,100,200,100,100,100,100,100,200,100,200,100,200,100,200,100,100,100,100,100,100,100,100,100,100,50,50,100,800}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Michael_Jackson_Smooth_Criminal, new long[] { 0,300,100,50,100,50,100,50,100,50,100,50,100,50,150,150,150,450,100,50,100,50,150,150,150,450,100,50,100,50,150,150,150,450,150,150}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Dream_Theater_Fatal_Tragedy_What_a_phenomenon, new long[] { 75,38,75,488,75,38,75,200,75,38,75,400}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Dream_Theater_Overture_1928_Intro, new long[] { 75,25,75,25,75,25,75,525,75,25,75,25,75,25,75,25,75,25,75,25,75,225,75,25,75,25,75,25,75,225,75,25,75,25,75,25,75,525,75,25,75,25,75,25,75,25,75,25,75,25,75,225,75,25,75,25,75,25,75,225}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Dream_Theater_Strange_Déjà_Vu_Intro, new long[] { 100,50,100,50,100,50,100,350,100,50,100,50,100,50,100,350,100,50,100,50,100,500,100,50,100,50,100,50,100,1400}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Muse_Madness, new long[] { 80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,320,160,320,160,320}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Pain_of_Salvation_Nihil_Morari, new long[] { 50,50,50,50,50,50,50,550,300,300,100,200,50,50,50,50,50,50,50,250}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.Karnivool_Cote, new long[] { 75,75,75,75,75,225,75,75,75,75,75,75,75,225,75,75,75,75,75,75,75,225,75,75,75,75,75,75,75,225,75,75,75,75,75,75,75,225,75,75,75,75,75,225,75,75,75,225,75,75,75,225,75,75,75,225,75,75,75,75,75,225,75,75,75,75,75,75,75,225,75,75,75,75,75,75,75,225,75,75,75,75,75,75,75,225,75,75,75,75,75,75,75,225,75,75,75,75,75,75}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.TesseracT_Nocturne, new long[] { 660,60,180,60,60,180,60,180,60,180,420,60,180,60,60,180,60,180,60,180,420,60,180,60,60,180,60,180,60,180,420,60,180,60,60,180,60,180,420,60,420,60}));
////        arlPatterns.add(new Pattern(true, VibratorConsts.TesseracT_Perfection, new long[] { 75,225,75,75,75,75,75,225,75,225,75,225,75,75,75,225,75,225,75,75,75,75,75,225,75,225,75,225,75,75,75,225,75,225,75,75,75,75,75,225,75,225,150,150,75,75,75,225,75,375,75,75,75,75,75,225,75,225,75,225,75,75,75,225,75,225,75,75,75,75,75,225,75,225,75,225,75,75,75,225,75,225,75,75,75,75,150,150}));
//    }

//    /**
//     * Vibrate using a vibration {@link Pattern} defined by its position in {@link this.getPattern()}
//     * @param pattern The position of the {@link Pattern} in arlPatterns / {@link this.getPattern()}
//     */
//    public void vibrateWithPattern(int pattern){
//        if(pattern < arlPatterns.size())
//            vibrateWithPattern(arlPatterns.get(pattern));
//    }
//
//    public void vibrateWithPattern(String pattern){
//        for (int i = 0; i < arlPatterns.size(); i++) {
//            if(arlPatterns.get(i).getName().equals(pattern)) {
//                vibrateWithPattern(arlPatterns.get(i));
//                break;
//            }
//        }
//    }
//
//    /**
//     * Vibrate using the {@link Pattern} passed as param
//     * @param pattern The {@link Pattern} to use
//     */
//    public void vibrateWithPattern(Pattern pattern){
//        if(vibrator.hasVibrator())
//            vibrator.vibrate(pattern.getPattern(), -1);
//        else
//            Toast.makeText(mContext, R.string.you_dont_have_a_vibrator, Toast.LENGTH_SHORT);
//    }
}
