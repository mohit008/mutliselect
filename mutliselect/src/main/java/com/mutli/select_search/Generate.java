//package com.mutli.select_search;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by mohit.soni on 17-04-2018.
// * This class generate data
// */
//
//public class Generate {
//
//    public static ArrayList<KeyValue> keyValues = new ArrayList<>();
//    /**
//     * pass object to this class
//     * @param args
//     * @return
//     * @throws IncompatibleTypeError
//     */
//    public ArrayList<KeyValue> getKeyValue(Object args) throws IncompatibleTypeError{
//        keyValues.clear();
//        if(args instanceof String[]){
//            return  IterateOver(Arrays.asList((String[]) args));
//        }
//        else if(args instanceof ArrayList<?>){
//            return  IterateOver((ArrayList)args);
//        }
//        else {
//            new IncompatibleTypeError(args);
//        }
//        return null;
//    }
//
//    /**
//     * ganerata keyvalue data
//     * @param args
//     * @return
//     */
//    private ArrayList<KeyValue> IterateOver(List<String> args){
//        for (String s : args) {
//            KeyValue keyValue = new KeyValue();
//            keyValue.setChecked(false);
//            keyValue.setId("");
//            keyValue.setName(s);
//            keyValue.setVisible(true);
//            keyValues.add(keyValue);
//        }
//        return keyValues;
//    }
//}
