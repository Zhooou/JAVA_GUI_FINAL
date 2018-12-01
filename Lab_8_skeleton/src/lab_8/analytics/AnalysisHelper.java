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
        Map<Integer,Integer> userLikecount = new HashMap<>();
           Map<Integer,User> users = DataStore.getInstance().getUsers();
           for(User user : users.values()){
               for(Comment c:user.getComments()){
                   int likes = 0;
                   if(userLikecount.containsKey(user.getId())){
                       likes = userLikecount.get(user.getId());
                      
                   }
                    likes+= c.getLikes();
                    userLikecount.put(user.getId(), likes);
               }
           }
        int max = 0;
         int maxId = 0;
         for(int id: userLikecount.keySet()){
             if(userLikecount.get(id)> max){
                 max = userLikecount.get(id);
                 maxId = id;
                 
             }
         }
         System.out.println("User with most likes:"+max+"\n"+users.get(maxId));
    }
    
    public void getFiveMostLikedComment(){
        Map<Integer,Comment> comments = DataStore.getInstance().getComments();
        
        List<Comment> commentList = new ArrayList<>(comments.values());
        Collections.sort(commentList,new Comparator<Comment>(){
        @Override
        public int compare(Comment c1, Comment c2){
            return c2.getLikes() - c1.getLikes();
        }
    });
        System.out.println("5 most liked comments");
        for(int i = 0;i<5;i++){
        System.out.println(commentList.get(i));
    }
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
        System.out.print("Average Number Per Comment: ");
        System.out.println(averageNumber);
    }
     
    public void getPostMostLikedComment(){
        List<Comment> cList = new ArrayList(DataStore.getInstance().getComments().values());
        Collections.sort(cList, new Comparator<Comment>(){
            @Override
            public int compare(Comment o1, Comment o2) {
                return - o1.getLikes() + o2.getLikes();
            }
            
        });
//        System.out.println(cList);
        List<Post> pList = new ArrayList(DataStore.getInstance().getPosts().values());
        for(Post p : pList){
            if(p.getComments().contains(cList.get(0))){
                System.out.println("Post With Most Liked Comment id :" + p.getPostId());
            }
        }
       }   
       
     public void getPostMostComment(){
       //  List<Post> postList = new ArrayList(DataStore.getInstance().getPosts().values());
         

           Map<Integer,Integer> postComentcount = new HashMap<>();
           Map<Integer,Post> posts = DataStore.getInstance().getPosts();
 for(Post post : posts.values()){
   int commentCount = 0;
         if(postComentcount.containsKey(post.getPostId())){
                      commentCount = postComentcount.get(post.getPostId());
                       
                   }
         
         for(Comment c : post.getComments())
             commentCount++;
          
             postComentcount.put(post.getPostId(), commentCount);

     
 }
         int max = 0;
         int maxId = 0;
         for(int id: postComentcount.keySet()){
             if(postComentcount.get(id)> max){
                 max = postComentcount.get(id);
                 maxId = id;
       }   
   
}         
    System.out.println("Post ID with most comments:"+posts.get(maxId).getPostId()+"\n"+"Comments number:"+max);
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
            System.out.println("User ID: "+rankList.get(i).getKey() + " Top5 InactiveUsers based Post Counts: "+ rankList.get(i).getValue());
        }
    }
    
    public void getTop5InactiveUsersBasedOnComments(){
        List<Comment> commentList = new ArrayList(DataStore.getInstance().getComments().values());
        List<User> userList = new ArrayList(DataStore.getInstance().getUsers().values());
        Map<Integer, Integer> userActiveMap = new HashMap();
        for(User u: userList){
            userActiveMap.put(u.getId(), 0);
        }
        for(Comment p: commentList){
            int commentCount = 0;
            if(userActiveMap.containsKey(p.getUserId())){
                commentCount = userActiveMap.get(p.getUserId());
            }
            commentCount++;
            userActiveMap.put(p.getUserId(), commentCount);
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
            System.out.println("User ID: "+rankList.get(i).getKey() + " Top5 InactiveUsers based Comment Counts: "+ rankList.get(i).getValue());
        }
    }
    
    public void getTop5InactiveUsersOverall(){
        List<Comment> commentList = new ArrayList(DataStore.getInstance().getComments().values());
        List<Post> postList = new ArrayList(DataStore.getInstance().getPosts().values());
        List<User> userList = new ArrayList(DataStore.getInstance().getUsers().values());
        Map<Integer, Integer> userActiveMap = new HashMap();
        for(User u: userList){
            userActiveMap.put(u.getId(), 0);
        }        
        for(Comment p: commentList){
            int Count = 0;
            if(userActiveMap.containsKey(p.getUserId())){
                Count = userActiveMap.get(p.getUserId());
            }
            Count++;
            Count = Count + p.getLikes();
            userActiveMap.put(p.getUserId(), Count);
        }
        
        for(Post p: postList){
            int Count = 0;
            if(userActiveMap.containsKey(p.getUserId())){
                Count = userActiveMap.get(p.getUserId());
            }
            Count++;
            
            userActiveMap.put(p.getUserId(), Count);
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
            System.out.println("User ID: "+rankList.get(i).getKey() + " Top5 InactiveUsers Overall Counts: "+ rankList.get(i).getValue());
        }
    }
    
    public void getTop5ProactiveUsersOverall() {
        List<Comment> commentList = new ArrayList(DataStore.getInstance().getComments().values());
        List<Post> postList = new ArrayList(DataStore.getInstance().getPosts().values());
        List<User> userList = new ArrayList(DataStore.getInstance().getUsers().values());
         Map<Integer, Integer> userProActiveMap = new HashMap();
        for(User u: userList){
            userProActiveMap.put(u.getId(), 0);
        }
           for(Comment p: commentList){
            int Count = 0;
            if(userProActiveMap.containsKey(p.getUserId())){
                Count = userProActiveMap.get(p.getUserId());
            }
             Count++;
            Count = Count + p.getLikes();
            userProActiveMap.put(p.getUserId(), Count);
        }
           for(Post p: postList){
            int Count = 0;
            if(userProActiveMap.containsKey(p.getUserId())){
                Count = userProActiveMap.get(p.getUserId());
            }
            Count++;
            
            userProActiveMap.put(p.getUserId(), Count);
        }
        System.out.println(userProActiveMap);
        List<Map.Entry<Integer, Integer>> rankList = new ArrayList(userProActiveMap.entrySet());
        Collections.sort(rankList, new Comparator<Map.Entry<Integer, Integer>>(){

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
            
        });
        for(int i = 0; i < 5; i++){
            System.out.println("User ID: "+rankList.get(i).getKey() + " Top5 ProActiveUsers Overall Counts: "+ rankList.get(i).getValue());
        
        }
}
}