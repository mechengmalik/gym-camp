
package com.project.gym.management.system.Controller;

import com.project.gym.management.system.Models.Session;
import com.project.gym.management.system.Models.Trainer;
import com.project.gym.management.system.Repositories.SessionRepo;
import com.project.gym.management.system.Repositories.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/allTrainer")
public class TrainerController {

    @Autowired
    TrainerRepo trainerRepo;

    @Autowired
    SessionRepo sessionRepo;


    @GetMapping("")
    public String allTrainer(Model model){
        List<Trainer> trainer= (List<Trainer>) trainerRepo.findAll();
        model.addAttribute("trainer",trainer);

        return "allTrainer";
    }

    @GetMapping("/addTrainer")
    public String showForm(){
        return "TrainerForm";
    }

    @GetMapping("/addTrainer/{id}")
    public String newSong(@PathVariable("id") int id, Model model) {

        model.addAttribute("session", sessionRepo.findById(id).get());
        return ("allTrainer.html");
    }

    @PostMapping("/addTrainer")
    public RedirectView addTrainer (Model model,
                                    @RequestParam (value = "trainerName") String trainerName,
                                    @RequestParam (value = "bio") String bio,
                                    @RequestParam (value = "education") String education,
                                    @RequestParam (value = "specialTraining") String specialTraining,
//                                    @RequestParam (value = "imgUrl") String imgUrl,
                                    @RequestParam (value = "experience") int experience) {

        try {
//            Session session = sessionRepo.getById(id);

//            List<Session> sessionList = new ArrayList<>();
//            sessionList.add(session);

//            model.addAttribute("session",session);

            Trainer trainer = new Trainer(trainerName,bio,education,specialTraining,experience);
            trainerRepo.save(trainer);
            return new RedirectView("/allTrainer");

        }catch (Error error){
            return new RedirectView("/error");
        }



    }

    @DeleteMapping("/deleteTrainer/{id}")
    public RedirectView deleteTrainer (@PathVariable int id){

        try {
            if (trainerRepo.findById(id).isPresent()) {

                Trainer trainer = trainerRepo.getById(id);
//                trainer.setSessions(null);
                List<Session> se = trainer.getSessions();
                for (Session s :se){
                    s.setTrainer(null);

                }

//                trainerRepo.save(trainer);
                trainerRepo.delete(trainer);

            }
            return new RedirectView ("/allTrainer");

        }catch (Error error){
            return new RedirectView("/error");
        }
    }



    @PutMapping("editTrainer/{id}")
    public RedirectView editTrainer(@PathVariable int id, @RequestBody Trainer trainer){

        try {
            Trainer updateTrainer = trainerRepo.getById(id);
            updateTrainer.setTrainerName(trainer.getTrainerName());
            updateTrainer.setBio(trainer.getBio());
            updateTrainer.setEducation(trainer.getEducation());
            updateTrainer.setSpecialTraining(trainer.getSpecialTraining());
            updateTrainer.setExperience(trainer.getExperience());

            trainerRepo.save(updateTrainer);

            return new RedirectView("/allSession");

        }catch (Error error){
            return new RedirectView("/error");

        }


    }

}

