package in.tejas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import in.tejas.constants.AppConstant;
import in.tejas.model.Order;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@KafkaListener(topics = AppConstant.TOPIC, groupId = AppConstant.GROUP_ID)
	public void msgListener(Order order) {
		System.out.println("***MSG Received from Kafka***");
		System.err.println(order);
	}

}
