package com.ASMT02;
import java.lang.constant.ClassDesc;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.Dictionary;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.sun.source.tree.Tree;

public enum dictionary implements dictionary_abstract {

   /**********************************************************************Enum Data Set*********************************************************************************************/

    def1("arrow",
            new String[]{"noun"},
            new String[]{"Here is one arrow: <IMG> -=>> </IMG>"}),

    def4("book",
            new String[]{"noun","noun","verb","verb"},
            new String[]{
                            "A set of pages.",
                            "A written work published in printed or electronic form.",
                            "To arrange for someone to have a seat on a plane.",
                            "To arrange something on a particular date."}),

    def8("distinct",
            new String[]{"adjective","adjective","adverb","noun","noun","noun","noun","noun"},
            new String[]{
                            "Familiar. Worked in Java.",
                            "Unique. No duplicates. Clearly different or of a different kind.",
                            "Uniquely. Written \"distinctly\".",
                            "A keyword in this assignment.",
                            "A keyword in this assignment.",
                            "A keyword in this assignment.",
                            "An advanced search option.",
                            "Distinct is a parameter in this assignment."
                            }),
    def11(
            "reverse",
            new String[]{"adjective","adjective","noun","noun","noun","noun","noun","noun","noun","verb","verb","verb","verb","verb","verb"},
            new String[]{
                    "On back side",
                    "Opposite to usual or previous arrangement",
                    "A dictionary program's parameter",
                    "Change to opposite direction",
                    "The opposite.",
                    "To be updated...",
                    "To be updated...",
                    "To be updated...",
                    "To be updated...",
                    "Change something to opposite.",
                    "Go back",
                    "Revoke ruling.",
                    "To be updated...",
                    "To be updated...",
                    "Turn something inside out."});





    //placeHolder( "placeHolder",
      //                  new String[]{
        //                    "adjective","adjective","adverb","conjunction","interjection","noun","noun","noun","preposition","pronoun","verb"},
          //              new String[]{
            //        "TBD"});



    public static final String dictionaryTitle = "===== DICTIONARY 340 JAVA =====";
    private String[] def;
    private String[] pos;
    private String word;




    dictionary(String word, String[] pos , String[] def){
        this.word = word;
        this.pos = pos;
        this.def = def;
    }

    public String getWord(){
        return word;
    }
    public String[] getPos(){
        return pos;
    }
    public String[] getDef(){
        return def;
    }
    /**********************************************************************Organizing data in MultiMaps*********************************************************************************************/

    /* Look at the words in the enum, notice that there all 1 word, Today you dont hav to worry about the words being in ab array
    * or just leave it for now. Make sure that the offical collection is stored in a public constructor.
    *
    *
    * */
    public static Multimap<String,String> completeList =ArrayListMultimap.create();
    public static void initWords(dictionary wordLoaded){

        Deque<String> word = new LinkedList();
        String tempWord =wordLoaded.getWord();
        String[] tempPos = wordLoaded.getPos();
        String[] tempDef = wordLoaded.getDef();

       // word.addAll(Arrays.asList(tempWord));
       // ArrayDeque pos = new ArrayDeque(Arrays.asList(tempPos));
       // Deque<String> def = new ArrayDeque(Arrays.asList(wordLoaded.getDef()));

            String x = wordLoaded.getWord();
            for (int i = 0 ; i<tempPos.length;i++){
                if(x.equalsIgnoreCase("placeholder")){
                    String y = tempDef[0];
                    String z = tempPos[i];
                    completeList.put(y,z);
                }else{
                    String y = tempDef[i];
                    String z = tempPos[i];
                    String jk = ("["+z+"] : " +y);
                    completeList.put(x,jk);
                }



            }

    }

    public static void printOut(String selectWord){
        if(completeList.containsKey(selectWord.toLowerCase())) {
            posNdef.entries().forEach(value->System.out.print("\t"+selectWord +" "+value+"\n"));
        }
        posNdef.clear();

    }
    public static void printOut(String selectWord , String selectPos){
        System.out.print(selectPos);
        posNdef.clear();

    }
    public static Multimap<String,String> posNdef =ArrayListMultimap.create();

    public static void posList(dictionary wordLoaded){
        String[] tempPos = wordLoaded.getPos();
        String[] tempDef = wordLoaded.getDef();

        String x = wordLoaded.getWord();

            for (int i = 0 ; i<tempPos.length;i++){

                    String y = tempDef[i];
                    String z = tempPos[i];
                    posNdef.put(z,y);

        }
        //posNdef.entries().forEach((value)->System.out.print(value+"\n"));

    }





    /**********************************************************************Load Data*********************************************************************************************/




    public static Scanner userIn = new Scanner(System.in);
    public static int keywords = EnumSet.allOf(dictionary.class).size();
    public static int defCount = completeList.size();
    public static Object[] enumNames = EnumSet.allOf(dictionary.class).toArray();

    public static void init(){

        var jdsf = EnumSet.allOf(dictionary.class);
        var x = jdsf.toArray();

        for(int i = 0 ; i<jdsf.size();i++){
            initWords((dictionary) x[i]);
        }
        defCount = completeList.size();


        System.out.println("! Loading Data...");
        System.out.println("! Loading completed..."+"\n");
        System.out.println(dictionary.dictionaryTitle);
        System.out.println("---- Keywords: " + keywords);
        System.out.println("---- Definition: " +defCount);
        help();


    }



    static  int count = 1;
    public static void main(String args[]) {
        init();

    while (true){

        String lookup;
        System.out.print("|\nSearch ["+count+"]: ");
        lookup = userIn.nextLine();
        String[] multiWord = lookup.split(" ");

        System.out.println(multiWord.length);
        switch (multiWord.length){
            case 1:
                for(int i = 0 ; i<keywords;i++){
                    initWords((dictionary) enumNames[i]);
                    if(((dictionary) enumNames[i]).getWord().equalsIgnoreCase(lookup)){
                        posList((dictionary) enumNames[i]);
                        printOut(lookup);
                    }
                }
                break;
            case 2:
                for(int i = 0 ; i<keywords;i++){
                    initWords((dictionary) enumNames[i]);
                    if(((dictionary) enumNames[i]).getWord().equalsIgnoreCase(multiWord[0])){
                        posList((dictionary) enumNames[i]);
                        printOut(multiWord[0],multiWord[1]);
                    }
                }
        }
        count++;
        exit(lookup);


    }























    }


    /**********************************************************************User Interaction*********************************************************************************************/

    public static void directions(){
        String lookup;
        System.out.print("\nSearch ["+count+"]: ");
        lookup = userIn.nextLine();
        System.out.print("\t|\nPARAMETER HOW-TO, please enter:\n" +
                "\t1. A search key -then 2. An optional part of speech -then\n" +
                "\t3. An optional 'distinct' -then 4. An optional 'reverse'\n\t|");
        count++;
        exit(lookup);

    }

    public static void help(){
        System.out.print("\t|\nPARAMETER HOW-TO, please enter:\n" +
                "\t1. A search key -then 2. An optional part of speech -then\n" +
                "\t3. An optional 'distinct' -then 4. An optional 'reverse'\n\t");
    }

    public static void exit(String q){
        if(q.equalsIgnoreCase("!q")){
            System.out.println("\n-----THANK YOU-----");
            System.exit(-1);
        }
        if(q.equalsIgnoreCase("!help")){
            help();
        }


    }


}


