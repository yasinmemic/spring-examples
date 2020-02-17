package com.haydikodlayalim.producer;

import com.haydikodlayalim.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate; // connection nesnesi gibi dusunulebilir...

    @Value("${sr.rabbit.binding.name}")
    private String bindingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent! ID: " + notification.getId());
        rabbitTemplate.convertAndSend(exchangeName, bindingName, notification);
    }


    @PostConstruct
    public void init() {
        Notification notification = new Notification();
        notification.setId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("test message");
        notification.setSeen(Boolean.FALSE);
        sendToQueue(notification);
    }
}
