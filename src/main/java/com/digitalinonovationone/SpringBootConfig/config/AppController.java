package com.digitalinonovationone.SpringBootConfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@Value("${app.menssage}")
	private String appMessage;
	
	public void setAppMessage(String appMessage) {
		System.out.println(appMessage +""+"\n\n");
		this.appMessage = appMessage;
	}
	
	
	@GetMapping("/")
	public String getAppMessage() {
		
		return appMessage;
	}

}
