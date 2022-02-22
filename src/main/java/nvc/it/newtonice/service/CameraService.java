package nvc.it.newtonice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import nvc.it.newtonice.model.Camera;
import nvc.it.newtonice.model.Event;
import nvc.it.newtonice.repository.CameraRepository;

@Service
public class CameraService {
    @Autowired
    private static CameraRepository cameraRepository;

    public  List<Camera> gCameras() {
        return cameraRepository.findAll();
    }
    public static Optional<Camera> findById(String id){
        return cameraRepository.findById(id);
    }
    public List<Camera> fCameras(String name){
        return cameraRepository.findByNameContaining(name);
    }
    public Camera adCamera(Camera camera){
        return CameraRepository.save(camera);
    }
    public Optional<Product> updateProduct(String id,Product product){
        CrudRepository<Camera, String> productRepository;
        Product currentProduct = productRepository.findById(id).get();
        currentProduct.setName(product.getName());
        currentProduct.set_price(product.get_price());
        currentProduct.setUnit_in_stock(product.getUnit_in_stock());
        return Optional.of(productRepository.save(currentProduct));
    }
    public Optional<Camera> add(String id, Event event){
        Camera currenProduct = cameraRepository.findById(id).get();
        List<Event> events = currenProduct.getEvents();
        event.add(event);
        currenProduct.setEvent(event);
        return Optional.of(cameraRepository.save(currenProduct));
    }
    public static List<Camera> findAll() {
        return null;
    }
    public static Object addEvent(String id, Event event) {
        return null;
    }
    
    
}
