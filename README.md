[![](https://jitpack.io/v/mohit008/mutliselect.svg)](https://jitpack.io/#mohit008/mutliselect)

## How to import dependency (in build.gradle):


Add it in your root <b>/build.gradle</b> at the end of repositories:

    allprojects {
	  repositories {
	  	  maven {
	  	   url 'https://jitpack.io' 
	  	  }
	  }
	}

Step 2. Add the dependency to <b>app/build.gradle</b>

	dependencies {
	   compile 'com.github.mohit008:mutliselect:527d7c07d7'
	}


### List with multi-select and search option :


#### How to use :
1. <b>Implemant interface and its method</b>

       public class ListSuggest extends Activity implements SelectCheck {
        ArrayList<KeyValue> keyValues = new ArrayList<>();
        ....
    
        @Override
        public void onItemCheck(ArrayList<KeyValue> keyValueArrayList) {
        
            this.keyValues = keyValueArrayList;                    //-- will get list with click value
        }
       }
2. <b>Create object and initialise</b>

       MultiSelectSearchList lv;
       .....
       
       lv = (MultiSelectSearchList) findViewById(R.id.lvDialog);
       .....
    
       lv.setItem(this, this, arrayList, this);                    //-- pass arraylist or string array here
    
    
3. <b>Update list on edittext listener</b>  
        
       et.addTextChangedListener(new TextWatcher() {

         @Override
         public void afterTextChanged(Editable editable) {
       
           // update it..
           lv.searchText(et.getText().toString().toLowerCase(), Generate.keyValues);
         }
       });


#### Demo:
 ![demo_video](https://raw.githubusercontent.com/mohit008/mutliselect/master/app/src/main/res/raw/video_demo.gif)