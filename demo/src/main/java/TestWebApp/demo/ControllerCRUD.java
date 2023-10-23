package TestWebApp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class ControllerCRUD {

    @GetMapping("/hello")
    public String HelloWorld(){
        return "então gata? \ntudo Miau? 🐱";
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<ModelUser> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ModelUser getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public ModelUser createUser(@RequestBody ModelUser user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public ModelUser updateUser(@PathVariable Long id, @RequestBody ModelUser updatedUser) {
        ModelUser existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
