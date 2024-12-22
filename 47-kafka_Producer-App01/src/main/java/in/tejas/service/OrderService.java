package in.tejas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.tejas.constants.AppConstant;
import in.tejas.model.Order;

@Service
public class OrderService {

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;

	public String addMsg(Order order) {

		// publish msg to kafka topic
		kafkaTemplate.send(AppConstant.TOPIC, order);

		return "Msg Published To Kafka Topic";
	}
}

