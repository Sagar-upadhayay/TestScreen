package com.testscreen.Model;

import java.util.List;

public class NesApiResponse {

    List<HeadLine> articles;

    public List<HeadLine> getArticles() {
        return articles;
    }

    public void setArticles(List<HeadLine> articles) {
        this.articles = articles;
    }
}
