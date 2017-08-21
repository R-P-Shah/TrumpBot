import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Created by rahul on 7/1/2017.
 *
 * Takes the tweets by Trump from http://www.trumptwitterarchive.com/archive
 * and formats it
 */
public class Tweet_Parser {

    private String file;

    public Tweet_Parser(String f) throws IOException {
        //take the text and make a file
        file = f;

    }

    public ArrayList<String> getTweets() throws IOException{
        FileReader fr = new FileReader(file);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];

        for(int i = 0; i < numberOfLines; i++){
            textData[i] = textReader.readLine();
        }

        ArrayList<String> processed_tweets = new ArrayList<String>();
        for(String s: textData){
            if(!s.contains("\"")){
                if(s.contains("[") && s.contains(":")){

                    int start = s.indexOf(":");
                    int end = s.indexOf("[");

                    //System.out.println("START AND END: " + start + " " + end);

                    s = s.substring(start+ 19,end);
                    if(s.charAt(1) == '.')
                        s = s.substring(2);
                    processed_tweets.add(s);
                }

            }
        }

        textReader.close();
        return processed_tweets;


    }

    private int readLines() throws IOException{
        FileReader file_to_read = new FileReader(file);
        //BufferedReader bf = new BufferedReader(file_to_read);
        BufferedReader bf = new BufferedReader(new InputStreamReader(file_to_read, "UTF-8"));
        

        String aLine;
        int numberOfLines = 0;

        while((aLine = bf.readLine()) != null){
            numberOfLines++;
        }

        bf.close();

        return numberOfLines;
    }


}


