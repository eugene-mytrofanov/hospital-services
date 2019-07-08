package ua.su.repository.base;

import java.util.List;

public interface ChildRepository <PID, ENTITY> {
    ENTITY insert(PID pid, ENTITY entity);
    void deleteByClinicId(PID pid);
    List<ENTITY> getAllByClinicId(PID pid);
}
