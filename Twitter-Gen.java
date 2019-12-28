package twitterbot2;

import twitter4j.TwitterException;
import java.io.IOException;
import java.io.PrintStream;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;

   public class Twitter-Gen
   {
      private static PrintStream consolePrint;
      
      
      
      public static void main (String []args) throws TwitterException, IOException, Exception
      {
          ConfigurationBuilder cb = new ConfigurationBuilder();
          cb.setDebugEnabled(true)
            .setOAuthConsumerKey("")
            .setOAuthConsumerSecret("")
            .setOAuthAccessToken("")
            .setOAuthAccessTokenSecret("");
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            
         
         new Task().run();
      } 
      
      static Timer timer = new Timer();
      static class Task extends TimerTask{
      @Override
      public void run()
      {
         int delay = (5+new Random().nextInt(5)) * 100000;
         timer.schedule(new Task() {}, delay);
         
         
         Twitterer bigBird = new Twitterer(consolePrint);
         String m = ""; 
         String message = null;
          try {
              message = randomgen(m) + "------Posted by Twitter Bot";
          } catch (Exception ex) {
              Logger.getLogger(TwitterDriver.class.getName()).log(Level.SEVERE, null, ex);
          }
         //bigBird.tweetOut(message);
         System.out.println(message);
      }
      }
      
      public static String randomgen(String message)throws Exception
      {
         File file = new File("randomquestions.txt");
         String m = "";
         BufferedReader br = new BufferedReader(new FileReader(file));
         ArrayList<String> list = new ArrayList<String>();
         while((m = br.readLine()) != null)
         {
          list.add(m);   
         }
         Random rand = new Random();
         return list.get(rand.nextInt(list.size()));
      }
         
   }    
         
   