package com.github.doomsdayrs.jikan4java.types.support.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.doomsdayrs.jikan4java.types.support.stats.score.Score;

public class MangaStats extends Stats {

    @JsonProperty("reading")
    public int reading;
    @JsonProperty("plan_to_read")
    public int plan_to_read;

    MangaStats(@JsonProperty("request_hash") String request_hash, @JsonProperty("request_cached") boolean request_cached, @JsonProperty("request_cache_expiry") int request_cache_expiry, @JsonProperty("completed") int completed, @JsonProperty("on_hold") int on_hold, @JsonProperty("dropped") int dropped, @JsonProperty("plan_to_watch") int plan_to_watch, @JsonProperty("total") int total, @JsonProperty("scores") Score scores) {
        super(request_hash, request_cached, request_cache_expiry, completed, on_hold, dropped, total, scores);
    }

    @Override
    public String toString() {
        return "MangaStats{" +
                "reading=" + reading +
                ", plan_to_read=" + plan_to_read +
                ", request_hash='" + request_hash + '\'' +
                ", request_cached=" + request_cached +
                ", request_cache_expiry=" + request_cache_expiry +
                ", completed=" + completed +
                ", on_hold=" + on_hold +
                ", dropped=" + dropped +
                ", total=" + total +
                ", scores=" + scores +
                '}';
    }
}
