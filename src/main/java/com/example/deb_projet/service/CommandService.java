package com.example.deb_projet.service;

import com.example.deb_projet.models.Command;
import com.example.deb_projet.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandService {

    @Autowired
    CommandRepository commandRepository;

    public List<Command> all(){
        return commandRepository.findAll()
;    }

    public void insert(Command command){
        commandRepository.save(command);
    }

    public Command get(int id){
        Optional<Command> commandOptional = commandRepository.findById(id);
        if(commandOptional.isPresent()){
            Command command;
            command = commandOptional.get();
            return command;
        }

        throw new RuntimeException("An error occurred");
    }

    public void destroy(int id){
        Optional<Command> commandOptional = commandRepository.findById(id);
        if(commandOptional.isPresent())
            commandRepository.deleteById(id);
    }
}
