package vn.techmaster.job.controller;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.job.dto.JobRequest;
import vn.techmaster.job.model.Job;

@RestController
@RequestMapping("/")
public class JobController {
  private ConcurrentHashMap<String, Job> listJob;

  public JobController() {

    listJob = new ConcurrentHashMap<>();
    listJob.put("1", new Job("10", "Sale", "Payment", "Ha Noi", 20, 40, "person10@gmail.com"));
    listJob.put("2", new Job("11", "IT", "BackEnd", "Hai Phong", 10, 50, "person11@gmail.com"));
    listJob.put("3", new Job("12", "Maketing", "QC", "Da Nang", 15, 20, "person12@gmail.com"));
    listJob.put("4", new Job("13", "Design", "Photoshop", "Ho Chi Minh", 10, 20, "person13@gmail.com"));
  }

  @GetMapping
  public List<Job> getJob() {
    return listJob.values().stream().toList();
  }

  @PostMapping(value = "/add")
  public Job createNewBook(@RequestBody JobRequest jobRequest) {
    String id = UUID.randomUUID().toString();
    Job newJob = new Job(id, jobRequest.title(), jobRequest.description(), jobRequest.location(),
        jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.description());
    listJob.put(id, newJob);
    return newJob;
  }

  @GetMapping(value = "/get/{id}")
  public Job getBookById(@PathVariable("id") String id) {
    return listJob.get(id);
  }

  @PutMapping(value = "/update/{id}")
  public Job updateJobById(@PathVariable("id") String id, @RequestBody JobRequest jobRequest) {
    Job updateJob = new Job(id, jobRequest.title(), jobRequest.description(), jobRequest.location(),
        jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.description());
    listJob.replace(id, updateJob);
    return updateJob;
  }

  @DeleteMapping(value = "/delete/{id}")
  public Job deleteJobyId(@PathVariable("id") String id) {
    Job removedJob = listJob.remove(id);
    return removedJob;
  }
  @GetMapping("/job/sortbylocation")
  public List<Job> sortByLocation() {
    return listJob.values().stream().sorted((o1, o2) -> o1.getLocation().compareTo(o2.getLocation()))
        .collect(Collectors.toList());

  }
  @GetMapping("/job/searchSalary/{salary}")
  public List<Job> searchSalary(@PathVariable("salary") int salary) {
    return listJob.values().stream().filter(job -> (job.getMin_salary() <= salary) && job.getMax_salary() >= salary)
        .collect(Collectors.toList());
  }
}
