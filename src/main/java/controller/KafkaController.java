package controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.bruno.kafkaConsumer.entity.KafkaMessage;
import com.dev.bruno.kafkaConsumer.producer.MyKafkaProducer;
import com.dev.bruno.kafkaConsumer.repository.MessageRepository;

@RestController
public class KafkaController {
	
	@Autowired
	private MyKafkaProducer producer;
	
	@Autowired
	private MessageRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/message")
	public String sendMessage(@PathParam("message") String message) {
		
		producer.sendMessage(message);
		
		return "Enviado mensagem: " + message;
		
	}
	
	@GetMapping(path = "/list")
	public List<KafkaMessage> listMessages(){
		
		List<KafkaMessage> lista = repository.findAll();
		
		return lista;
	}
	
	

}
