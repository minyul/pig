package me.pig.minyul.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {

    private Integer index;
    // Todo : 추후에 더 들어올 수 있음

    public void setIndex(Integer index) {
        this.index = index;
    }
}
