package de.FitnessTracking.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.FitnessTracking.Model.User;

@RestController
public class LoginController {

/*	private final AuthenticationManager authenticationManager;

	public LoginController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/login")
	public ResponseEntity<Authentication> login(@RequestBody User user) {
		Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(user.getEmail(), user.getPassword());
		Authentication authenticationResponse =
			this.authenticationManager.authenticate(authenticationRequest);
		// ...
		
		return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
	}

	public record LoginRequest(String username, String password) {
	}
*/
}
