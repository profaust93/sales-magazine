package lv.javaguru.java3.jms.controller.webgui;

import lv.javaguru.java3.dto.ProducerDTO;
import lv.javaguru.java3.dto.SalesClassifier;
import lv.javaguru.java3.dto.ServiceType;
import lv.javaguru.java3.jms.constants.Views;
import lv.javaguru.java3.jms.services.MessageReceiver;
import lv.javaguru.java3.jms.services.MessageSender;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Daniels on 07.02.2017.
 */
@Controller
public class ProducerController {

    private final Logger logger = Logger.getLogger(this.getClass());

    @ModelAttribute("page")
    public String page() {
        return "producers";
    }

    @Autowired
    RabbitTemplate template;

    @Autowired
    MessageReceiver receiver;

    @Autowired
    MessageSender sender;

    @Resource(name = "receivedMessages")
    ConcurrentHashMap<String, Object> receivedMessages;

    @RequestMapping(value = {Views.PRODUCERS_LIST, Views.PRODUCERS}, method = RequestMethod.GET)
    public String viewDevices(Model model) {
        String id = sender.sendMsg("", SalesClassifier.PRODUCER, ServiceType.GET_ALL);
        List<ProducerDTO> producerDTOList = (List<ProducerDTO>) receiver.receiveMessage(id);

        model.addAttribute("producers", producerDTOList);
        model.addAttribute("recordCount", producerDTOList.size());
        return Views.PRODUCERS_LIST;
    }

    @RequestMapping(value = Views.PRODUCERS + "/{id}", method = RequestMethod.GET)
    public String showProducer(@PathVariable("id") String producerId,
                             Model model) {

        String id = sender.sendMsg(producerId, SalesClassifier.PRODUCER, ServiceType.GET);
        ProducerDTO answer = (ProducerDTO) receiver.receiveMessage(id);
        model.addAttribute("producer", answer);
        return Views.PRODUCERS_VIEW;
    }

}
