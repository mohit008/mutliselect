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


### List with single, multi select and search option :


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
       
       //add value to key value
       ArrayList<KeyValue> keyValues = new ArrayList<>();
       for (String s : arrayList) {
               KeyValue keyValue = new KeyValue();
               keyValue.setChecked(false);
               keyValue.setId("");
               keyValue.setName(s);
               keyValue.setVisible(true);
               keyValues.add(keyValue);
       }
       
3. <b>For single click feature (skip for multi click)

       lvDialog.setSingleCheck(true);
    
4. <b>Set Item to list:
   
       lv.setItem(this, this, keyValues, this);                    //-- pass arraylist or string array here
    
    
5. <b>Update list on edittext listener</b>  
        
       et.addTextChangedListener(new TextWatcher() {

         @Override
         public void afterTextChanged(Editable editable) {
       
           // update it..
           lv.searchText(et.getText().toString().toLowerCase(), Generate.keyValues);
         }
       });


#### Demo:
 ![demo_video](https://raw.githubusercontent.com/mohit008/mutliselect/master/video_demo.gif)