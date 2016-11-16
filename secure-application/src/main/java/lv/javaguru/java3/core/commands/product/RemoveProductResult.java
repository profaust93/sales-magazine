package lv.javaguru.java3.core.commands.product;


import lv.javaguru.java3.core.commands.DomainCommandResult;

public class RemoveProductResult implements DomainCommandResult {

    private String message;

    public RemoveProductResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
