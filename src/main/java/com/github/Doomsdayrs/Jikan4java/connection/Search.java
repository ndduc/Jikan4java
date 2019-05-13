package com.github.Doomsdayrs.Jikan4java.connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.Stati;
import com.github.Doomsdayrs.Jikan4java.types.Support.enums.Types;

import java.util.concurrent.CompletableFuture;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 13 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public class Search<T> extends Retriever {
    private T t;
    private final Types type;
    private final Class aClass;

    private String query = null;
    private int pages = 0;
    private Stati status = null;

    public Search(Types type) {
        super();
        this.type = type;
        this.aClass = type.getC();
    }

    Search(Types type, ObjectMapper mapper) {
        super(mapper);
        this.type = type;
        this.aClass = type.getC();
    }

    private String createURL(){
        StringBuilder builder = new StringBuilder();
        builder.append(baseURL+"/search/");
        builder.append(type);
        builder.append("?q="+query.replaceAll(" ","%20"));
        if (pages !=0)
            builder.append("&limit="+pages);
        System.out.println(builder.toString());
        return builder.toString();
    }


    public void setPages(int pages) {
        this.pages=pages;
    }

    public Search<T> setQuery(String title) {
        this.query = title;
        return this;
    }

    public Search<T> setStatus(Stati status) {
        if (type == Types.MANGA || type == Types.ANIME)
            this.status = status;
        return this;
    }

    public CompletableFuture<T> get(){
        return retrieve(aClass,createURL());
    }
}
