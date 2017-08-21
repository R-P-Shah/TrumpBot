import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rahul on 7/2/2017.
 * Imitates Donald Trump's tweeting
 *
 * Includes his Android (most likely him) tweets and his iphone (most likely staff)
 *
 * I'm afraid this might contaminate the data as we will have less pure Trump to work with and more announcement-like
 * crap, but it is for the best because there's some juicy stuff in there. It's easy enough anyway to fix
 *
 */
public class Trump_Bot {

    public static void main(String[] args) throws IOException{

        String file_name = "C:\\Users\\rahul\\Desktop\\trump.txt";

        try{
            Tweet_Parser real_news = new Tweet_Parser(file_name);
            ArrayList<String> tweets = real_news.getTweets();

            for(String s: tweets){
                System.out.println(s);

            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}
