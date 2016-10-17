package com.nathan.leetcode.medium;

/**
 * Created by Nathan on 8/8/16.
 */

import java.util.*;



class Tweet {
    public int id;
    public int user_id;
    public String text;

    public static Tweet create(int user_id, String tweet_text) {

        Tweet tweet = new Tweet();
        tweet.id = MiniTwitter.index++;
        tweet.user_id = user_id;
        tweet.text = tweet_text;
        return tweet;
    }

    @Override
    public String toString() {
        return this.text;
    }
}


public class MiniTwitter {
    public static void main(String[] args) {
        MiniTwitter miniTwitter = new MiniTwitter();
        System.out.println(miniTwitter.postTweet(1, "LintCode is Good!!!"));
        System.out.println(miniTwitter.getNewsFeed(1));
        System.out.println(miniTwitter.getTimeline(1));
        miniTwitter.follow(2, 1);
        System.out.println(miniTwitter.postTweet(1, "LintCode is Best!!!"));
        System.out.println(miniTwitter.getNewsFeed(2));
        miniTwitter.unfollow(2, 1);
        System.out.println(miniTwitter.getNewsFeed(2));


    }

    public static int index = 0;


    private Comparator<Tweet> comparator;

    private Map<Integer, Queue<Tweet>> newsFeed;
    private Map<Integer, List<Tweet>> timeline;
    private Map<Integer, List<Integer>> friendship;

    public MiniTwitter() {
        // initialize your data structure here.
        newsFeed = new HashMap<>();
        timeline = new HashMap<>();
        friendship = new HashMap<>();
        comparator = new Comparator<Tweet>() {
            public int compare(Tweet o1, Tweet o2) {
                return o2.id - o1.id;
            }
        };
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here

        Tweet tweet = Tweet.create(user_id, tweet_text);

        addToTimeline(user_id, tweet);
        addToNewsFeed(user_id, tweet);


        fanout(user_id, tweet);

        return tweet;

    }

    public void addToTimeline(int user_id, Tweet tweet) {
        if (!timeline.containsKey(user_id)) {
            List<Tweet> tweets = new ArrayList<>();
            tweets.add(tweet);
            timeline.put(user_id, tweets);
        } else {
            timeline.get(user_id).add(0, tweet);
        }
    }

    public void addToNewsFeed(int user_id, Tweet tweet) {
        if (!newsFeed.containsKey(user_id)) {
            Queue<Tweet> tweets = new PriorityQueue<>(1, comparator);
            tweets.offer(tweet);
            newsFeed.put(user_id, tweets);
        } else {
            newsFeed.get(user_id).offer(tweet);
        }
    }


    public void fanout(int user_id, Tweet tweet) {
        if (!friendship.containsKey(user_id)) return;
        List<Integer> friends = friendship.get(user_id);

        for (Integer friend : friends) {
            if (newsFeed.containsKey(friend)) {
                newsFeed.get(friend).offer(tweet);
            } else {
                Queue<Tweet> tweets = new PriorityQueue<>(1, comparator);
                tweets.offer(tweet);
                newsFeed.put(friend, tweets);
            }
        }
        return;
    }

    public void fanoutToSpecificFriend(int user_id, Tweet tweet) {
        if (newsFeed.containsKey(user_id)) {
            newsFeed.get(user_id).offer(tweet);
        } else {
            Queue<Tweet> tweets = new PriorityQueue<>(1, comparator);
            tweets.offer(tweet);
            newsFeed.put(user_id, tweets);
        }
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        List<Tweet> result = new ArrayList<>();
        Queue<Tweet> tweets = newsFeed.get(user_id);
        Queue<Tweet> temp = new LinkedList<>();
        for (int i = 0; i < 10 && !tweets.isEmpty(); i++) {
            temp.offer(tweets.peek());
            result.add(tweets.poll());
        }

        while (!temp.isEmpty()) {
            tweets.add(temp.poll());
        }
        return result;


    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet> getTimeline(int user_id) {
        // Write your code here
        List<Tweet> result = new ArrayList<>();
        List<Tweet> tweets = timeline.get(user_id);
        for (int i = 0; i < tweets.size() && i < 10; i++) {
            result.add(tweets.get(i));
        }
        return result;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!friendship.containsKey(to_user_id)) {
            List<Integer> list = new ArrayList<>();
            list.add(from_user_id);
            friendship.put(to_user_id, list);
        } else {
            friendship.get(to_user_id).add(from_user_id);
        }

        if (timeline.containsKey(to_user_id)) {

            for (Tweet tweet : timeline.get(to_user_id)) {
                fanoutToSpecificFriend(from_user_id, tweet);
            }
        }


    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!friendship.containsKey(to_user_id)) {
            return;
        } else {
            friendship.get(to_user_id).remove(new Integer(from_user_id));
        }

        List<Tweet> deletes = new ArrayList<>();
        for (Tweet tweet : newsFeed.get(from_user_id)) {
            if (tweet.user_id == to_user_id) {
                deletes.add(tweet);
            }
        }
        for (Tweet tweet : deletes) {
            newsFeed.get(from_user_id).remove(tweet);
        }

        return;

    }
}
