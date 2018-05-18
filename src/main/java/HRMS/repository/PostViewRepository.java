package HRMS.repository;

import HRMS.view.PostView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostViewRepository extends JpaRepository<PostView,Long> {
}