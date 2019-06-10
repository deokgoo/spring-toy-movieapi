package com.deok.movieapi.service;

import com.deok.movieapi.model.MovieVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MovieAPIService {
    @Autowired
    UrlConnection urlcon;

    public List<MovieVO> findMovie(String query){
        String json = urlcon.requestUrl("/search/movie","GET","&query="+query);
        List<MovieVO> lst = getMovieList(json);
        return lst;
    }

    public List<MovieVO> getRanking(){
        String json = urlcon.requestUrl("/trending/movie/day","GET","");
        List<MovieVO> lst = getMovieList(json);
        return lst;
    }

    private List<MovieVO> getMovieList(String json) {
        List<MovieVO> lst = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode resultNode = null;

        try {
            resultNode = mapper.readTree(json).path("results");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator iter = resultNode.iterator();
        while (iter.hasNext()) {
            MovieVO movieVO = new MovieVO();
            JsonNode jn = (JsonNode) iter.next();
            movieVO.setTitle(jn.get("title").asText());
            movieVO.setOverview(jn.get("overview").asText());
            movieVO.setPosterPath(jn.get("poster_path").asText());
            movieVO.setPopular(jn.get("popularity").asText());
            System.out.println(movieVO.toString());
            lst.add(movieVO);
        }
        return lst;
    }
}
