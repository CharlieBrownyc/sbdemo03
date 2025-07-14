package kr.co.brownyc.complete.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NameGenerator {
    private static final List<String> firstNames = Arrays.asList(
            "김", "이", "박", "최", "정", "강", "조", "윤", "장", "임",
            "한", "오", "서", "신", "권", "황", "안", "송", "전", "홍",
            "고", "문", "손", "양", "배", "조", "백", "허", "유", "남"
    );

    private static final List<String> lastNames = Arrays.asList(
            "가영", "나연", "다은", "라희", "마린", "바다", "사라", "아라", "자현", "차연",
            "카이", "타니", "파란", "하늘", "가람", "나래", "다솜", "라온", "마루", "바람",
            "세현", "아람", "지현", "채원", "하린", "가은", "나현", "다솔", "라엘", "민지"
    );


    public static String generateName() {
        Random random = new Random();
        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String lastName = lastNames.get(random.nextInt(lastNames.size()));
        return firstName + " " + lastName;
    }

}
