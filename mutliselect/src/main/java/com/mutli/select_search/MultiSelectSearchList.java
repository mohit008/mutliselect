package com.mutli.select_search;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mohit.soni on 16-04-2018.
 * Custom list to inflate in your layout and manage task
 */

public class MultiSelectSearchList extends ListView {

    ArrayList<KeyValue> keyValueArrayList = new ArrayList<>();
    Activity activity;
    Context context;
    SelectCheck selectCheck;
    AdapterList adapterList;

    Boolean singleCheck = false;

    int watchTextLimit = 2;

    public MultiSelectSearchList(Context context) {
        super(context);
    }

    public MultiSelectSearchList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiSelectSearchList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * constructor with interface
     *
     * @param context
     * @param activity
     * @param object
     * @param selectCheck
     */
    public void setItem(Context context, Activity activity, Object object, SelectCheck selectCheck) {
        this.keyValueArrayList = (ArrayList<KeyValue>) object;
        Gen.keyValues =  (ArrayList<KeyValue>) object;
        this.activity = activity;
        this.context = context;
        this.selectCheck = selectCheck;
        set();
    }

    /**
     * set adapter to list
     */
    public void set() {
        this.adapterList = new AdapterList(context);
        setAdapter(adapterList);
    }

    /**
     * change watch text limit
     *
     * @param limit
     */
    public void setWatchTextLimit(int limit) {
        this.watchTextLimit = limit;
    }

    public class AdapterList extends ArrayAdapter<String> {
        AdapterList(Context context) {
            super(context, R.layout.list_item);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = activity.getLayoutInflater().inflate(R.layout.list_item, parent, false);
            }
            LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.ll);
            TextView tv = (TextView) convertView.findViewById(R.id.tv);
            final CheckBox cbx = (CheckBox) convertView.findViewById(R.id.cbx);

            final KeyValue keyValue = keyValueArrayList.get(position);

            if (keyValue.getVisible()) {
                tv.setText(keyValue.getName());
                ll.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        keyValue.setChecked(keyValue.isChecked() == false ? true : false);
                        if(singleCheck){
                            for(KeyValue keyValue1 : keyValueArrayList){
                                if(!keyValue1.getName().equals(keyValue.getName())){
                                    keyValue1.setChecked(false);
                                }
                            }
                        }
                        Log.i("Array", keyValue.toString());
                        notifyDataSetChanged();
                        selectCheck.onItemCheck(keyValueArrayList);
                    }
                });
                if (keyValue.isChecked()) {
                    cbx.setChecked(true);
                } else {
                    cbx.setChecked(false);
                }
            }
            return convertView;
        }

        @Override
        public int getCount() {
            int size = 0;
            try {
                size = keyValueArrayList.size();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            return size;
        }

        @Override
        public String getItem(int position) {
            return keyValueArrayList.get(position).getName();
        }
    }

    /**
     * search list with keyword and update list
     *
     * @param text
     * @param keyValues
     */
    public void searchText(String text, ArrayList<KeyValue> keyValues) {
        if (text.length() > watchTextLimit) {
            ArrayList<KeyValue> str = new ArrayList<>();
            str.addAll(keyValues);
            for (KeyValue keyValue : keyValues) {
                if (!keyValue.getName().toLowerCase().contains(text)) {
                    str.remove(keyValue);
                }
            }
            this.keyValueArrayList = str;
        } else {
            this.keyValueArrayList = keyValues;
        }
        adapterList.notifyDataSetChanged();
    }

    public void setSingleCheck(boolean singleCheck){
        this.singleCheck = singleCheck;
    }
}
