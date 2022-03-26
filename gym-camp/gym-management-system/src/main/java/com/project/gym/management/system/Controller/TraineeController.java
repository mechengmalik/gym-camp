package com.project.gym.management.system.Controller;

import com.project.gym.management.system.Models.Trainee;
import com.project.gym.management.system.Models.Trainer;
import com.project.gym.management.system.Repositories.SessionRepo;
import com.project.gym.management.system.Repositories.TraineeRepo;
import com.project.gym.management.system.Repositories.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/trainee")
public class TraineeController {
    @Autowired
    TraineeRepo traineeRepo;

    @Autowired
    SessionRepo sessionRepo;


    @GetMapping("")
    public String allTrainee(Model model){
        List<Trainee> trainee= (List<Trainee>) traineeRepo.findAll();
        model.addAttribute("trainee",trainee);

        return "allSession";
    }

    @GetMapping("/addTrainee/{id}")
    public String newTrainee(@PathVariable("id") int id, Model model) {

        model.addAttribute("trainee", traineeRepo.findById(id).get());
        return ("allSession");
    }

    @PostMapping("/addTrainee")
    public RedirectView addTrainee (Model model,
                                    @RequestParam(value = "name") String name,
                                    @RequestParam (value = "gender") String gender,
                                    @RequestParam (value = "age") int age,
                                    @RequestParam (value = "subscriptionStart") Date subscriptionStart,
                                    @RequestParam (value = "endOFSubscription") Date endOFSubscription,
                                    @RequestParam (value = "email") String email) {

        try {
//            Session session = sessionRepo.getById(id);

//            List<Session> sessionList = new ArrayList<>();
//            sessionList.add(session);

//            model.addAttribute("session",session);

            Trainee trainee = new Trainee(name,gender,age,subscriptionStart,endOFSubscription,email);
            traineeRepo.save(trainee);
            return new RedirectView("/allSession");

        }catch (Error error){
            return new RedirectView("/error");
        }



    }

    @DeleteMapping("/deleteTrainee/{id}")
    public RedirectView deleteTrainee (@PathVariable int id){

        try {
            if (traineeRepo.findById(id).isPresent()) {

                Trainee trainee = traineeRepo.getById(id);
                traineeRepo.delete(trainee);
            }
            return new RedirectView ("/allSession");

        }catch (Error error){
            return new RedirectView("/error");
        }
    }



    @PutMapping("editTrainer/{id}")
    public RedirectView editTrainee(@PathVariable int id, @RequestBody Trainee trainee){

        try {
            Trainee updateTrainee = traineeRepo.getById(id);
            updateTrainee.setName(trainee.getName());
            updateTrainee.setGender(trainee.getGender());
            updateTrainee.setAge(trainee.getAge());
            updateTrainee.setSubscriptionStart(trainee.getSubscriptionStart());
            updateTrainee.setEndOFSubscription(trainee.getEndOFSubscription());
            updateTrainee.setEmail(trainee.getEmail());

            traineeRepo.save(updateTrainee);

            return new RedirectView("/allSession");

        }catch (Error error){
            return new RedirectView("/error");

        }


    }
}
