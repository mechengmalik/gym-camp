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

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/allSession")
public class SessionController {
    @Autowired
    SessionRepo sessionRepo;

    @Autowired
    TrainerRepo trainerRepo;


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

    @GetMapping("/addSession/{id}")
    public String session(Model model,@PathVariable ("id") int id){

//        model.addAttribute("trainerData", trainerRepo.findById(id).get());

        return "allSession";
    }

    @PostMapping("/addSession/{id}")
    public RedirectView addSession (Model model,
                                    @PathVariable ("id") int id,
                                    @RequestParam(value="sessionName") String sessionName,
                                    @RequestParam(value="price") float price,
                                    @RequestParam(value="capacity") int capacity,
                                    @RequestParam(value="imgUrl") String imgUrl,
                                    @RequestParam(value="type") String type,
                                    @RequestParam(value="description") String description){


        List<Session> allSession = (List<Session>) sessionRepo.findAll();

        model.addAttribute("sessionData",allSession);


        try {


                    Trainer trainer = (Trainer) trainerRepo.findById(id).get();
                    model.addAttribute("trainer", trainer);


                    Session session = new Session(sessionName,capacity,type,description,price,imgUrl,trainer);
                    sessionRepo.save(session);



                    return new RedirectView("/allSession");


        }catch (Error error){
            System.out.println("Failed");
            return new RedirectView("/error");

        }

    }

    @DeleteMapping("/deleteSession/{id}")
    public String delete (@PathVariable int id){

        try {
            if (sessionRepo.findById(id).isPresent()){

            Session deletedSession = sessionRepo.getById(id);
            sessionRepo.delete(deletedSession);

            }
            return "session";

        }catch (Error error){
            return "error";
        }

    }

    @PutMapping("editSession/{id}")
    public RedirectView editSession(@PathVariable int id, @RequestBody Session session){

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

}
