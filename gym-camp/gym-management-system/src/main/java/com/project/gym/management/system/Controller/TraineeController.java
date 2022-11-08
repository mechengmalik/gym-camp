package com.project.gym.management.system.Controller;

import com.project.gym.management.system.Models.Session;
import com.project.gym.management.system.Models.Trainee;
import com.project.gym.management.system.Repositories.SessionRepo;
import com.project.gym.management.system.Repositories.TraineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
@RequestMapping("/allTrainee")
public class TraineeController {
    @Autowired
    TraineeRepo traineeRepo;

    @Autowired
    SessionRepo sessionRepo;




  List<Object> traineeSession = new ArrayList<>();




    @GetMapping("")
    public String allTrainee(Model model) {
        List<Trainee> trainee = (List<Trainee>) traineeRepo.findAll();
        model.addAttribute("trainee", trainee);

        return "allTrainee";
    }

    @GetMapping("/addTrainee")
    public String showForm(){
        return "TraineeForm";
    }

    @PostMapping("/addTrainee")
    public RedirectView addTrainee(Model model,
                             @RequestParam(value = "traineeName") String traineeName,
                             @RequestParam(value = "gender") String gender,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "phoneNumber") Integer phoneNumber,
                             @RequestParam(value = "socialNumber") Integer socialNumber) {
     try{
        Trainee newTrainee = new Trainee(traineeName,gender,socialNumber,phoneNumber,email);
        traineeRepo.save(newTrainee);

        return new RedirectView("/allTrainee");
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
            return new RedirectView ("/allTrainee");

        }catch (Error error){
            return new RedirectView("/error");
        }
    }



    @PutMapping("editTrainer/{id}")
    public RedirectView editTrainee(@PathVariable int id, @RequestBody Trainee trainee){

        try {
            Trainee updateTrainee = traineeRepo.getById(id);
            updateTrainee.setTraineeName(trainee.getTraineeName());
//            updateTrainee.setDob(trainee.getDob());
//            updateTrainee.setSubscriptionStart(trainee.getSubscriptionStart());
//            updateTrainee.setEndOFSubscription(trainee.getEndOFSubscription());
            updateTrainee.setEmail(trainee.getEmail());

            traineeRepo.save(updateTrainee);

            return new RedirectView("/allSession");

        }catch (Error error){
            return new RedirectView("/error");

        }


    }

//    @PostMapping("/addTrainee/{id}")
//    public String addTrainee(Model model,
//                             @PathVariable("id") int id,
//                             @RequestParam(value = "traineeName") String traineeName,
//                             @RequestParam(value = "gender") String gender,
//                             @RequestParam(value = "email") String email,
//                             @RequestParam(value = "phoneNumber") Integer phoneNumber,
//                             @RequestParam(value = "socialNumber") Integer socialNumber) {
//
//        List<Trainee> allTrainee = (List<Trainee>) traineeRepo.findAll();
//
//        Session session = sessionRepo.getById(id);
//        Trainee oldTrainee = traineeRepo.getByEmail(email);
//        List  trainees = new ArrayList<>();
//
//
//
//        model.addAttribute("allTrainee", allTrainee);
//        model.addAttribute("sessionInfo", session);
//
//        boolean check = session.getTrainee().contains(oldTrainee);
//
//        if (oldTrainee != null && traineeRepo.existsById(oldTrainee.getId()) && !check) {
//            try {
//                trainees.add( session.getTrainee());
//                trainees.add(oldTrainee);
//                session.setTrainee(trainees);
//                sessionRepo.save(session);
//
//
//                return "session";
//
//            }catch (Error error){
//                return "error";
//            }
//        }else {
//            Trainee newTrainee = new Trainee(traineeName,email);
//            traineeRepo.save(newTrainee);
//            trainees.add( session.getTrainee());
//            trainees.add(newTrainee);
//
//            session.setTrainee(trainees);
//            sessionRepo.save(session);
//            return "session";
//        }
//    }

//    @PostMapping("/addTrainee/{id}")
//    public String addTrainee(Model model,
//                             @PathVariable("id") int id,
//                             @RequestParam(value = "traineeName") String traineeName,
//                             @RequestParam(value = "bio") String bio,
////                                    @RequestParam (value = "dob") Date dob,
////                                    @RequestParam (value = "subscriptionStart") Date subscriptionStart,
////                                    @RequestParam (value = "endOFSubscription") Date endOFSubscription,
//                             @RequestParam(value = "email") String email) {
//
//        List<Trainee> allTrainee = (List<Trainee>) traineeRepo.findAll();
//
//        Session session = sessionRepo.getById(id);
//        Trainee oldTrainee = traineeRepo.getByEmail(email);
//        Set<Trainee> set = new HashSet<>();
//
//
//
//        model.addAttribute("allTrainee", allTrainee);
//        model.addAttribute("sessionInfo", session);
//
//
//        if (oldTrainee!=null && traineeRepo.existsById(oldTrainee.getId())) {
//            try {
//                Set<Session> traineeSession = new HashSet<>();
//
//                traineeSession.add((Session) oldTrainee.getSessions());
//                traineeSession.add(session);
//
//                set.add(oldTrainee);
//                oldTrainee.setSessions(traineeSession);
//
//                session.setTrainee(set);
//                traineeRepo.save(oldTrainee);
////                sessionRepo.save(session);
//                return "session";
//
//
////            if (traineeRepo.findById(traineeRepo.getByEmail(email).getId()).isPresent()) {
//
//
//            } catch (Exception exception) {
//
//                Trainee newTrainee = new Trainee(traineeName, bio, email);
//                set.add(newTrainee);
//
//                traineeRepo.save(newTrainee);
//
//
//                session.setTrainee(set);
//                System.out.println(newTrainee + "s2s2s2s2s2s2s2s2s");
//
//                sessionRepo.save(session);
////            newTrainee.setSessions(traineeSession);
////            traineeRepo.save(newTrainee);
//
//
////                Trainee oldTrainee = traineeRepo.getByEmail(email);
////                int existTrainee = oldTrainee.getId();
//
////                if (traineeRepo.findById(existTrainee).isPresent())
//
////                    oldTrainee.setSessions(traineeSession);
//
////                    traineeRepo.save(oldTrainee);
//                return "session";
//
//
//            } catch (Error error) {
//                return "error";
//            }
//
//        }else {
//            try {
//                Trainee newTrainee = new Trainee(traineeName, bio, email);
//                set.add(newTrainee);
//                traineeRepo.save(newTrainee);
//
//                List<Trainee> traineeSession = new ArrayList<>();
//                traineeSession.add((Trainee) session.getTrainee());
//                session.setTrainee((Set<Trainee>) traineeSession);
//                System.out.println(newTrainee + "s2s2s2s2s2s2s2s2s");
//
//                sessionRepo.save(session);
//                return "session";
//
//
//            }catch (Error error){
//                return "error";
//
//            }
//        }
//    }




}
