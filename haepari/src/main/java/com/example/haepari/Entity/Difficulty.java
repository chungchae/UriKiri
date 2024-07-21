package com.example.haepari.Entity;

import lombok.Data;

@Data
public class Difficulty {

    private int difficulty;
    private int distance;
    private String destination_address;
    private String store_address;
    private String keyWord;

    public Difficulty(String destination_address, String store_address, int distance, int difficulty, String keyWord) {
        this.destination_address = destination_address;
        this.store_address = store_address;
        this.distance = distance;
        this.difficulty = difficulty;
        this.keyWord = keyWord;
    }

    // Store와 Destination을 int로 매핑 (0~4)
    private static final String[] STORES = {
            "김치만",
            "스트렝스",
            "커피빈",
            "한솥",
            "바나프레소"
    };

    private static final String[] DESTINATIONS = {
            "신공학관",
            "명진관",
            "사과관",
            "학림관",
    };

    // 특정 store와 destination에 대한 Distance와 Difficulty 반환
    public static Difficulty getDifficulty(String storeAddress, String destinationAddress) {
        int distance = 0;
        int difficulty = 0;
        String keyWord ="";

        // 여기서 각 store와 destination에 대한 distance와 difficulty를 설정합니다.
        if (storeAddress.equals("김치만") && destinationAddress.equals("신공학관")) {
            distance = 319;
            difficulty = 0;
            keyWord = "엘레베이터,오르막길";
        } else if (storeAddress.equals("김치만") && destinationAddress.equals("명진관")) {
            distance = 415;
            difficulty = 0;
            keyWord = "엘레베이터,오르막길";
        } else if (storeAddress.equals("김치만") && destinationAddress.equals("사과관")) {
            distance = 741;
            difficulty = 2;
            keyWord="엘레베이터,오르막길";
        } else if (storeAddress.equals("김치만") && destinationAddress.equals("학림관")) {
            distance = 526;
            difficulty = 1;
            keyWord="엘레베이터,오르막길,계단";
        }else if (storeAddress.equals("스트렝스") && destinationAddress.equals("신공학관")) {
            distance = 282;
            difficulty = 0;
            keyWord = "엘레베이터,오르막길";
        }else if (storeAddress.equals("스트렝스") && destinationAddress.equals("명진관")) {
            distance = 378;
            difficulty = 1;
            keyWord = "엘레베이터,오르막길";
        }else if (storeAddress.equals("스트렝스") && destinationAddress.equals("사과관")) {
            distance = 703;
            difficulty = 1;
            keyWord = "엘레베이터,오르막길,내리막길,계단";
        }else if (storeAddress.equals("스트렝스") && destinationAddress.equals("학림관")) {
            distance = 545;
            difficulty = 1;
            keyWord ="내리막길,계단";
        }else if (storeAddress.equals("커피빈") && destinationAddress.equals("신공학관")) {
            distance = 983;
            difficulty = 2;
            keyWord = "엘레베이터";
        }else if (storeAddress.equals("커피빈") && destinationAddress.equals("명진관")) {
            distance = 877;
            difficulty = 2;
            keyWord = "엘레베이터,평지";
        }else if (storeAddress.equals("커피빈") && destinationAddress.equals("사과관")) {
            distance = 426;
            difficulty = 1;
            keyWord = "엘레베이터,내리막길";
        }else if (storeAddress.equals("커피빈") && destinationAddress.equals("학림관")) {
            distance = 845;
            difficulty = 2;
            keyWord = "엘레베이터,내리막길";
        }else if (storeAddress.equals("한솥") && destinationAddress.equals("신공학관")) {
            distance = 331;
            difficulty = 1;
            keyWord = "오르막길,계단";
        }else if (storeAddress.equals("한솥") && destinationAddress.equals("명진관")) {
            distance = 437;
            difficulty = 1;
            keyWord = "오르막길,계단,엘레베이터";
        }else if (storeAddress.equals("한솥") && destinationAddress.equals("사과관")) {
            distance = 674;
            difficulty = 1;
            keyWord = "오르막길,계단,내리막길";
        }else if (storeAddress.equals("한솥") && destinationAddress.equals("학림관")) {
            distance = 91;
            difficulty = 0;
            keyWord = "오르막길";
        }else if (storeAddress.equals("바나프레소") && destinationAddress.equals("신공학관")) {
            distance = 470;
            difficulty = 1;
            keyWord = "엘레베이터,평지";
        }else if (storeAddress.equals("바나프레소") && destinationAddress.equals("명진관")) {
            distance = 566;
            difficulty = 1;
            keyWord = "엘레베이터,계단";
        }else if (storeAddress.equals("바나프레소") && destinationAddress.equals("사과관")) {
            distance = 891;
            difficulty = 1;
            keyWord = "엘레베이터,오르막길,내리막길";
        }else if (storeAddress.equals("바나프레소") && destinationAddress.equals("학림관")) {
            distance = 456;
            difficulty = 1;
            keyWord = "오르막길";
        }


            return new Difficulty(destinationAddress, storeAddress, distance, difficulty,keyWord);
        }

}

