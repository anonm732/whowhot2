package com.example.myapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TestModule {   // 여기에 모듈 구현하고, 잘 기능하면 클래스 이름 바꿔서 탑재하자
    private String[] keyword = {"입장", "클릭", "바랍니다"};
    private String[] typoURL = {"teiegram", };
    private String[] shortURL = {"bit.ly", };

    private String content, target;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // 정규 표현식: 공백, 한글, 알파벳, 숫자, 특수 문자를 기준으로 분리
    //Pattern pattern = Pattern.compile("\\s+|[가-힣a-zA-Z0-9\\s]");
    // 공백 기준
    Pattern pattern = Pattern.compile("\\s");
    Matcher matcher = pattern.matcher(content);
    ArrayList<String> extractedWords = new ArrayList<>();

    // 검사 하려는 문자열을 파싱하여 배열로 만드는 함수
    public void parseTargetString(String targetString) {
        // 문자열을 공백을 기준으로 추출하여 배열로 반환
        String[] targetWords = targetString.split("\\s+");

        // 추출된 단어들을 로그로 출력
        for (String word : targetWords) {
            Log.d("test", "** Parsed word: " + word);
        }
    }

    // 문자 메시지 내용을 파싱하여 배열로 저장하는 함수
    public String[] extractWords(String content) {
        int start = 0;

        // 정규 표현식과 매치되는 부분을 찾아 추출
        while (matcher.find()) {
            // 이전 매치 위치부터 현재 매치 위치까지의 문자열 추출
            String word = content.substring(start, matcher.start());
            if (!word.isEmpty()) {
                extractedWords.add(word); // 추출된 문자열을 리스트에 추가
            }
            start = matcher.end(); // 다음 매치 위치로 이동
        }

        // 마지막 매치 위치 이후의 문자열을 추출
        String lastWord = content.substring(start);
        if (!lastWord.isEmpty()) {
            extractedWords.add(lastWord); // 마지막으로 추출된 문자열을 리스트에 추가
        }

        // 리스트를 배열로 변환하여 반환
        return extractedWords.toArray(new String[extractedWords.size()]);
    }

    public void compareString(String[] extractedWords, String targetString) {
        boolean found = false;
        for (String word : extractedWords) {
            if (word.equals(targetString)) {
                Log.d("test", "** Target founded : " + targetString);
                found = true;
            }
        }
        if (!found) {
            Log.d("test", "** No matching value founded");
        }
    }

    public void specialKeywordDetect() {

    }
}
