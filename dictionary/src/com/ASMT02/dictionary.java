package com.ASMT02;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.M


public enum dictionary{

    book("book","noun","A set of pages"),
    book1("book","noun","A written work published in printed or electronic form."),
    book2("book","verb","To arrange for someone to have a seat on a plane."),
    book3("book","verb","To arrange something on a particular date.");

    public static final String dictionaryTitle = "===== DICTIONARY 340 JAVA =====";
    private String partOfSpeech;
    private String definition;
    private String word;

     dictionary(String word, String partOfSpeech, String definition) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.definition=definition;
    }

    public String getWord(){
        return this.word;
    }

    public String getPartOfSpeech(){
        return this.partOfSpeech;
    }
    public String getDefinition(){
        return this.definition;
    }


    public static void init() {
         String word = book.getWord();

        HashMap<String,String> list = new HashMap();
        //list.put(new dictionary(book.word, book.definition,book.partOfSpeech));

    }

    public static void main(String args[]){
        HashMap list = new HashMap();
        list.put(new ArrayList<String>());


    for(dictionary entry: dictionary.values()){

    }
    }

}

class startProgram{

}


