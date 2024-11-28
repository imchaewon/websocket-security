package example.websocketsecurity.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

	@MessageMapping("/notify") // 클라이언트가 "/app/notify"로 보낸 메시지를 처리
	@SendTo("/topic/alerts")   // 구독자들에게 "/topic/alerts"로 메시지 전송
	public String sendNotification(String message) {
		return "알림: " + message;
	}
}