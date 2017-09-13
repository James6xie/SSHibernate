package ssh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssh.entity.Person;
import ssh.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

//@Controller 用于告诉服务器，这个类是SpringMVC中的控制层，这个类可以接收和处理用户请求
@Controller
//@ReuquestMapping用来处理请求地址映射，value指请求的实际地址。
// @ReuquestMapping用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired private PersonService personService;

    @RequestMapping(value = "/getPersons")
    @ResponseBody
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @RequestMapping(value = "/getPersons")
    @ResponseBody
    public Person getPersonById(String id){
        return personService.getPersonByid(id);
    }

    @RequestMapping(value = "/addPerson")
    @ResponseBody
    public void addPerson(Person person){
        personService.addPerson(person);
    }

    @RequestMapping(value = "/updatePerson")
    @ResponseBody
    public void updatePerson(Person person){

        personService.updatePerson(person);
    }

    @RequestMapping(value = "/deletePersonById")
    @ResponseBody
    public void deletePersonById(String id){
        personService.deletePersonById(id);
    }
}
