package com.ucb.FrankyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work-flow") //esto es para las url se concatenara con los de abajo
public class WorkFlowController {

    @Autowired
    WorkFlowService workFlowService;

//    public WorkFlowController(WorkFlowService workFlowService) {
//        this.workFlowService = workFlowService;
//    }

    @GetMapping()
    public List list(){
        return workFlowService.obtainList();
    }

    @PostMapping()
    public void save(
            @RequestBody WorkFlowDto workFlowDto
    ){
        WorkFlow workFlow = new WorkFlow(
          workFlowDto.name(),
          workFlowDto.description()
        );
        this.workFlowService.create(
                workFlow
        );
    }


    // Eliminar un WorkFlow por nombre
    @DeleteMapping("/{name}")
    public String delete(@PathVariable String name) {
        boolean isDeleted = workFlowService.delete(name);
        if (isDeleted) {
            return "WorkFlow eliminado con éxito";
        } else {
            return "WorkFlow no encontrado";
        }
    }

    // Actualizar la descripción de un WorkFlow por nombre
    @PutMapping("/{name}")
    public String update(
            @PathVariable String name,
            @RequestBody WorkFlowDto workFlowDto
    ) {
        boolean isUpdated = workFlowService.update(name, workFlowDto.description());
        if (isUpdated) {
            return "WorkFlow actualizado con éxito";
        } else {
            return "WorkFlow no encontrado";
        }
    }
}
