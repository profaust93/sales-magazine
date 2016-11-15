package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.commands.DomainCommand;

public class CreateProducerCommand implements DomainCommand<CreateProducerResult> {

    private String name;
    private String url;


    public CreateProducerCommand(String name,
                                 String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}
