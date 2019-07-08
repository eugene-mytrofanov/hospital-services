package ua.su.repository.base;

public interface ParentRepository <ENTITY> {
    ENTITY insert(ENTITY clinic);
}
