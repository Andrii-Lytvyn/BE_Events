package de.ait.timepad.repositories;

import de.ait.timepad.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {

    // TODO: убрать метод, как только подключим базы данных
    void clear();

}
