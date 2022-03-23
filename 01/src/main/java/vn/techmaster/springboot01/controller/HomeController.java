package vn.techmaster.springboot01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.springboot01.model.Student;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/random")
    @ResponseBody
    public String getRandom8Character() {
        char[] arrCharacter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z' };
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrCharacter.length; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt((arrCharacter.length - 1) + 1 - 0);
            stringBuilder.append(arrCharacter[randomNumber]);
        }
        return stringBuilder + "";
    }
    
    @PostMapping("/bmi")
    @ResponseBody
    public Double bmi(@RequestParam Double weight, @RequestParam Double height) {
        return weight / (height * height);
    }
    ArrayList<Student> listStudent = new ArrayList<Student>() {{
        listStudent.add(new Student(01,"Tran Van Tam", 26));
        listStudent.add(new Student(02,"Tran Van Hung", 27));
    }};
    @GetMapping("/listStudent")
    @ResponseBody
    public List<Student>  getStudentList(){
        return listStudent;
    }
    @PostMapping("/addStudent")
    @ResponseBody
    public Student addStudent(@RequestBody Student student){
        listStudent.add(student);
        return student;
    }

}
