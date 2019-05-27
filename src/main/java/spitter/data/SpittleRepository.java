package spitter.data;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import spitter.model.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findRecentSpittles();

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);

    void save(Spittle spittle);
}
