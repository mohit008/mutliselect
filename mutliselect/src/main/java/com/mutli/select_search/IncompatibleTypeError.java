package com.mutli.select_search;

import android.util.Log;

/**
 * Created by mohit.soni on 17-04-2018 throws error when in compatible type is passed
 */

class IncompatibleTypeError extends Exception {

    Object args;

    public IncompatibleTypeError(Object args) {
        this.args = args;
        getErr();
    }

    public void getErr(){
        Log.e("IncompatibleTypeError", args + " Object you passed is incompatible type of collection");
    }
}
