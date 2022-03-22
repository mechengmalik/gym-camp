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
        List<Session> allSession = sessionRepo.findAll();
        model.addAttribute("allSession",allSession);

        return "allSession";
    }

    @GetMapping("/{id}")
    public String session(){
        return "allSession";
    }

    @PostMapping("/addSession/{name}")
    public RedirectView addSession (Model model,
                                    @PathVariable String name,
                                    @RequestParam(value="sessionName") String sessionName,
                                    @RequestParam(value="price") float price,
                                    @RequestParam(value="capacity") int capacity,
                                    @RequestParam(value="imgUrl") String imgUrl,
                                    @RequestParam(value="type") String type,
                                    @RequestParam(value="description") String description
//                                    @RequestParam(value="description") Trainer trainer
    ){

        try {

            Trainer trainer1 = trainerRepo.getByName(name);
//            if(trainer1.getTrainerName().toLowerCase().equalsIgnoreCase(name)){
//                trainer1.getId();
//
//            }



            Session addedSession = new Session(sessionName,capacity,type,description,price,imgUrl,trainer1);
            sessionRepo.save(addedSession);
            System.out.println("session added");
            return  new RedirectView("/allSession");

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
