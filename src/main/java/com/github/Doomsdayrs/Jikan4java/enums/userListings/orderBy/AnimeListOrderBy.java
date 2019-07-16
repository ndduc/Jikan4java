package com.github.Doomsdayrs.Jikan4java.enums.userListings.orderBy;

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
 * 25 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum AnimeListOrderBy implements ListOrderBy {
    TITLE("title"),
    FINISH_DATE("finish_date"),
    START_DATE("start_date"),
    SCORE("score"),
    LAST_UPDATED("last_updated"),
    TYPE("type"),
    RATED("rated"),
    REWATCH("rewatch"),
    REWATCHED_VALUE(REWATCH.type),
    PRIORITY("priority"),
    PROGRESS("progress"),
    EPISODES_WATCHED(PROGRESS.type),
    STORAGE("storage"),
    AIR_START("air_start"),
    AIR_END("air_end"),
    STATUS("status");

    private final String type;

    AnimeListOrderBy(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}