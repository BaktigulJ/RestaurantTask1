package restaurant.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import restaurant.model.JobAdvertisement;
import restaurant.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface JobAppRepository extends JpaRepository<JobAdvertisement, Long> {

    @Query("select j from JobAdvertisement j where j.id =:jobId")
    Optional<JobAdvertisement> findJobAppById(Long jobId);

    default JobAdvertisement getJobAppById(Long jobId){
        return findJobAppById(jobId).orElseThrow(() ->
                new NotFoundException("Not found"));
    }
    @Query("select j from JobAdvertisement j where j.restaurant.id =:restId")
    List<JobAdvertisement> findAll(Long restId);

    default Page<JobAdvertisement> findAllByRestaurantId(Long restId, Pageable pageable){
        List<JobAdvertisement> jobAdvertisements = findAll(restId);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), jobAdvertisements.size());
        return new PageImpl<>(jobAdvertisements.subList(start, end), pageable, jobAdvertisements.size());
    }
}