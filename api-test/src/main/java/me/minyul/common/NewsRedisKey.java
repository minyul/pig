package me.minyul.common;

public class NewsRedisKey {
    /**
     * topic 에 따른 뉴스 Key
     *
     * @date 2023-03-12
     * @author min yul
     */
    public static String PIG_TOPIC_NEWS = "pig:news:%s";

    public static String getNewsKey(final String topic) {
        return String.format(PIG_TOPIC_NEWS, topic);
    }
}
