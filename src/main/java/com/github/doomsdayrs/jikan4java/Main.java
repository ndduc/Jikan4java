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
import com.github.ndduc.jikan4java.ext.animelist.Anime_Info;
import com.github.ndduc.jikan4java.ext.animelist.Anime_Info_Impl;
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
    
    private static final String animes = "fate/zero";
    
    public static void main(String[] args) throws Exception{
       printAnimeInfo(11741);
    }
    
    /**
     * print a list of search result
     * including recurring result
     * return value will be store in Map structure where id is represent as key and title as value
     * key value can be use interact with api
     */
    
    public static void printAnimeList(String anime, int limit) throws Exception {
        AnimeSearch animeSearch;
        animeSearch = new AnimeSearch();
        Generate_List genList = new Generate_List();
        animeSearch.setQuery(animes, limit);
        Debug.debug("Initiate", "Anime List Search");
        CompletableFuture<AnimePage> animeCompletableFuture = animeSearch.get();
        List<Anime_List> root = genList.getAnimeList(animeCompletableFuture.get().animes);
        for(int i = 0; i < root.size(); i++) {
            Debug.debug("TEST", root.get(i).getId() + "\t" + root.get(i).getTitle());
        }
    }
    
    /**
     * Print anime information base on provided id
     */
    
    public static void printAnimeInfo(int id) {
        Anime_Info ani = new Anime_Info_Impl(id);
        Debug.debug("TEST", ani.getAnime());
    }
    
  
    
    
    private static void s() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
    }
    
    private static void p(Object object) {
        System.out.println(object);
    }
    
}
