package lv.javaguru.java3.jms.controller;

import lv.javaguru.java3.jms.services.MessageReceiver;
import lv.javaguru.java3.jms.services.MessageSender;
import lv.javaguru.java3.jms.services.products.GetProductReceiver;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Controller
public class GetProductController {

    Logger logger = Logger.getLogger(GetProductController.class);

    @Autowired
    RabbitTemplate template;

    @Autowired
    @Qualifier("getProductReceiver")
    MessageReceiver receiver;

    @Autowired
    @Qualifier("getProductSender")
    MessageSender sender;

    @Resource(name = "receivedMessages")
    ConcurrentHashMap<String, Object> receivedMessages;

    @RequestMapping("/emit")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @GET
    @ResponseBody
    public DeferredResult<ResponseEntity<Object>> queue1(@RequestParam("text") String text) throws InterruptedException, ExecutionException, TimeoutException {
        DeferredResult response = new DeferredResult();
        String id = sender.sendMsg(text);
        String answer = (String) receiver.receiveMessage(id);
        System.out.println("ANSWER: " + answer);
        response.setResult(new ResponseEntity<>(answer, HttpStatus.OK));
        return response;
    }



}
