/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.doomsdayrs.jikan4java;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.doomsdayrs.jikan4java.core.search.animemanga.AnimeSearch;
import com.github.doomsdayrs.jikan4java.types.main.anime.Anime;
import com.github.doomsdayrs.jikan4java.types.main.anime.animePage.AnimePage;
import com.github.doomsdayrs.jikan4java.types.main.anime.episodes.Episodes;
import com.github.doomsdayrs.jikan4java.types.support.MoreInfo;
import com.github.ndduc.jikan4java.ext.animelist.Anime_List;
import com.github.ndduc.jikan4java.ext.animelist.Generate_List;
import com.github.ndduc.jikan4java.helper.Debug;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ndduc
 */
public class Main {
    
    private static final String [] animes = {"Fate/Zero"};
    
    public static void main(String[] args) throws Exception{
        AnimeSearch animeSearch;

        
        
        for(String title : animes) {
            animeSearch = new AnimeSearch();
            Generate_List genList = new Generate_List();
            animeSearch.setQuery(title, 10);
            Debug.debug("Initiate", "Anime Search");
            CompletableFuture<AnimePage> animeCompletableFuture = animeSearch.get();
            List<Anime_List> root = genList.getAnimeList(animeCompletableFuture.get().animes);
            for(int i = 0; i < root.size(); i++) {
                Debug.debug("TEST", root.get(i).getId() + "\t" + root.get(i).getTitle());
            }
            
           // s();
            /*System.out.println(animeCompletableFuture.get().genres);
            System.out.println(animeCompletableFuture.get().genres.get(1));
            */
            /*
            List arrTest = animeCompletableFuture.get().genres;
            for(int i = 0; i < arrTest.size(); i++) {
                Debug.debug("TEST" , animeCompletableFuture.get().genres.get(i).name);
            }*/
            
           // animeCompletableFuture.thenAccept(Main::p);
            //AnimePage anime = animeCompletableFuture.get();
            
           // Debug.debug("TEST", animeCompletableFuture.get().animes);
            
           
            /*
            Debug.debug("Initiate", "Episode Search");
            CompletableFuture<Episodes> episodesCompletableFuture = anime.getEpisodes();
            episodesCompletableFuture.thenAccept(Main::p);
            Episodes episodes = episodesCompletableFuture.get();
            s();*/
        }
        
    }
    
  
    
    
    private static void s() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
    }
    
    private static void p(Object object) {
        System.out.println(object);
    }
    
}
