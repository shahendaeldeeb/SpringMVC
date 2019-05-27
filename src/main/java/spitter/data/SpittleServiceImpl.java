package spitter.data;

import org.springframework.stereotype.Service;
import spitter.model.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("spittleServiceImpl")
public class SpittleServiceImpl implements SpittleRepository {
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittleList = new ArrayList<Spittle>();
        Spittle s = new Spittle("hello first spitter", new Date());
        Spittle s2 = new Spittle("hello second spitter", new Date());
        spittleList.add(s);
        spittleList.add(s2);
        return spittleList;
    }

    public Spittle findOne(long spittleId) {
        Spittle s2 = new Spittle("hello second spitter", new Date());
        return s2;
    }

    public void save(Spittle spittle) {
    }

    public List<Spittle> findRecentSpittles() {
        List<Spittle> spittleList = new ArrayList<Spittle>();
        return spittleList;
    }

}

