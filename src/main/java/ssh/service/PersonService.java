package ssh.service;

import ssh.dao.PersonDAO;
import ssh.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service 用于标注业务层组件
@Service
public class PersonService {

    @Autowired private PersonDAO personDAO; //使用Autowired进行自动装配，而无需get/set方法
    public List<Person> getPersons(){
        return personDAO.getPersons();
    }

    public Person getPersonByid(String id){
        return personDAO.getPersonById(id);
    }
    public void addPerson(Person person){

        personDAO.addPerson(person);
    }

    public void updatePerson(Person person){

        personDAO.updatePerson(person);

    }
    public void deletePersonById(String id){
        personDAO.deletePersonById(id);
    }
}
