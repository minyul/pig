package me.minyul.dto.repository;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NewsDto {

    private String topic;
    private String title;
    private String media;
    private Long updateTime;

    @Builder
    public NewsDto(
            String topic,
            String title,
            String media,
            Long updateTime
    ) {
        this.topic = topic;
        this.title = title;
        this.media = media;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("topic", topic)
                .add("title", title)
                .add("media", media)
                .add("updateTime", updateTime)
                .toString();
    }
}
