package com.example.hotelmanagement.repo;

import com.example.hotelmanagement.entity.Markup;
import com.example.hotelmanagement.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeasonRepo extends JpaRepository<Season, Integer> {

    @Query(value = "select * from season where season_id = ?1", nativeQuery = true)
    Season getSeasonById(String seasonId);

}
