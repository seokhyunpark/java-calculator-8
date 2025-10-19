package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService service;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(CalculatorService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.writeResult(service.calculate(inputView.read()));
    }
}
