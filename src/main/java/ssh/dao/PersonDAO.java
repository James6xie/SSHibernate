package ssh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ssh.entity.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

//@Repository用于标注数据访问组件，即DAO组件
@Repository
public class PersonDAO {

    @Resource private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
    private Session getSessioin(){
        return sessionFactory.getCurrentSession();
    }

    public List<Person> getPersons(){
        return this.getSessioin().createCriteria(Person.class).list();
    }

    public Person getPersonById(String id){
        return (Person) this.getSessioin().createQuery("from Person where id = ?").setParameter(0,id).uniqueResult();
    }

    public void addPerson(Person person){

        this.getSessioin().save(person);
    }

    public void updatePerson(Person person){

        this.getSessioin().update(person);
    }
    public void deletePersonById(String id){

        this.getSessioin().createQuery("delete Person where id =?").
                setParameter(0,id).executeUpdate();
    }
}
