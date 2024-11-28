package example.websocketsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// 클라이언트가 메시지를 구독할 때 사용하는 prefix
		config.enableSimpleBroker("/topic");
		// 클라이언트가 메시지를 보낼 때 사용하는 prefix
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// STOMP WebSocket 연결 엔드포인트 설정
		registry.addEndpoint("/ws")
//			.setAllowedOrigins("*") // 모든 Origin 허용
//			.setAllowedOrigins("http://localhost:8080", "http://127.0.0.1:5500") // 클라이언트 도메인
			.setAllowedOrigins("http://localhost:5500")
			.withSockJS(); // SockJS 사용 가능
	}
}