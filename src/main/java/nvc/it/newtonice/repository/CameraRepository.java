package nvc.it.newtonice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.newtonice.model.Camera;

public interface CameraRepository extends MongoRepository<Camera,String>{

    public List<Camera> findAll();

    public List<Camera> findByNameContaining(String name);

    public static Object adCamera(Camera camera) {
        return null;
    }
    
    
}
