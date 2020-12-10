package subway.enums;

import java.util.Arrays;

public enum StationInput {
    register("1", "역 등록"),
    remove("2", "역 삭제"),
    inquiry("3", "역 조회"),
    back("B", "돌아가기");

    final private String inputValue;
    final private String feature;


    private StationInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    public String getMessage() {
        return inputValue + ". " + feature;
    }

    public static String validateInput(String stationViewInput) {
        return Arrays.stream(StationInput.values())
                .filter(x -> x.inputValue.equals(stationViewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .inputValue;
    }
}
