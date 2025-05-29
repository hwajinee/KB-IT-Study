package ch17.prac01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GiftItem {
    private String name;
    private String category;
    private int price;
    private int preferenceScore; // 선호도 (1~100)
    private boolean forMom;
    private boolean forDad;
}
