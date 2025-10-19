package calculator.service;

public class CalculatorService {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private String extractDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int endIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
            if (endIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 입력 형식이 맞지 않습니다.");
            }
            String customDelimiter = input.substring(2, endIndex);
            return "[,:" + customDelimiter + "]";
        }
        return "[,:]";
    }

    private String extractNumbers(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
            return input.substring(delimiterIndex + CUSTOM_DELIMITER_SUFFIX.length());
        }
        return input;
    }

}
