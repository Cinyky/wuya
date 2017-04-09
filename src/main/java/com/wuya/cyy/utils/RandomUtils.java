package com.wuya.cyy.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.wuya.cyy.pojo.Topic;

public class RandomUtils {
	 public static List<Topic> randomRecommendTopics(List<Topic> topics){
		 Set<Topic> tmpTopics = new HashSet<>(); 
		 int size = topics.size();
		 if(topics!=null && !topics.isEmpty() && size>4){
			 while(tmpTopics.size()<4){
				 int index = new Random().nextInt(size);
				 tmpTopics.add(topics.get(index));
			 }
				 
		 }
		 Iterator<Topic> iterator = tmpTopics.iterator();
		 List<Topic> retTopics =  new ArrayList<>();
		 while(iterator.hasNext()){
			 retTopics.add(iterator.next());
		 }
		 return retTopics;
		 
	 }
	 
	 public static void main(String[] args) {
		 Random random = new Random();
		 for(int i =0 ;i<30;i++){
			 int index = random.nextInt(3);
			 System.out.println(index);
		 }
	}
}
