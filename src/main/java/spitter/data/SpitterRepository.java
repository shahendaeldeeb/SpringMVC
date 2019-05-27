package spitter.data;

import spitter.model.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
