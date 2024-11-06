package de.FitnessTracking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import de.FitnessTracking.Exception.CustomRestExceptionHandler;
import de.FitnessTracking.Model.User;
import de.FitnessTracking.Repository.UserRepository;

@RestController // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
@CrossOrigin(origins = "http://localhost:4200") 
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	 @Autowired
	 PasswordEncoder passwordEncoder;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@PostMapping(path="/add") // Map ONLY POST Request
	public ResponseEntity<Object> addNewUser (@RequestBody User user, WebRequest webRequest){
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request       
		
		if(user.getEmail().equalsIgnoreCase("")) {
			user.setEmail(null);
			return new CustomRestExceptionHandler().handleNullPointerException(new Exception("The mail is null"), webRequest);
		}
		
		if (userRepository.findByEmail(user.getEmail()) != null) {
        	return new CustomRestExceptionHandler().handleDataIntegrityViolation(new Exception("The mail exist"), webRequest);
        }
        
		if(user.getName().equalsIgnoreCase("")) {
			user.setName(null);
			return new CustomRestExceptionHandler().handleNullPointerException(new Exception("The name is null"), webRequest);
		}
		if(user.getPassword().equalsIgnoreCase("")) {
			user.setPassword(null);
			return new CustomRestExceptionHandler().handleNullPointerException(new Exception("The password is null"), webRequest);
		}
		
		User userNew = new User();
		user.setId(userNew.getId());
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	 }
	
	@PostMapping(path="/login")
	public ResponseEntity<Object> login (@RequestBody User user, WebRequest webRequest){

		

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	
	
}
