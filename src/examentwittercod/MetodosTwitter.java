/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examentwittercod;

import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Lenovo
 */
public class MetodosTwitter {
     Twitter twitter;

    /**
     * Costructores para acceder a twitter
     */
    public MetodosTwitter() {

        /*ConfigurationBuilder cb = new ConfigurationBuilder();
         cb.setDebugEnabled(true)
         .setOAuthConsumerKey("*********")
         .setOAuthConsumerSecret("********")
         .setOAuthAccessToken("***********")
         .setOAuthAccessTokenSecret("*********");

        /*
         ----Aqui introduciriamos los nuestros datos personales de cada uno para poder acceder a nuestro twitter.----
        
        
         /*twitter = new TwitterFactory(cb.build()).getInstance();*/    
        twitter = new TwitterFactory("twitter4j.properties").getInstance();

    }

    /**
     * Nos da nuestro timeLine
     */
    public void verTL() throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Mostrando Linea del Tiempo.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }

    }

    /**
     * Busca tweets a partir de una String
     */
    public void buscarTrending(String busqueda) throws TwitterException {

        Query query = new Query(busqueda);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }

    }

    /**
     * Nos permite publicar nuevos twitters
     */
    public void tweetear(String tweet) throws TwitterException {

        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

    }

    
}
