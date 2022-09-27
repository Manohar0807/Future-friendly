package comcom.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	
	
	@Autowired
	private MessageSource messageSource;
	// Get method
	// URI-/hello-world
	// method-should return "Hello World"
	@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	public String helloworld() {
		return "Hello Manohar R Welcome......!";
	}

	// helloworld-Bean
	@GetMapping(path = "/helloworldBean")
	public HelloworldBean helloworldBean() {
		return new HelloworldBean("Hello Manohar R Welcome......!");
	}

	/// helloworld/path-variable/in28minutes
	@GetMapping(path = "/helloworld/path-variable/{name}")
	public HelloworldBean helloworldPathVariable(@PathVariable String name) {
		return new HelloworldBean(String.format("Hello Manohar R Welcome......!,%s", name));
	}
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternalized(/* @RequestHeader(name="Accept-Language",required = false)Locale locale */) {
		return messageSource.getMessage("Good.morning.message",null,LocaleContextHolder.getLocale());
	}
}
