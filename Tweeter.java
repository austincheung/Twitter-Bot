package twitterbot2;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;

import java.io.IOException;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;
import twitter4j.conf.ConfigurationBuilder;

public class Tweeter
   {
      private final Twitter twitter;
      private final PrintStream consolePrint;
      private final List<Status> statuses;

     
      public Twitterer(PrintStream console)
      {
         // Makes an instance of Twitter - this is re-useable and thread safe.
         // Connects to Twitter and performs authorizations.
         twitter = TwitterFactory.getSingleton(); 
         consolePrint = console;
         statuses = new ArrayList<Status>();
      }
      
      public void tweetOut(String message) throws TwitterException, IOException
      {
          ConfigurationBuilder cb = new ConfigurationBuilder();
          cb.setDebugEnabled(true)
            .setOAuthConsumerKey("")
            .setOAuthConsumerSecret("")
            .setOAuthAccessToken("")
            .setOAuthAccessTokenSecret("");
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
          
          Status status = twitter.updateStatus(message);
          System.out.println("Successfully updated the status to [" + status.getText() + "].");
      }
   
   }  
