package lv.javaguru.java3.core.commands.producers;

import lv.javaguru.java3.core.commands.DomainCommand;

public class UpdateProducerCommand implements DomainCommand<UpdateProducerResult> {

    private Long producerId;

    private String name;
    private String url;


    public UpdateProducerCommand(Long producerId,
                                 String name,
                                 String url) {
        this.producerId = producerId;
        this.name = name;
        this.url = url;
    }

    public Long getProducerId() {
        return producerId;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}
