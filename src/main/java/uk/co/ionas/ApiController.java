package uk.co.ionas;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@RequestMapping("/")
	public String hello(HttpServletRequest request ) {
		return "hello" + request.getContentLength();
	}
}
