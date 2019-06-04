package ua.su.service;

import ua.su.domain.Clinic;

import java.util.List;

public interface ClinicService {
    List<Clinic> findAll();

    Clinic getEntry(Long id);

    void delete(Long id);

    Clinic addEntry(Clinic clinic);

    Clinic update(Long id, Clinic clinic);

    List<Clinic> findByCriteria();


//    getEntry(id) - доставать 1 сущность, учитываем что если надо достать и дочерние сущности надо делать отдельный запрос через репозиторий “дай мне все сущности у которых parent_id такой-то”
//    findAll() - выбирать все сущности
//    delete(id) - удалять сущность по id
//    addEntry([parentId], Entry ) - добавлять сущность.
//    Есть нюанс что при добавлении родительской сущности вначале добавляется чисто родитель а уже дочерние сущности добавляться по очереди используя полученный ключ
//    Update(Entry) обновляет сущность
//    Учитывается что при обновлении родительской сущности, дочерние старые сущности удаляются, а новые появляются.
//    Также добавить еще 1 метод который будет производить поиск по критерию.


}
