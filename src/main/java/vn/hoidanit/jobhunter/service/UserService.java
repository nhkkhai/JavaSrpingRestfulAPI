package vn.hoidanit.jobhunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> fetchAllUser() {
        return this.userRepository.findAll();
    }

    public User fetchUserByID(long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public User handleUpdateUser(User user) {
        User curUser = this.fetchUserByID(user.getId());
        if (curUser != null) {
            curUser.setName(user.getName());
            curUser.setPassword(user.getPassword());
            curUser.setEmail(user.getEmail());
            // update
            curUser = this.userRepository.save(curUser);
        }
        return curUser;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }
}
