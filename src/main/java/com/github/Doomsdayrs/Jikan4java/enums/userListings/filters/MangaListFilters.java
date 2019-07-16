package com.github.Doomsdayrs.Jikan4java.enums.userListings.filters;

import com.github.Doomsdayrs.Jikan4java.types.Main.User.Listing.MangaList.MangaList;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 * Jikan4java
 * 16 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum MangaListFilters implements UserListFilters {
    ALL("all"),
    READING("reading"),
    COMPLETED("completed"),
    ONHOLD("onhold"),
    DROPPED("dropped"),
    PLANTOREAD("plantoread"),
    PTR(PLANTOREAD.type);

    private final String type;
    private final Class aClass = MangaList.class;

    MangaListFilters(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public String getForm() {
        return "mangalist";
    }

    @Override
    public Class getaClass() {
        return aClass;
    }
}