[![](https://jitpack.io/v/mohit008/mutliselect.svg)](https://jitpack.io/#mohit008/mutliselect)

## How to import (Add dependency in build.gradle):


Add it in your root <b>/build.gradle</b> at the end of repositories:

    allprojects {
	  repositories {
	  	  maven { url 'https://jitpack.io' }
	  }
	}

Step 2. Add the dependency to <b>app/build.gradle</b>

	dependencies {
	   compile 'com.github.mohit008:mutliselect:527d7c07d7'
	}


### List with multi-select and search option :


### How to use :
#####1. implemant interface and its method

    public class ListSuggest extends Activity implements SelectCheck {
    ArrayList<KeyValue> keyValues = new ArrayList<>();
    ....
    
     @Override
        public void onItemCheck(ArrayList<KeyValue> keyValueArrayList) {
            <!--you will get update list with click value-->
            this.keyValues = keyValueArrayList; 
        }
    }
#####2. Create object and initialise

    MultiSelectSearchList lv;
    .....
    
    lv = (MultiSelectSearchList) findViewById(R.id.lvDialog);
    
    // pass arraylist or string array here
    lv.setItem(this, this, arrayList, this);
    
    
#####3. Update list on edittext listener    
        
    et.addTextChangedListener(new TextWatcher() {

       @Override
       public void afterTextChanged(Editable editable) {
           String watcher = etDialog.getText().toString();
           // update it..
           lv.searchText(watcher.toLowerCase(), Generate.keyValues);
       }
    });
