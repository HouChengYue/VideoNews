package com.feicuiedu.videonews.bombapi;

import com.feicuiedu.videonews.bombapi.entity.CommentsEntity;
import com.feicuiedu.videonews.bombapi.entity.NewsEntity;
import com.feicuiedu.videonews.bombapi.other.InQuery;
import com.feicuiedu.videonews.bombapi.result.QueryResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 视频新闻相关操作的Restful接口，包括获取新闻，收藏新闻，发表评论等
 * 作者：yuanchao on 2016/8/16 0016 11:36
 * 邮箱：yuanchao@feicuiedu.com
 */
public interface NewsApi {
    /**
     * 获取所有视频新闻列表, 接时间新到旧排序
     */
    @GET("1/classes/News?order=-createAt")
    Call<QueryResult<NewsEntity>> getVideoNewsList(@Query("limit") int limit, @Query("skip") int skip);

    @GET("1/classes/Comments?include=author&order=-createAt")
    Call<QueryResult<CommentsEntity>> getComments(
            @Query("limit") int limit,
            @Query("skip") int skip,
            @Query("where") InQuery where);
}
