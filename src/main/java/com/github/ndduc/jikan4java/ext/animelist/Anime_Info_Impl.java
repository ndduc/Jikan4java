/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ndduc.jikan4java.ext.animelist;

import com.github.doomsdayrs.jikan4java.core.search.animemanga.AnimeSearch;
import com.github.doomsdayrs.jikan4java.types.main.anime.Anime;
import com.github.ndduc.jikan4java.helper.Debug;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author ndduc
 */
public class Anime_Info_Impl implements Anime_Info{
    private int id;/*
    AnimeSearch animeSearch;
    CompletableFuture<Anime> cfAnime;
    Anime ani;*/
    public Anime_Info_Impl(int id) {
        Debug.debug("Mutation Check", id);
        this.id = id;
    }
    
    @Override
    public Anime getAnime() {
        try {
            AnimeSearch animeSearch = new AnimeSearch();
            CompletableFuture<Anime> cfAnime = animeSearch.getByID(getId());
            Anime ani = cfAnime.get();
            return ani;
        } catch (InterruptedException e) {
            Debug.debug("Exception in Anime_Info_Impl", "Interrupted");
            e.printStackTrace();
           return null;
        } catch (ExecutionException e) {
            Debug.debug("Exception in Anime_Info_Impl", "Execution");
            e.printStackTrace();
            return null;
        }
    }
    
    

    
    /**
     * @return the id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }
    
    

    
    
}
