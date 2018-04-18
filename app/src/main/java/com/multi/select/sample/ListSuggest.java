package com.multi.select.sample;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.multi.select.R;
import com.mutli.select_search.Gen;
import com.mutli.select_search.Generate;
import com.mutli.select_search.KeyValue;
import com.mutli.select_search.MultiSelectSearchList;
import com.mutli.select_search.SelectCheck;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mohit.soni on 16-04-2018.
 */

public class ListSuggest extends Activity implements SelectCheck {

    EditText etDialog;

    MultiSelectSearchList lvDialog;
    ArrayList<KeyValue> keyValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        etDialog = findViewById(R.id.etDialog);
        lvDialog = (MultiSelectSearchList) findViewById(R.id.lvDialog);

        // pass this array
        String[] stringArray = AppConstant.xs.split("\n");

        // pass this array list
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(stringArray));

        for (String s : arrayList) {
            KeyValue keyValue = new KeyValue();
            keyValue.setChecked(false);
            keyValue.setId("");
            keyValue.setName(s);
            keyValue.setVisible(true);
            keyValues.add(keyValue);
        }

        // call it..
        lvDialog.setItem(this, this, keyValues, this);

        etDialog.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String watcher = etDialog.getText().toString();

                // update it..
                lvDialog.searchText(watcher.toLowerCase(), Gen.keyValues);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }
        });
    }


    @Override
    public void onItemCheck(ArrayList<KeyValue> keyValueArrayList) {
        this.keyValues = keyValueArrayList;
    }
}
