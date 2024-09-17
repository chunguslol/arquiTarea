package com.ucb.FrankyService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkFlowService {
    List<WorkFlow> list = new ArrayList<>();


    // Obtener la lista de WorkFlows
    public List<WorkFlow> obtainList() {
        return this.list;
    }

    // Crear un nuevo WorkFlow
    public void create(WorkFlow workFlow) {
        this.list.add(workFlow);
    }





    public boolean delete(String name) {
        Optional<WorkFlow> workFlowToDelete = list.stream()
                .filter(wf -> wf.getName().equalsIgnoreCase(name))
                .findFirst();

        if (workFlowToDelete.isPresent()) {
            return list.remove(workFlowToDelete.get());
        }

        return false;
    }

    // Optional es una clase en Java que actúa como un contenedor
    // para valores que pueden o no estar presentes, evitando así el uso de null.
    // Actualizar la descripción de un WorkFlow por nombre
    public boolean update(String name, String nuevaDescripcion) {
        Optional<WorkFlow> workFlowToUpdate = list.stream()
                .filter(wf -> wf.getName().equalsIgnoreCase(name))
                .findFirst();

        if (workFlowToUpdate.isPresent()) {
            // Eliminar el WorkFlow existente
            delete(name);

            // Crear un nuevo WorkFlow con la descripción actualizada
            WorkFlow updatedWorkFlow = new WorkFlow(name, nuevaDescripcion);

            // Añadir el nuevo WorkFlow a la lista
            create(updatedWorkFlow);

            return true; // Actualización exitosa
        }

        return false; // No se encontró el elemento
    }
}
