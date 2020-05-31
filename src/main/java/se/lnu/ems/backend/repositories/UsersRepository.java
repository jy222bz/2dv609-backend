package se.lnu.ems.backend.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import se.lnu.ems.backend.models.User;

import java.util.List;

/**
 * An interface for the Users Repository.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
public interface UsersRepository extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     */
    @Query(value = "SELECT * FROM users WHERE email = ?1 limit 1", nativeQuery = true)
    User findByEmail(String email);


    /**
     * Find available students list.
     *
     * @param examId the exam id
     * @return the list
     */
    @Query(value = "SELECT * FROM users WHERE (role_id = 3) and id not in (select user_id from exam_students where exam_id = ?1)", nativeQuery = true)
    List<User> findAvailableStudents(Long examId);
}
