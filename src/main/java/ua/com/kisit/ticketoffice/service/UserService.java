package ua.com.kisit.ticketoffice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.kisit.ticketoffice.entity.Passengers;
import ua.com.kisit.ticketoffice.entity.Users;
import ua.com.kisit.ticketoffice.repository.PassengersRepository;
import ua.com.kisit.ticketoffice.repository.UsersRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final PassengersRepository passengersRepository;

    public boolean getLogicUser(String username){
        return (!usersRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("Not found!!");
        }

        return user;
    }

    public Passengers getPassengerById(Long id){
        return passengersRepository.findById(id).orElse(null);
    }


    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public void updateUser(String password, String username, Long id){
        usersRepository.updateUserById(password, username, id);
    }

    public void addNewRoleToUser(Long userId, Long roleId){
        usersRepository.updateRoleByUserId(userId, roleId);
    }

    public Long getUserIdByUsername(String username) {
        Users user = usersRepository.findByUsername(username);
        return (user != null) ? user.getId() : null;
    }

}
