package ch.kimhauser.android.lib.ctrls.pulsingactionbutton.vibration;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * <p>
 *     A specialized ArrayAdapter for handling vibration {@link Pattern}
 * </p>
 *
 * @author kimhauser.ch, Dave
 * @version 0.0.1 (25.10.2016)
 * @since 0.0.1
 */
public class ArrayAdapterItem extends ArrayAdapter<Pattern> {

    private Context mContext;
    private int layoutResourceId;
    private ArrayList<Pattern> data = null;

    /**
     * Constructor for vibration {@link Pattern} ArrayAdapter used for ListViews etc
     * @param mContext Context as usual
     * @param layoutResourceId The layout resource id for this adapter item
     * @param data The ArrayList actually holding all the vibration {@link Pattern}
     */
    public ArrayAdapterItem(Context mContext, int layoutResourceId, ArrayList<Pattern> data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
         * The convertView argument is essentially a "ScrapView" as described is Lucas post
         * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
         * It will have a non-null value when ListView is asking you recycle the row layout.
         * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
         */
        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position
        Pattern objectItem = data.get(position);

        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView textViewItem = (TextView) convertView.findViewById(android.R.id.text1);
        textViewItem.setText(objectItem.getName());

        return convertView;

    }
}