package com.ASMT02;
import java.lang.constant.ClassDesc;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.Dictionary;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.sun.source.tree.Tree;

public enum dictionary implements dictionary_abstract {

   /**********************************************************************Enum Data Set*********************************************************************************************/

    def1(new String[]{"arrow"},
            new String[]{"noun"},
            new String[]{"Here is one arrow: <IMG> -=>> </IMG>"}),

    def4(new String[]{"books"},
            new String[]{"noun","noun","verb","verb"},
            new String[]{
                            "A set of pages.",
                            "A written work published in printed or electronic form.",
                            "To arrange for someone to have a seat on a plane.",
                            "To arrange something on a particular date."}),

    def8(new String[]{"distinct"},
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
            new String[]{"Reverse"},
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
                    "Turn something inside out."}),





    placeHolder( "placeHolder",
                        new String[]{
                            "adjective","adjective","adverb","conjunction","interjection","noun","noun","noun","preposition","pronoun","verb"}
                );



    public static final String dictionaryTitle = "===== DICTIONARY 340 JAVA =====";
    private String[] def;
    private String[] pos;
    private String[] word;


    dictionary(String word, String[] pos){
    }

    dictionary(String[] word, String[] pos , String[] def){
        this.word = word;
        this.pos = pos;
        this.def = def;
    }

    public String[] getWord(){
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
    public static void orgWord() {
        Deque<String> word = new LinkedList();
        Deque<String> pos = new ArrayDeque();
        Deque<String> def = new ArrayDeque();
        String[] tempWord = def1.getWord();
        String[] tempPos = def1.getPos();
        String[] tempDef = def1.getDef();

        word.addAll(Arrays.asList(tempWord));
        pos.addAll(Arrays.asList(tempPos));
        def.addAll(Arrays.asList(tempDef));

        Multimap<String,String> full = ArrayListMultimap.create();
        Multimap<String,String> completeList =ArrayListMultimap.create();

        while(!pos.isEmpty()){
            String x = word.pop();
            String y = pos.pop();
            String z = def.pop();
            String jk = ("["+y+"] : " +z);
           completeList.put(x,jk);
        }

       System.out.print(completeList.containsKey("ArRow".toLowerCase()));

    }




    /**********************************************************************Load Data*********************************************************************************************/




    public static Scanner userIn = new Scanner(System.in);

    public static void init(){
        int wordCount=0;
        int defCount =0;

        System.out.println("! Loading Data...");
        System.out.println("! Loading completed..."+"\n");
        System.out.println(dictionary.dictionaryTitle);
        System.out.println("---- Keywords: " + wordCount);
        System.out.println("---- Definition: " +defCount);



    }

    static  int count = 1;
    public static void main(String args[]) {
    //init();
    orgWord();
  //EnumSet.allOf(dictionary.class).forEach(word->System.out.println(word));
    /*while (true){
        directions();
    }*/























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

    public static void exit(String q){
        if(q.equalsIgnoreCase("!q")){
            System.out.println("\n-----THANK YOU-----");
            System.exit(-1);
        }


    }


}


