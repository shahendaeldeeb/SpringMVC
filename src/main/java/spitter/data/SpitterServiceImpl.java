package spitter.data;

import org.springframework.stereotype.Service;
import spitter.model.Spitter;

@Service("spitterServiceImpl")
public class SpitterServiceImpl {
    public Spitter findByUsername(final String username) {
        //todo: connect to database
        //return spitterRepository.findByUsername(username);
        return null;
    }

    public Spitter save(Spitter spitter) {
        //todo: connect to database
        //return spitterRepository.save(spitter);
        return null;

    }
}
