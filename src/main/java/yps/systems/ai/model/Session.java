package yps.systems.ai.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.UUID;


@RedisHash("session")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    @Id
    @Indexed
    private String id;
    private String personElementId;
    private String jwt;

    public Session(String personElementId, String jwt) {
        this(UUID.randomUUID().toString(), personElementId, jwt);
    }

}
