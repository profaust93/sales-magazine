package lv.javaguru.java3.core.commands.producers;


import lv.javaguru.java3.core.commands.DomainCommandResult;

public class RemoveProducerResult implements DomainCommandResult {

    private String message;

    public RemoveProducerResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
