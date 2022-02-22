package nvc.it.newtonice.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nvc.it.newtonice.model.Camera;
import nvc.it.newtonice.model.Event;
import nvc.it.newtonice.repository.CameraRepository;
import nvc.it.newtonice.service.CameraService;

@Controller
@RequestMapping("/camera")
public class CameraController {
    @Autowired
    CameraService cameraService;

   @GetMapping("")
    public ModelAndView camera () {
        List<Camera> cameras = CameraService.findAll();
        return new ModelAndView("camera", "camera", cameras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Serch By Id Susses!");
        map.put("date", CameraService.findById(id));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> addProduct(@RequestBody Camera camera){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Add Product Susses!");
        map.put("date", CameraRepository.adCamera(camera));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> addReview(@PathVariable String id, @RequestBody Event event){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Review Product Susses!");
        map.put("date", CameraService.addEvent(id,event));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }





    
}
