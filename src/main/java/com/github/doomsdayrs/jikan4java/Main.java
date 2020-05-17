/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.doomsdayrs.jikan4java;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.doomsdayrs.jikan4java.core.search.animemanga.AnimeSearch;
import com.github.doomsdayrs.jikan4java.core.userlisting.AnimeUserListingSearch;
import com.github.doomsdayrs.jikan4java.types.main.anime.Anime;
import com.github.doomsdayrs.jikan4java.types.main.anime.animePage.AnimePage;
import com.github.doomsdayrs.jikan4java.types.main.anime.episodes.Episodes;
import com.github.doomsdayrs.jikan4java.types.main.user.listing.animelist.AnimeListAnime;
import com.github.doomsdayrs.jikan4java.types.support.MoreInfo;
import com.github.doomsdayrs.jikan4java.types.support.basic.meta.Genre;
import com.github.ndduc.jikan4java.ext.animelist.Anime_Info;
import com.github.ndduc.jikan4java.ext.animelist.Anime_Info_Impl;
import com.github.ndduc.jikan4java.ext.animelist.Anime_List;
import com.github.ndduc.jikan4java.ext.animelist.Generate_List;
import com.github.ndduc.jikan4java.helper.Debug;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ndduc
 */
public class Main {
    
    private static final String animes = "fate/zero";
    
    public static void main(String[] args) throws Exception{
       
       
     // Debug.debug("My List", getMyAnimeList("kareford", "fin"));
       
      //List<List<Genre>> lstGen = new ArrayList<ArrayList<Genre>>();
      
      Map<Integer, String> anMap = getMyAnimeList("kareford", "fin");
      Map<Integer, List<Genre>> map = new HashMap<>();
      int i = 0;
      for(Integer key : anMap.keySet()) {
          try {
           map.put(i, getAnimeInfo(key).getAnime().genres);
         //  Debug.debug("TS", getAnimeInfo(key).getAnime().title);
          } catch (Exception e) {
            Debug.debug("Exception", "While print");
            e.printStackTrace();
          } finally {
            i++;
          }
      }
        map.keySet().forEach((key) -> {
            for(int z = 0; z < map.get(key).size(); z++) {
                Debug.debug("Genre", map.get(key).get(z).name);
            }
        });
        
       // Debug.debug("", getAnimeInfo(19151).getAnime().genres);
      //19151
      //12431
    }
    
    public static Map<Integer, String> getMyAnimeList(String user, String option) {
        AnimeUserListingSearch userSearch = new AnimeUserListingSearch(user, option);
        Map<Integer, String> aniMap = new HashMap<>();
        try {
            ArrayList<AnimeListAnime> aniList = userSearch.getList().get().animes;
            for(int i = 0; i < aniList.size(); i++) {
               // Debug.debug(aniList.get(i).mal_id, aniList.get(i).title);
                aniMap.put(aniList.get(i).mal_id, aniList.get(i).title);
            }
            return aniMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    /**
     cost: 16.00
     * cost: 1.80 /ea
     * price: 2.29
     * price: 17.00
     
     */
    
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
        //Debug.debug("Initiate", "Anime List Search");
        CompletableFuture<AnimePage> animeCompletableFuture = animeSearch.get();
        List<Anime_List> root = genList.getAnimeList(animeCompletableFuture.get().animes);
        for(int i = 0; i < root.size(); i++) {
            Debug.debug("TEST", root.get(i).getId() + "\t" + root.get(i).getTitle());
        }
    }
    
    /**
     * Print anime information base on provided id
     */
    
    public static Anime_Info getAnimeInfo(int id) {
        Anime_Info ani = new Anime_Info_Impl(id);
       // Debug.debug("TEST", ani.getAnime());
        return ani;
    }
    
  
    
    
    private static void s() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
    }
    
    private static void p(Object object) {
        System.out.println(object);
    }
    
}
