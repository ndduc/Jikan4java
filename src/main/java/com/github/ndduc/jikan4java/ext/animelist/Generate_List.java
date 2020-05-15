/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ndduc.jikan4java.ext.animelist;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ndduc
 */
public class Generate_List {
    
    private JsonNode root;
    
    /**
     * Convert given animepage to json
     * @param List as animepage
     */
    private JsonNode AnimePageToJson(List _list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
           String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(_list);
           root = objectMapper.readTree(json);
           return getRoot();
        } catch(Exception e) {
           e.printStackTrace();
           return null;
        }
    }
    
    /**
     * Initiate Anime_List instance base on the element of root Json
     * @param root as root json
     */
    private Anime_List JsonToAnimeList(JsonNode root) {
        Anime_List aniList = new Anime_List(root.get("mal_id").toString(), root.get("title").toString());
        return aniList;
    }
    
    public List<Anime_List> getAnimeList(List _list) {
        AnimePageToJson(_list);
        List <Anime_List> lst = new ArrayList<Anime_List>();
        for (int i = 0; i < getRoot().size(); i++) {
            lst.add(JsonToAnimeList(getRoot().get(i)));
        }
        return lst;
    }
    

    /**
     * @return the root
     */
    public JsonNode getRoot() {
        return root;
    }
    
    
    
}
