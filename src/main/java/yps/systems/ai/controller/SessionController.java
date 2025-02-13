package yps.systems.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yps.systems.ai.model.Session;
import yps.systems.ai.repository.ISessionRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sessionService")
public class SessionController {

    private final ISessionRepository sessionRepository;

    @Autowired
    public SessionController(ISessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @GetMapping
    List<Session> getSessions() {
        return (List<Session>) sessionRepository.findAll();
    }

    @GetMapping("/{id}")
    Session getSession(@PathVariable String id) {
        return sessionRepository.findById(UUID.fromString(id)).orElse(new Session());
    }

    @PostMapping
    Session createSession(@RequestBody Session session) {
        return sessionRepository.save(session);
    }

    @DeleteMapping("/{id}")
    void deleteSession(@PathVariable String id) {
        sessionRepository.deleteById(UUID.fromString(id));
    }

}
