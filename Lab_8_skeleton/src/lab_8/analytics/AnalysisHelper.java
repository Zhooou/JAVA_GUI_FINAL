/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_8.analytics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lab_8.entities.Comment;
import lab_8.entities.Post;
import lab_8.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    
    
    public void userWithMostLikes(){
        
        
    }
    
    public void getFiveMostLikedComment(){
        
        
    }
    
    public void getAverageLikesPerComment(){
        Map<Integer,Comment> comments = DataStore.getInstance().getComments();
        int likes = 0;
        int length = comments.size();
        for(Comment c:comments.values()){
            int number = c.getLikes();
            likes = likes+number;
        }
        int averageNumber = likes/length;
        System.out.println("Average Number Per Comment: -------------------------- ");
        System.out.println(averageNumber);
    }
    
    public void getTop5InactiveUsersBasedOnPosts(){
        List<Post> postList = new ArrayList(DataStore.getInstance().getPosts().values());
        List<User> userList = new ArrayList(DataStore.getInstance().getUsers().values());
        Map<Integer, Integer> userActiveMap = new HashMap();
        for(User u: userList){
            userActiveMap.put(u.getId(), 0);
        }
        for(Post p: postList){
            int postCount = 0;
            if(userActiveMap.containsKey(p.getUserId())){
                postCount = userActiveMap.get(p.getUserId());
            }
            postCount++;
            userActiveMap.put(p.getUserId(), postCount);
        }
        System.out.println(userActiveMap);
        List<Map.Entry<Integer, Integer>> rankList = new ArrayList(userActiveMap.entrySet());
        Collections.sort(rankList, new Comparator<Map.Entry<Integer, Integer>>(){

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
            
        });
        for(int i = 0; i < 5; i++){
            System.out.println("User ID: "+rankList.get(i).getKey() + " Post Counts: "+ rankList.get(i).getValue());
        }
    }
}
