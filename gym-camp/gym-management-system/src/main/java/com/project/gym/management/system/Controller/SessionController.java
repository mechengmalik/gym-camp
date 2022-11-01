package com.project.gym.management.system.Controller;

import com.project.gym.management.system.Models.Session;
import com.project.gym.management.system.Models.Trainer;
import com.project.gym.management.system.Repositories.SessionRepo;
import com.project.gym.management.system.Repositories.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
@RequestMapping("/allSession")
public class SessionController {
    @Autowired
    SessionRepo sessionRepo;

    @Autowired
    TrainerRepo trainerRepo;

    Set trainerSet = new HashSet();

    @GetMapping("")
    public String allSession(Model model){
        List<Session> allSession = (List<Session>) sessionRepo.findAll();
        List<Trainer> trainerData = (List<Trainer>) trainerRepo.findAll();
        model.addAttribute("sessionData",allSession);
        model.addAttribute("trainerData",trainerData);


        return "allSession";
    }

    @GetMapping("/session/{id}")
    public RedirectView showSession(Model model ,@PathVariable ("id") int id){

        Session show = sessionRepo.findById(id).get();
        model.addAttribute("showSession",show);

        return new RedirectView ("/session");
    }



    @GetMapping("/addSession")
    public String showForm(){
    return "form";
    }


    @PostMapping("/addSession")
    public RedirectView addSession (Model model,
                                    @RequestParam(value="sessionName") String sessionName,
                                    @RequestParam(value="price") float price,
                                    @RequestParam(value="capacity") int capacity,
                                    @RequestParam(value="imgUrl") String imgUrl,
                                    @RequestParam(value="type") String type,
                                    @RequestParam(value="trainer") String trainer,
                                    @RequestParam(value="description") String description){

        List<Trainer> trainerData = (List<Trainer>) trainerRepo.findAll();
        List<Session> allSession = (List<Session>) sessionRepo.findAll();

        model.addAttribute("sessionData",allSession);

        try {

            Trainer associatedTrainer = trainerRepo.getByTrainerName(trainer);
//            System.out.println(associatedTrainer.getTrainerName());


            trainerSet.add(associatedTrainer);



            for (int i = 0; i < trainerSet.size(); i++) {
                if (trainerSet.contains(associatedTrainer)){

                    Session session = new Session(sessionName,capacity,type,description,price,imgUrl,associatedTrainer);
                    sessionRepo.save(session);
                }

            }

                    return new RedirectView("/allSession");


        }catch (Error error){
//            System.out.println("Failed");
//            return new RedirectView("/error");
            Session session = new Session(sessionName,capacity,type,description,price,imgUrl);
            sessionRepo.save(session);

        }
        return new RedirectView("/allSession");

    }




    @DeleteMapping("/deleteSession/{id}")
    public RedirectView delete (@PathVariable int id){

        try {
            if (sessionRepo.findById(id).isPresent()){

            Session deletedSession = sessionRepo.getById(id);
            sessionRepo.delete(deletedSession);

            }
            return new RedirectView("allSession");

        }catch (Error error){
            return new RedirectView("allSession");
        }

    }


    @GetMapping("updateSession/{id}")
    public  String updateForm(@PathVariable int id,Model model){


        Session session = sessionRepo.getById(id);



       model.addAttribute("sessionData",session);
//        System.out.println(session.getId());
        return "updateForm";

    }
//@RequestMapping(method = RequestMethod.PUT
//        , consumes = {"application/x-www-form-urlencoded"}
//        ,value = "updateSession/{id}")
//public RedirectView editSession(@PathVariable int id,@RequestBody MultiValueMap params,Session session) {

    @PutMapping("allSession/updateSession/allSession/updateSession/{id}")
    public RedirectView updateData(@PathVariable int id,Session session,Model model){

        Session sessionData = sessionRepo.getById(id);



        model.addAttribute("sessionData",sessionData);
//        System.out.println(session.getId());


    try {
        Session updateSession = sessionRepo.getById(id);

        updateSession.setCapacity(session.getCapacity());
        updateSession.setSessionName(session.getSessionName());
        updateSession.setDescription(session.getDescription());
        updateSession.setType(session.getType());
        updateSession.setPrice(session.getPrice());
        updateSession.setImgUrl(session.getImgUrl());
        updateSession.setTrainer(session.getTrainer());

        sessionRepo.save(updateSession);

        return new RedirectView("/allSession");

    }catch (Error error){
        return new RedirectView("/error");

    }

}

//    @PutMapping("updateSession/{id}")
//    public RedirectView editSession(@PathVariable int id, @RequestBody Session session, Model model){
//
//        try {
//            Session updateSession = sessionRepo.getById(id);
//
//            updateSession.setCapacity(session.getCapacity());
//            updateSession.setSessionName(session.getSessionName());
//            updateSession.setDescription(session.getDescription());
//            updateSession.setType(session.getType());
//            updateSession.setPrice(session.getPrice());
//            updateSession.setImgUrl(session.getImgUrl());
//            updateSession.setTrainer(session.getTrainer());
//
//            sessionRepo.save(updateSession);
//
//            return new RedirectView("/allSession");
//
//        }catch (Error error){
//            return new RedirectView("/error");
//
//        }
//
//
//    }

}
