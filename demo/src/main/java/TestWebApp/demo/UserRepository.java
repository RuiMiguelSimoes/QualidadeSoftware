package TestWebApp.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ModelUser , Long> {
}