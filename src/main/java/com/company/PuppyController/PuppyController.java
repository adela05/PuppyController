package com.company.PuppyController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PuppyController {
    private int id;
    List<Puppy> pupList;

    public PuppyController(){
        // creating an ArrayList for puppies
        pupList = new ArrayList<>();
        id = 1; // creating a unique number for each puppy
        pupList.add(new Puppy(id++, "Kru", 8, true));
        pupList.add(new Puppy(id++, "Cowboy", 23, false));
        pupList.add(new Puppy(id++, "Pickle", 1, true));
        pupList.add(new Puppy(id++, "Pepper", 12,false));
        pupList.add(new Puppy(id++, "Roxy", 20, true));

    }
    @RequestMapping(value="/puppies", method = RequestMethod.GET)
    public List<Puppy> getPuppy(){
        return pupList;
    }
    // Getting a single puppy by id
    @RequestMapping(value="/puppies/{id}", method = RequestMethod.GET)
    public Puppy getPuppybyId(@PathVariable int id){
        for (int count = 0; count < pupList.size(); count++){
            if (pupList.get(count).getId() == id){
               return pupList.get(count);
            }
        }
        return null;
    }

    // creating a POST to add new puppies to the ArrayList
    @RequestMapping(value="/puppies", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Puppy createPuppy(@RequestBody Puppy puppy){
        puppy.setId(this.id++);
        this.pupList.add(puppy);
        return puppy;
    }

    // creating a DELETE route
    @RequestMapping(value = "/puppies/{id}", method = RequestMethod.DELETE)
        @ResponseStatus(value = HttpStatus.NO_CONTENT)
        public void deletePuppy(@PathVariable int id) {
            for (int count = 0; count < this.pupList.size(); count++) {
                if (this.pupList.get(count).getId() == id) {
                    this.pupList.remove(count);
                    break;
                }
            }
    }
    // creating PUT route
    @RequestMapping(value = "/puppies/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePuppy(@PathVariable int id, @RequestBody Puppy puppy){
        for (int count = 0; count < this.pupList.size(); count++) {
            if (this.pupList.get(count).getId() == id) {
                this.pupList.set(count, puppy);
                break;
            }
        }
    }

}
