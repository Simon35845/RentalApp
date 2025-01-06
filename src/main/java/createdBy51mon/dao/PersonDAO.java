package createdBy51mon.dao;

import createdBy51mon.entity.PersonEntity;
import createdBy51mon.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonDAO {
    // Метод получения всех пользователей с сортировкой
    public List<PersonEntity> getAll(String sortField, boolean ascending) {
        EntityManager em = HibernateUtil.getEntityManager(); // Получаем EntityManager для работы с базой данных
        List<PersonEntity> persons;

        try {
            String jpql = "SELECT p FROM PersonEntity p"; // JPQL запрос для получения всех пользователей
            if (sortField != null && !sortField.isEmpty()) {  //если запрос не пустой
                jpql += " ORDER BY " + sortField + (ascending ? " ASC" : " DESC");
//                jpql += " ORDER BY p." + sortField + (ascending ? " ASC" : " DESC");
            }

            TypedQuery<PersonEntity> query = em.createQuery(jpql, PersonEntity.class);
            persons = query.getResultList(); // Выполняем запрос и получаем результаты
        } finally {
            em.close();
        }
        return persons; // Возвращаем список лиц
    }

    // Метод поиска пользователей по имени и фамилии
    public List<PersonEntity> search(String searchQuery) {
        // Получаем EntityManager для работы с базой данных
        EntityManager em = HibernateUtil.getEntityManager();
        List<PersonEntity> persons;

        try {
            String jpql = "SELECT p FROM PersonEntity p WHERE p.name LIKE :search OR p.surname LIKE :search OR p.patronymic LIKE :search"; // JPQL запрос для поиска по имени или фамилии
            TypedQuery<PersonEntity> query = em.createQuery(jpql, PersonEntity.class);
            query.setParameter("search", "%" + searchQuery + "%"); // Установка параметра для поиска

            persons = query.getResultList(); // Выполняем запрос и получаем результаты
        } finally {
            em.close();
        }
        return persons; // Возвращаем список лиц
    }
}
