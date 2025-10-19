package calculator.service;

public class CalculatorService {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public int calculate(String input) {
        String delimiter = extractDelimiter(input);
        String numbers = extractNumbers(input);
        return sum(numbers, delimiter);
    }

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

    private int sum(String numbers, String delimiter) {
        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                sum += parseAndValidate(token.trim());
            }
        }
        return sum;
    }

    private int parseAndValidate(String token) {
        try {
            int number = Integer.parseInt(token);
            validatePositive(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
