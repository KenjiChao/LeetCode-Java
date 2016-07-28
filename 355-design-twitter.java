public class Twitter {

    private class Tweet {
        int time;
        int tweetId;
        public Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    int currentTime = 0;
    HashMap<Integer, List<Tweet>> tweetMap;  // (userId, tweetList)
    HashMap<Integer, Set<Integer>> followeeMap;  // (userId, followeeSet)

    /** Initialize your data structure here. */
    public Twitter() {
        tweetMap = new HashMap<>();
        followeeMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(currentTime++, tweetId);
        if (tweetMap.containsKey(userId)) {
            tweetMap.get(userId).add(0, tweet);
        } else {
            List<Tweet> list = new ArrayList<>();
            list.add(tweet);
            tweetMap.put(userId, list);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // Treat this problem as merging k sorted lists
        List<Integer> idList = new ArrayList<>();
        Set<Integer> followeeSet = followeeMap.get(userId);
        // k sorted tweet list
        List<List<Tweet>> listOfTweetList = new ArrayList<>();
        // add tweet list of current user
        if (tweetMap.containsKey(userId)) {
            listOfTweetList.add(tweetMap.get(userId));
        }

        // add tweet list of followed users
        if (followeeMap.containsKey(userId)) {
            for (Integer followeeId : followeeSet) {
                if (tweetMap.containsKey(followeeId)) {
                    listOfTweetList.add(tweetMap.get(followeeId));
                }
            }
        }

        if (listOfTweetList.size() == 0) {
            return idList;
        }

        // tracking the index of each list
        int[] indices = new int[listOfTweetList.size()];
        for (int i = 0; i < 10; i++) {
            Tweet nextTweet = null;
            int nextId = 0;
            // choose the nextTweet which has the max id (means it is the newest one)
            for (int j = 0; j < listOfTweetList.size(); j++) {
                if (indices[j] < listOfTweetList.get(j).size()) {
                    if (nextTweet == null || listOfTweetList.get(j).get(indices[j]).time > nextTweet.time) {
                        nextTweet = listOfTweetList.get(j).get(indices[j]);
                        nextId = j;
                    }
                }
            }
            if (nextTweet == null) {
                break;
            } else {
                idList.add(nextTweet.tweetId);
                indices[nextId]++;
            }
        }
        return idList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (followeeMap.containsKey(followerId)) {
            followeeMap.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followeeMap.put(followerId, set);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (followeeMap.containsKey(followerId)) {
            Set<Integer> set = followeeMap.get(followerId);
            if (set.contains(followeeId)) {
                set.remove(followeeId);
                if (set.size() == 0) {
                    followeeMap.remove(followerId);
                }
            }
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
