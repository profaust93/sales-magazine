package lv.javaguru.java3.jms.controller.webgui;

import lv.javaguru.java3.dto.ProductDTO;
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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Daniels on 06.02.2017.
 */
@Controller
public class ProductController {

    private final Logger logger = Logger.getLogger(this.getClass());

    @ModelAttribute("page")
    public String page() {
        return "products";
    }

    @Autowired
    RabbitTemplate template;

    @Autowired
    MessageReceiver receiver;

    @Autowired
    MessageSender sender;

    @Resource(name = "receivedMessages")
    ConcurrentHashMap<String, Object> receivedMessages;

    @RequestMapping(value = {"/", Views.PRODUCTS_LIST, Views.PRODUCTS}, method = RequestMethod.GET)
    public String viewDevices(Model model) {
        List<ProductDTO> list = new ArrayList<>();

        // List emulator BEGIN
        for (int i = 0; i < 20; i++) {
            String id = sender.sendMsg(Integer.toString(i), SalesClassifier.PRODUCT, ServiceType.GET_ALL);
            ProductDTO answer = (ProductDTO) receiver.receiveMessage(id);
            list.add(answer);
        }
        // List emulator END

        model.addAttribute("products", list);
        model.addAttribute("recordCount", list.size());
        return Views.PRODUCTS_LIST;
    }

    @RequestMapping(value = Views.PRODUCTS + "/{id}", method = RequestMethod.GET)
    public String showProduct(@PathVariable("id") String productId,
                             Model model) {

        String id = sender.sendMsg(productId, SalesClassifier.PRODUCT, ServiceType.GET);
        ProductDTO answer = (ProductDTO) receiver.receiveMessage(id);
        model.addAttribute("product", answer);
        return Views.PRODUCTS_VIEW;
    }

}
