package com.project.gym.management.system.Controller;

import com.project.gym.management.system.Models.Session;
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
@RequestMapping("/allTrainee")
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

        Session sessionInfo = sessionRepo.findById(id).get();

        model.addAttribute("sessionInfo",sessionInfo);
        return ("session");
    }

    @PostMapping("/addTrainee/{id}")
    public RedirectView addTrainee (Model model,
                                    @PathVariable("id") int id,
                                    @RequestParam(value = "traineeName") String name,
                                    @RequestParam (value = "bio") String bio,
                                    @RequestParam (value = "dob") Date dob,
                                    @RequestParam (value = "subscriptionStart") Date subscriptionStart,
                                    @RequestParam (value = "endOFSubscription") Date endOFSubscription,
                                    @RequestParam (value = "email") String email) {

        List<Trainee> allTrainee = (List<Trainee>) traineeRepo.findAll();

        model.addAttribute("allTrainee",allTrainee);

        try {
            Session session = sessionRepo.findById(id).get();
            model.addAttribute("session",session);


            Trainee trainee = new Trainee(name,bio,dob,subscriptionStart,endOFSubscription,email, (List<Session>) session);
            traineeRepo.save(trainee);
            return new RedirectView("/session");

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
            updateTrainee.setTraineeName(trainee.getTraineeName());
            updateTrainee.setBio(trainee.getBio());
            updateTrainee.setDob(trainee.getDob());
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
