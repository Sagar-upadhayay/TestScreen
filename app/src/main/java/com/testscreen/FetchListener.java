package com.testscreen;

import com.testscreen.Model.HeadLine;
import com.testscreen.Model.NesApiResponse;

import java.util.List;

public interface FetchListener<NesResponseListener> {
    void onFetch(List<HeadLine> list, String message);
    void  onError(String Message);
}
