package org.top.springplanexample.service.useraction;

import org.springframework.stereotype.Service;
import org.top.springplanexample.datamodel.entity.UserActionJournal;
import org.top.springplanexample.datamodel.repository.UserActionRepository;

import java.time.LocalDateTime;

@Service
public class UserActionService {
    private final UserActionRepository repo;

    public UserActionService(UserActionRepository repo) {
        this.repo = repo;
    }

    public void LogUserAction(String user, String action) {
        UserActionJournal userAction = new UserActionJournal();
        userAction.setUser(user);
        userAction.setAction(action);
        userAction.setDate(LocalDateTime.now());
        repo.save(userAction);
    }
}
