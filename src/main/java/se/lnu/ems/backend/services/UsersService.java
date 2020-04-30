package se.lnu.ems.backend.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.User;
import se.lnu.ems.backend.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> retrieve(Pageable pageable) {
        var list = new ArrayList<User>();
        usersRepository.findAll(pageable).forEach(list::add);
        return list;
    }

    public User create() {
        return null;
    }
}
