package vn.techmaster.job.dto;

public record JobRequest(String id, String title, String description, String location, int min_salary, int max_salary,
        String email_to) {
}
