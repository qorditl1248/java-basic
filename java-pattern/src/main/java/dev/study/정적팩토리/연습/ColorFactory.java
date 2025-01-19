package dev.study.정적팩토리.연습;

import java.util.HashMap;
import java.util.Map;

/**
 *  요구사항
 * 	•	자주 사용되는 Color 객체를 관리하는 ColorFactory 클래스를 구현하세요.
 * 	•	동일한 색상 이름에 대해 새로운 객체를 생성하지 않고 기존 객체를 반환하세요.
 * 	•	색상 이름을 String으로 받고, 이에 해당하는 Color 객체를 반환하는 getColor(String name) 메서드를 구현하세요.
 */


public class ColorFactory {
    private static final Map<String, ColorFactory> colors = new HashMap<>();
    private final String colorName;

    private ColorFactory(String colorName) {
        this.colorName = colorName;
    }

    public static ColorFactory getInstance(String colorName) {
        return colors.computeIfAbsent(colorName, ColorFactory::new);
    }

    @Override
    public String toString() {
        return "ColorFactory{" +
                "colorName='" + colorName + '\'' +
                '}';
    }
}
