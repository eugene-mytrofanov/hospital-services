package ua.su.domain;

abstract class ID {
    protected Long id;

    ID() {

    }

    ID(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
